### [Условие:]()

>Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение. 
Создайте класс `DynamicArray`, который хранит в себе массив, и имеет методы для 
добавления `void add(T el)`, `void remove(int index)` удаления и извлечения `T get(int index)` 
из него элементов, при переполнении текущего массива, 
должен создаваться новый, большего размера.

>Для возможности работы с различными классами `DynamicArray` должен быть дженериком. 
Для решения задачи можно воспользоваться методами из класса `java.util.Arrays`. 
Импорт этого класса уже объявлен в тестирующей системе. Добавлять его явно не нужно

>Требования:
>1. должен быть класс `public static class DynamicArray`
>2. класс `DynamicArray` должен иметь методы публичные `void add(T el)`, `void remove(int index)` и `T get(int index)`
>3. В случае подбора некорректного индекса ожидается, что метод `get` выбросит `ArrayIndexOutOfBoundsException`
>4. класс `DynamicArray` должен иметь публичный конструктор по умолчанию
>5. работа методов должна соответствовать условию

### [Решение:]()
```java
public static class DynamicArray<T> {

    private T[] array;

    public DynamicArray() {
    }

    public void add(T el) {
        if (array == null) {
            this.array = (T[]) new Object[]{el};
        } else {
            T[] added = (T[]) new Object[array.length + 1];
            System.arraycopy(array, 0, added, 0, array.length);
            added[array.length] = el;
            this.array = added;
        }
    }

    public void remove(int index) {
        try {
            if (array != null) {
                T[] deleted = (T[]) new Object[array.length - 1];
                System.arraycopy(array, 0, deleted, 0, index);
                System.arraycopy(array, index + 1, deleted, index, deleted.length - index);
                this.array = deleted;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }

    public T get(int index) {
        try {
            return array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

}
```
### Сообщение от ментора:
>- Не создавать временных массивов при изменении размера.  
>- Увеличивать размер массива в какое-то количество раз (например в 1.5 или 2 раза).  
>- В remove достаточно одного вызова System.arraycopy
