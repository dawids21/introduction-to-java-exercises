package dawidstasiak;

import java.util.Arrays;

public class GenericStack<E> {
    private E[] array;
    private int size;

    public GenericStack() {
        array = (E[]) new Object[1];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public E peek() {
        if (size > 0) {
            return array[getSize() - 1];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void push(E element) {
        if (array.length == size + 1) {
            array = extendArray(array);
        }
        array[size] = element;
        size++;
    }

    public E pop() {
        E element = array[getSize() - 1];
        size--;
        return element;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public String toString() {
        var string = new StringBuilder("stack: [");
        var arraySize = getSize();
        for (var i = 0; i < arraySize; i++) {
            string.append(array[i].toString());
            string.append(i == arraySize - 1 ? "]" : ", ");
        }
        return string.toString();
    }

    private E[] extendArray(E[] array) {
        int sizeCurrent = array.length;
        E[] arrayNew = (E[]) new Object[sizeCurrent * 2];
        System.arraycopy(array, 0, arrayNew, 0, sizeCurrent);
        return arrayNew;
    }
}
