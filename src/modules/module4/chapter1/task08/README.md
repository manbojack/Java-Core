### [Условие:]()
>Создайте новое проверяемое исключение `MyNewException`, и создайте 
метод `testExp()`, который выбрасывает `MyNewException` при вызове.

>Требования:  
>1. Метод `testExp()` должен быть публичным и иметь тип возвращаемого значения `void`.
>2. Класс исключения должен иметь модификатор доступа по умолчанию.
>3. Метод `testExp()` расположите вне класса исключения.

### [Решение:]()
```java
class MyNewException extends Exception {
    MyNewException(String msg) {
        super(msg);
    }
}

public void testExp() throws MyNewException {
    throw new MyNewException("Don't worry, it's just test exception");
}
```
