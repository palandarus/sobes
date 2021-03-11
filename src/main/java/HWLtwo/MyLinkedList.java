package HWLtwo;

public class MyLinkedList <T>{
    private Node<T> head;
    private Node<T> tail;

    private class Node<T>{
        private Node<T> previous;
        private Node<T> next;

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}
