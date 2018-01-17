public interface Stack<E> {

    void push (E newElement);
    E pop();
    E peek();
    void grow(int additionalSize);
    Boolean isEmpty();
    Boolean isFull();
    int getSize();
}
