package sus.amogus.practice_2;

public interface Box<T> {
    T open();
    void put(T item);
    T removeFromBox();
}
