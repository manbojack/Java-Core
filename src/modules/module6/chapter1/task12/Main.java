package modules.module6.chapter1.task12;

public class Main {
    public static void main(String[] args) {
        Box<Object> box1 = new Box<>("box1");
        System.out.println(box1.getBox());

    }

public static class Box<T> {
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

    public static <T> Box<T> getBox() {
        return new Box<T>(null);
    }
}
}
