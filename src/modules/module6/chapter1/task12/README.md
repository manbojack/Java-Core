### [Условие:]()

>В классе Box из прошлой задачи нужно добавить статический метод getBox(), 
который возвращает пустой параметризованный объект типа Box,

>Требования:
>1. Класс должен быть параметризован T.
>2. Поле должно быть приватным с именем object.
>3. Класс должен иметь публичный модификатор доступа.
>4. Класс должен иметь публичный статический метод getBox().
>5. метод getBox() должен работать согласно условию..
>6. Класс Box должен быть статическим.

### [Решение:]()
```java
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
```
