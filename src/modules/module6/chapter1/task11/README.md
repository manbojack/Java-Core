### [Условие:]()

>Создайте дженерик класс Box, который может хранить в себе один объект класса, 
которым он параметризирован в поле с названием object.

>Требования:
>1. Класс должен быть параметризован T.
>2. Поле должно быть приватным с именем object.
>3. Класс должен иметь модификатор доступа по умолчанию.

### [Решение:]()
```java
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
```
