## 4. Обработка ошибок, исключения, отладка
- ### 

### 4. Обработка ошибок, исключения, отладка
###
#### Что такое исключение? Для чего они нужны?
> Исключение - это ошибка во время выполнения программы. Самый простой пример - деление на ноль.
Можно вручную отслеживать возникновение подобных ошибок, а можно воспользоваться специальным механизмом исключений,
который упрощает создание больших надёжных программ,
уменьшает объём необходимого кода и повышает уверенность в том, что в приложении не будет необработанной ошибки.

#### Расскажи про иерархию исключений?
> Исключения делятся на несколько классов, но все они имеют общего предка — класс Throwable. Его потомками являются подклассы Exception и Error.
Исключения (Exceptions) являются результатом проблем в программе, которые в принципе решаемы и предсказуемы. Например, произошло деление на ноль в целых числах.
Ошибки (Errors) представляют собой более серьёзные проблемы, которые, согласно спецификации Java, не следует пытаться обрабатывать в собственной программе, поскольку они связаны с проблемами уровня JVM. Например, исключения такого рода возникают, если закончилась память, доступная виртуальной машине. Программа дополнительную память всё равно не сможет обеспечить для JVM.

#### В чём разница между проверяемыми исключениями и непроверяемыми? В чём разница с точки зрения синтаксиса и идеологическая при использовании?
> проверяемые исключения проверяются на стадии компиляции и можно в некоторых случаях рассматривать как не ошибку, а как исключительная ситуация
(например, отсутвие файла при попытке открыть его)
непроверяемые, соответственно не проверяются на этапе компиляции.

#### Можно ли обработать непроверяемое исключение?
> можно и нужно, например деление на нуль - непроверяемое исключение.

#### Нужно ли ловить Error исключения?
> Ошибки (Errors) представляют собой более серьёзные проблемы, которые, согласно спецификации Java,
не следует пытаться обрабатывать в собственной программе, поскольку они связаны с проблемами уровня JVM.
Исключения (Exceptions) являются результатом проблем в программе, которые в принципе решаемы и предсказуемы.
Например, произошло деление на ноль в целых числах.
В Java все исключения делятся на два типа: контролируемые исключения (checked) и неконтролируемые исключения (unchecked),
к которым относятся ошибки (Errors) и исключения времени выполнения (RuntimeExceptions, потомок класса Exception).
Контролируемые исключения представляют собой ошибки, которые можно и нужно обрабатывать в программе,
к этому типу относятся все потомки класса Exception (но не RuntimeException).

#### Как бросить исключение? Можно ли бросить НЕ новое исключение?
>- throw new Exception(); - бросает новое исключение
>- e.printStackTrace(); - печатает пойманное исключение

#### Расскажи про информацию, которая находится внутри исключения? Как с ней работать?
> через метод e.printStackTrace() можжно вывести всю информацию:
> тип исключения, номер строки и какой метод вызвал

#### Что такое подавленные исключения? Как достать подавленное исключение?
> подавление исключения - это его игнорирование каким-либо способом
> достать подавленное исключение можно методом getSuppressed()

#### Какую информацию можно получить из StackTraceElement?
>- getClassName(): Возвращает полное имя класса, содержащего точку выполнения, представленную этим элементом трассировки стека.
>- getFileName(): Возвращает имя исходного файла, содержащего точку выполнения, представленную этим элементом трассировки стека.
>- getLineNumber()
>- getMethodName()
>- isNativeMethod():  
#### Расскажи про конструкцию try-catch-finally?
> один try, потом обязательно должны быть
>- либо несколько catch,
>- либо один finally,
>- либо несколько catch + finally

#### Что такое try-with-resources? Как работает эта конструкция?
> в try (тут передаём ресурсы), и если класс Autoclosable, 
>то автоматически срабатывает метод close();

#### Расскажи, как правильно ловить исключения? Иерархия catch блоков?
> сверху должны быть потомки от Exception иначе - ошибка компиляции.

#### Можно ли одном catch обработать несколько исключений?
> можно

#### Что делает оператор throws?
> Оператор throws используется в объявлении метода для того, чтобы сообщить вызывающему коду о том,
что данный метод может генерировать исключение, которое он не обрабатывает.
Это касается всех исключений кроме: классов Error и RuntimeException; любых подклассов, которые
унаследованы от классов Error и RuntimeException.

#### Что если в блоке catch вылетело исключение? или оно будет подавлено?
> Если оно не ловится и не обрабатывается, то его обработает 
> JVM и выполнение программы остановится.

#### Что если блок finally выбросит исключение?
>Когда исключение не случилось в try, но случилось в finally это исключение, как обычно, пойдет вверх по стеку вызовов,
пока не попадется в соответствующий ему catch.
Вопрос подразумевает второй случай, когда исполнение попадает в finally в момент выброса исключения из try.
Исключение из finally заменит собой исключение из try и пойдет вверх по стеку вместо него. Оригинальная проблема будет 
попросту забыта. Такая маскировка исключения усложняет отладку, лучше избегать её.
Например, IntelliJ IDEA выводит соответствующее предупреждение на оператор throw внутри finally.

#### Когда происходит закрытие ресурса в конструкции try-with-resources, если в try возникло исключение: до перехода в catch или после того как catch отработает?
>при тестировании в Idea показало, что close() выполняется после того, как 
> отработает catch
#### Обязательно ли передавать в метод getLogger() имя класса? Почему так принято?
>не обязательно, но ...
#### Try с ресурсами: что если исключение вылетело сначала в try, а потом в close в конструкции try-with-recources? Какое исключение вылетит? Что будет с другим?
>из try будет приоритетным, а из close() потеряется