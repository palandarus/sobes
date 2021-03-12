package HWLtwo;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private MyIterator<T> iterator;


    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
        iterator = new MyIterator<>(head);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        T searchElement = (T) o;

        return iterator.findIndexOf(searchElement) != -1;
    }

    public MyIterator<T> iterator() {
        return iterator;
    }

    public Object[] toArray() {
        T[] array = (T[]) new Object[size];
        iterator.reset();
        for (int i = 0; i < size; i++) {
            array[i] = iterator.currentElement.value;
            if(iterator.next()==null) return array;
        }
        return array;
    }

    public boolean add(T t) {
        if (size == 0) head = new Node(t);
        else if (size == 1) {
            tail = new Node<>(t);
            head.next = tail;
            tail.previous = head;
        } else {
            Node<T> oldTail = tail;
            tail = new Node<>(t);
            oldTail.next = tail;
            tail.previous = oldTail;
        }
        iterator.reset();
        return true;
    }


    @Override
    public String toString() {
        Node currentNode = head;
        StringBuilder result = new StringBuilder("MyLinkedList [ ");
        while (currentNode.hasNext()) {
            result.append(currentNode);
            currentNode = currentNode.getNext();
            if (currentNode == null) {
                result.append("]");
            } else {
                result.append(" , ");
            }
        }


        return result.toString();
    }

    public boolean remove(Object o) {
        T removingValue = (T) o;
        iterator.reset();
        if (iterator.findIndexOf(removingValue) == -1) throw new NoSuchElementException();
        iterator.removeCurrent();
        return true;
    }


    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        iterator.reset();
    }

    public T get(int index) {
        checkIndex(index);
        iterator.reset();
        return iterator.findByIndex(index);

    }

    public boolean set(int index, T element) {
        checkIndex(index);
        iterator.reset();
        iterator.findByIndex(index);
        iterator.currentElement.value = element;
        return true;

    }

    public boolean add(int index, T element) {
        checkIndex(index);
        iterator.findByIndex(index);
        iterator.insertBefore(element);
        iterator.reset();
        return true;

    }

    public T remove(int index) {
        checkIndex(index);
        return iterator.remove(index);
    }

    public int indexOf(T o) {
        iterator.reset();
        int result=iterator.findIndexOf(o);
        if(result==-1) throw new NoSuchElementException();
        else return result;
    }

    private boolean checkIndex(int index) {
        if (index >= 0 && index < size) return true;
        else throw new IndexOutOfBoundsException();
    }


    private class Node<N> {
        private Node<N> previous;
        private Node<N> next;
        private N value;

        public Node(N value) {
            this.value = value;
        }

        public Node(Node<N> previous, Node<N> next, N value) {
            this.previous = previous;
            this.next = next;
            this.value = value;
        }

        public Node(Node<N> node) {
            this.next = node.getNext();
            this.next = node.getPrevious();
            this.value = node.getValue();
        }

        public N getValue() {
            return value;
        }

        public boolean hasNext() {
            return previous != null;
        }

        public boolean hasPrevious() {
            return previous != null;
        }

        public Node<N> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<N> previous) {
            this.previous = previous;
        }

        public Node<N> getNext() {
            return next;
        }

        public void setNext(Node<N> next) {
            this.next = next;
        }
    }

    private class MyIterator<I> {
        private Node<I> currentElement;
        private int position;

        public MyIterator(Node<I> element) {
            this.currentElement = element;
            position = 0;
        }

        public boolean hasNext() {

            return currentElement.hasNext();
        }

        public I next() {
            if (atEnd()) return null;
            else {
                currentElement = currentElement.next;
                position++;
                return currentElement.value;
            }
        }

        public boolean hasPrevious() {
            return currentElement.hasPrevious();
        }

        public I previous() {
            if(atStart()) return null;
            else {
                currentElement=currentElement.previous;
                position--;
                return currentElement.value;
            }
        }

        public int nextIndex() {
            return currentElement.hasNext() ? position + 1 : -1;
        }

        public int previousIndex() {
            return currentElement.hasPrevious() ? position - 1 : -1;
        }

        public void removeCurrent() {
            if (position == 0) {
                if (!currentElement.hasNext()) {
                    head = null;
                    size = 0;
                    reset();
                } else {
                    head = (Node<T>) currentElement.next;
                    currentElement.next.previous = null;
                }
            } else {
                if (currentElement.hasNext()) {
                    currentElement.previous.next = currentElement.next;
                    currentElement.next.previous = currentElement.previous;
                    size--;
                    reset();
                }
            }
            reset();
        }

        public void set(I t) {
            currentElement.value = t;
        }

        public void insertBefore(I t) {
            Node<I> insertElement = new Node(t);
            insertElement.next = currentElement;
            if (atStart()) {
                insertElement.previous = null;
                head = (Node<T>) insertElement;
            } else {
                insertElement.previous = currentElement.previous;
                currentElement.previous.next = insertElement;
            }
            currentElement.previous = insertElement;
            size++;
        }

        public void insertAfter(I t) {
            Node<I> insertElement = new Node(t);
            insertElement.previous = currentElement;
            if (atEnd()) {
                insertElement.next = null;
                tail = (Node<T>) insertElement;
            } else {
                insertElement.next = currentElement.next;
                currentElement.next.previous = currentElement;
            }
            currentElement.next = insertElement;
            size++;
        }

        public void reset() {
            currentElement = (Node<I>) head;
            position = 0;
        }

        public boolean atStart() {
            return currentElement.getPrevious() != null ? false : true;
        }

        public boolean atEnd() {
            return currentElement.getNext() != null ? false : true;
        }

        public int findIndexOf(I searchElement) {
            while (currentElement.hasNext()) {
                if (searchElement.equals(currentElement.value)) return position;
                currentElement = currentElement.next;
                position++;
            }
            return -1;
        }


        public I remove(int index) {
            I removedValue=findByIndex(index);
            removeCurrent();
            return removedValue;
        }

        public I findByIndex(int index) {
            reset();
            for (int j = 0; j < index; j++) {
                currentElement = currentElement.next;
            }
            return currentElement.value;
        }
    }
}
