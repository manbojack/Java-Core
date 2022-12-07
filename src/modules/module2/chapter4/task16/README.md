### Условие:

>Напишите метод `printOddNumbers`, который принимает массив и выводит в консоль только 
нечетные числа из него, через запятую. Конец вывода должен перевести курсор на новую строку.

>Пример ввода: `[3,5,20,8,7,3,100]`  
>Пример вывода: `3,5,7,3`

>Требования:  
>Сигнатура метода должна быть: `printOddNumbers(int[] arr)`

### [Решение:]()
```java
public static void printOddNumbers(int[] arr) {
    StringBuilder result = new StringBuilder();
    for (int a : arr) {
        if (a % 2 != 0) {
            result.append(a).append(",");
        }
    }
    if (result.length() == 0) {
        return;
    }
    System.out.println(result.deleteCharAt(result.length() - 1));
}
```