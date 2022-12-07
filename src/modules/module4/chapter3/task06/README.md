### [Условие:]()
>Создайте в статичном публичном методе `logging` логгер с именем 
`com.javamentor.logging.Test`, залогируйте им два сообщения: первое "Все хорошо" 
с уровнем `INFO` и второе "Произошла ошибка" с уровнем `WARNING`.

>`java.util.logging.*`  импортирован за вас

### [Решение:]()
```java
public static void logging() {
    final Logger testLogger = Logger.getLogger("com.javamentor.logging.Test");
    testLogger.log(Level.INFO, "Все хорошо");
    testLogger.log(Level.WARNING, "Произошла ошибка");
}
```
