[//]: # (3.5.6)
### [Условие:]()

>Напишите статический класс AsciiCharSequence, реализующий компактное хранение последовательности 
ASCII-символов (их коды влезают в один байт) в массиве байт. По сравнению с классом String из Java 8, 
хранящим каждый символ как char, AsciiCharSequence будет занимать в два раза меньше памяти

>Класс AsciiCharSequence должен:
>
>- реализовывать интерфейс java.lang.CharSequence;  
>- иметь конструктор, принимающий массив байт;  
>- определять методы length(), charAt(), subSequence() и toString()

>Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса 
java.lang.CharSequence (JavaDoc или исходники).

>В данном задании методам charAt() и subSequence() всегда будут подаваться корректные 
входные параметры, поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.

### [Решение:]()
```java
public static class AsciiCharSequence implements CharSequence {
    private final byte[] bytes;
    
    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes;
    }
    
    @Override
    public int length() {
        return bytes.length;
    }
    
    @Override
    public char charAt(int index) {
        return (char) bytes[index];
    }
    
    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(java.util.Arrays.copyOfRange(bytes, start, end));
    }
    
    @Override
    public String toString() {
        return new String(bytes);
    }
}
```
