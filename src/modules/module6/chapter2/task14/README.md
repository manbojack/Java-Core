### [Условие:]()
>Магазину нужно сохранять информацию о продажах для каждого сотрудника. 
Напишите метод `Map getSalesMap(Reader reader)` который принимает 
`Reader` содержащий строки вида:

>Алексей 3000  
Дмитрий 9000  
Антон 3000  
Алексей 7000  
Антон 8000

>Метод должен получить все строки из Readera и заполнить и вернуть 
карту где ключом будет имя сотрудника, а значением сумма всех его продаж.  

>Пример ввода:
> 
>Алексей 3000  
Дмитрий 9000  
Антон 3000  
Алексей 7000  
Антон 8000  
> 
>Пример вывода:    
{Алексей=[10000], Дмитрий=[9000], Антон=[11000]}

>Требования:
>1. Должен быть метод `public static Map<String, Long> getSalesMap(Reader reader)`
>2. Работа метода `getSalesMap` должна удовлетворять условию

### [Решение #1:]()
```java
public static Map<String, Long> getSalesMap(Reader reader) throws IOException {
    Map<String, Long> map = new HashMap<>();
    Scanner scanner = new Scanner(reader);
    while (scanner.hasNext()) {
        String name = scanner.next();
        Long sales = scanner.nextLong();
        if (map.get(name) == null) {
            map.put(name, sales);
        } else {
            map.put(name, map.get(name) + sales);
        }
    }
    return map;
}
```
### [Решение #2:]()
```java
public static Map<String, Long> getSalesMap(Reader reader) throws IOException {
    Map<String, Long> map = new HashMap<>();
    Scanner scanner = new Scanner(reader);
    while (scanner.hasNext()) {
        map.merge(scanner.next(), scanner.nextLong(), Long::sum);
    }
    return map;
}
```
