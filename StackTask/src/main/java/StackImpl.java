import java.util.EmptyStackException;

public class StackImpl<E> implements Stack<E> {

    E[] elements;
    int size;

    public StackImpl(int maxSize){
        elements = (E[]) new Object[maxSize];
        size = 0;
    }

    @Override
    public void push(E newElement) {
        try {
            elements[size++] = newElement;
        } catch (ArrayIndexOutOfBoundsException ex){ ex.printStackTrace();}
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E lastElement = elements[--size];
        elements[size] = null;
        return lastElement;
    }

    @Override
    public E peek() {
        if (size == 0){
            throw new EmptyStackException();
        }
        return elements[size - 1];
    }

    @Override
    public void grow(int additionalSize) {
       E[] updatedStack = (E[]) new Object[elements.length + additionalSize];
       for(int i = 0; i<size; i++){
           updatedStack[i] = elements[i];
        }
        elements = updatedStack;
    }


    @Override
    public Boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Boolean isFull() {
        return (elements.length == size);
    }

    @Override
    public int getSize() {
        return size;
    }
}
