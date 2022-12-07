### [Условие:]()
>Дан сериализуемый класс `Animal`:

```java
class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}
```
>Реализуйте метод, который из переданного массива байт восстановит массив объектов `Animal`.
Массив байт устроен следующим образом. Сначала идет число типа `int`, записанное при 
помощи `ObjectOutputStream.writeInt(size)`. Далее подряд записано указанное количество 
объектов типа `Animal`, сериализованных при помощи `ObjectOutputStream.writeObject(animal)`.

>Если вдруг массив байт не является корректным представлением массива экземпляров `Animal`, 
то метод должен бросить исключение `java.lang.IllegalArgumentException`.

>Причины некорректности могут быть разные. Попробуйте подать на вход методу разные 
некорректные данные и посмотрите, какие исключения будут возникать. Вот их-то и 
нужно превратить в `IllegalArgumentException` и выбросить. Если что-то забудете, 
то проверяющая система подскажет. Главное не глотать никаких исключений, т.е. 
не оставлять нигде пустой `catch`.

>Требования:  
>1. Метод должен быть публичным.
>2. Сигнатура метода должна быть: `Animal[] deserializeAnimalArray(byte[] data)`

### [Решение:]()
```java
public static Animal[] deserializeAnimalArray(byte[] data) {
    Animal[] animals = null;
    try (InputStream is = new ByteArrayInputStream(data); ObjectInputStream ois = new ObjectInputStream(is)) {
        animals = new Animal[ois.readInt()];
        for (int i = 0; i < animals.length; i++) {
            animals[i] = (Animal) ois.readObject();
        }
    } catch (IOException | NullPointerException e1) {
        throw new IllegalArgumentException();
    } catch (ClassCastException | ClassNotFoundException e2) {
        throw new IllegalArgumentException();
    } catch (RuntimeException e3) {
        throw new IllegalArgumentException();
    }
    return animals;
}
```
