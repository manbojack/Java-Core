### [Условие:]()

>Реализуйте метод, который зачитает данные из `InputStream` и преобразует их в строку, 
используя заданную кодировку.

>Пример:  
`InputStream` последовательно возвращает четыре байта: 48 49 50 51.  
Метод, вызванный для такого `InputStream` и кодировки ASCII, должен вернуть 
строку: "0123".

>Требования:
>1. Метод должен быть публичным.
>2. Сигнатура метода должна быть: `readAsString(InputStream inputStream, Charset charset)`

### [Решение:]()
```java
public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
    ByteArrayOutputStream result = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int length;
    while ((length = inputStream.read(buffer)) != -1) {
        result.write(buffer, 0, length);
    }
    return result.toString(charset);
}

```
