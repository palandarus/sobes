package HWLtwo;

import lombok.Data;

@Data
public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] arr;
    private int number;
    private int capacity;

    public MyArrayList() {
        capacity = DEFAULT_CAPACITY;
        arr = (T[]) new Object[capacity];
        number = 0;
    }

    public boolean add(T value) {
        autoEnsureCapacity(1);
        arr[number] = value;
        number++;
        return true;
    }

    private void autoEnsureCapacity(int quantity) {
        if (number + quantity > capacity) {
            capacity *= 2;
            autoEnsureCapacity(number + quantity);
        }

    }

    public T remove(int index) {
        checkIndexOutOfBound(index);
        T oldValue = arr[index];
        System.arraycopy(arr, index + 1, arr, index, number - index - 1);
        number--;
        arr[number] = null;
        return oldValue;
    }

    public T get(int index) {
        checkIndexOutOfBound(index);
        return arr[index];
    }

    public boolean isEmpty() {
        return number == 0;
    }

    public void insert(int index, T value) {
        checkIndexOutOfBound(index);
        autoEnsureCapacity(1);
        System.arraycopy(arr, index, arr, index + 1, number - index);
        arr[index] = value;
        number++;

    }

    public void print() {
        for (int i = 0; i < number; i++) {
            System.out.println(arr[i]);
        }
    }

    public int indexOf(T value) {
        int index=-1;
        for (int i = 0; i < number; i++) {
            if(arr[i].equals(value)) index=i;
        }
        return index;
    }

    public void ensureCapacity(int newCapacity){
        if(capacity<newCapacity){
            T[] tempArr = (T[]) new Object[newCapacity];
            System.arraycopy(arr, 0, tempArr, 0, arr.length);
            arr = tempArr;
        }
    }

    public T set(int index, T value){
        checkIndexOutOfBound(index);
        T oldElement=arr[index];
        arr[index]=value;
        return oldElement;
    }

    public boolean contains(T value){
        return indexOf(value)!=-1;
    }

    private void checkIndexOutOfBound(int index) {
        if (index >= number || index < 0) throw new IndexOutOfBoundsException();
    }


}
