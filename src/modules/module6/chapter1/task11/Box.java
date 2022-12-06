package modules.module6.chapter1.task11;

public class Box<T> {
    private T object;

    Box(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
