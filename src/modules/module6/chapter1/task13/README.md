### [Условие:]()

>Реализуйте generic-класс `Pair`, похожий на `Optional`, но содержащий пару элементов 
разных типов и не запрещающий элементам принимать значение `null`.

>Реализуйте методы `getFirst()`, `getSecond()`, `equals()` и `hashCode()`, а 
также статический фабричный метод `of()`. Конструктор должен быть закрытым `(private)`.

>С корректно реализованным классом Pair должен компилироваться и успешно работать 
следующий код:
```java
Pair<Integer, String> pair = Pair.of(1, "hello");
Integer i = pair.getFirst(); // 1
String s = pair.getSecond(); // "hello"
Pair<Integer, String> pair2 = Pair.of(1, "hello");
boolean mustBeTrue = pair.equals(pair2); // true! 
boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
```
>Пожалуйста, не меняйте модификатор доступа класса `Pair`. Для корректной проверки 
класс должен иметь пакетную видимость.

### [Решение:]()
```java
public static class Pair<K, V> {
    private K first;
    private V second;

    private Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public static <K, V> Pair<K, V> of(K first, V second) {
        return new Pair<>(first, second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return (Objects.equals(first, pair.first) & Objects.equals(second, pair.second));
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
```
