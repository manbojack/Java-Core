### [Условие:]()
>Реализуйте метод `symmetricDifference`, вычисляющий симметрическую разность 
двух множеств. Метод должен возвращать результат в виде нового множества. 
Изменять переданные в него множества не допускается.

>Пример ввода: `[1, 2, 3}` и `{0, 1, 2]`   
Пример вывода: `[0, 3]`

>Требования:
>1. должен быть метод `public static Set symmetricDifference(Set set1, Set set2)`
>2. метод `symmetricDifference` не должен изменять исходные множества
>3. метод `symmetricDifference` должен возвращать корректный результат

### [Решение:]()
```java
public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
    Set<T> result = new HashSet<>(set1);
    result.addAll(set2);
    Set<T> tmp = new HashSet<>(set1);
    tmp.retainAll(set2);
    result.removeAll(tmp);
    return result;
}
```
