### [Условие:]()

>Напишите метод `void print(InputStream inputStream, OutputStream outputStream)` 
который принимает `InputStream` и `OutputStream`, считывает все байты из `inputStream` и 
записывает в `OutputStream` только четные.

>Пример ввода: 3, 10, 4, 5, 7  
Пример вывода: 10, 4

>Требования:
>1. Метод должен быть публичным.
>2. Параметры должны иметь тип `InputStream` `inputStream` и `OutputStream` `outputStream`.
>3. Сигнатура метода должна быть: `print(InputStream inputStream, OutputStream outputStream)`

### [Решение:]()
```java
public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
    int buffer;
    while ((buffer = inputStream.read()) != -1) {
        if ((byte) buffer % 2 == 0) {
            outputStream.write((byte) buffer);
        }
    }
    outputStream.flush();
}
```
