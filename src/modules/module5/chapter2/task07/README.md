### [Условие:]()
>Напишите метод `int sumOfStream(InputStream inputStream)`, который принимает `InputStream`
и возвращает сумму всех его элементов.

>Пример ввода: 1, 2, 4, 10  
Пример вывода: 17

>Требования:
>1. Метод должен быть публичным.
>2. Параметр должен иметь тип `InputStream`.
>3. Сигнатура метода должна быть: `sumOfStream(InputStream inputStream)`

### [Решение:]()
```java
public int sumOfStream(InputStream inputStream) throws IOException {
    int result = 0;
    int buffer;
    while ((buffer = inputStream.read()) != -1) {
        result += (byte) buffer;
    }
    return result;
}
```
