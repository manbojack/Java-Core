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
    private int size;

    public DynamicArray() {
        this.array = (T[]) new Object[10];
    }

    private int getIndex(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return index;
    }

    public T get(int index) {
        return array[getIndex(index)];
    }

    public void remove(int index) {
        getIndex(index);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        size--;
    }

    public void add(T el) {
        if (size == array.length)  {
            T[] newArray = (T[]) new Object[(2 * array.length)];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size] = el;
        size++;
    }
}
```
### Сообщение от ментора:
>- Не создавать временных массивов при изменении размера.  
>- Увеличивать размер массива в какое-то количество раз (например в 1.5 или 2 раза).  
>- В remove достаточно одного вызова System.arraycopy
