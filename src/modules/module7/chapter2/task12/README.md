### [Условие:]()

>Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем 
частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов.

>Словом будем считать любую непрерывную последовательность символов, состоящую только 
из букв и цифр. Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: 
"Мама", "мыла", "раму", "33" и "раза".

>Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — 
это одно и то же слово. Выводите слова в нижнем регистре.

>Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
>
>Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте, то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.

>Задача имеет красивое решение через стримы без циклов и условных операторов. 
Попробуйте придумать его.

><b>Пример ввода 1:</b>  
>Мама мыла-мыла-мыла раму!
> 
><b>Пример вывода 1:</b>  
>мыла  
>мама  
>раму

><b>Пример ввода 2:</b>  
>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.
>
><b>Пример вывода 2:</b>  
>consectetur  
faucibus  
ipsum  
lorem  
adipiscing  
amet  
dolor  
eget  
elit  
mi  

>Требования:
>1. Должен быть метод public static void main(String[] args)
>2. Программа должна читать данные с консоли
>3. Программа должна писать данные в консоль

### [Решение:]()
```java
public static void main(String[] args) {
    java.util.HashMap<String, Long> result = (java.util.HashMap<String, Long>)
            new java.io.BufferedReader(new java.io.InputStreamReader(System.in, java.nio.charset.StandardCharsets.UTF_8))
                    .lines().flatMap(line -> java.util.stream.Stream.of(line.split("[\\p{Punct}\\s]+")))
                    .map(String::toLowerCase)
                    .collect(java.util.stream.Collectors.groupingBy(java.util.function.Function.identity(), java.util.stream.Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(java.util.Map.Entry.comparingByKey())
                    .sorted(java.util.Collections.reverseOrder(java.util.Map.Entry.comparingByValue()))
                    .limit(10)
                    .collect(java.util.stream.Collectors.toMap(java.util.Map.Entry::getKey, java.util.Map.Entry::getValue, (e1, e2) -> e2, java.util.LinkedHashMap::new));

    result.forEach((key, value) -> System.out.println(key));
}
```
