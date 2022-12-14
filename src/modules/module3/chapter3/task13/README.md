[//]: # (3.3.13)
### [Условие:]()

>На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y. 
Ось X смотрит слева направо, ось Y - снизу вверх. (Помните, как рисовали графики функций в школе?)

>В начальный момент робот находится в некоторой позиции на поле. 
Также известно, куда робот смотрит: вверх, вниз, направо или налево. 
Ваша задача — привести робота в заданную точку игрового поля.

>Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна):
```java
public class Robot {

    public Direction getDirection() {
        // текущее направление взгляда
    }

    public int getX() {
        // текущая координата X
    }

    public int getY() {
        // текущая координата Y
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }
}
```
>Direction, направление взгляда робота, - это перечисление:
```java
public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}
```
>Как это выглядит: 
> 
><p align="center">
>    <img src=robot.png
></p>

>Пример
В метод передано: toX == 3, toY == 0; начальное состояние робота такое: 
> robot.getX() == 0, robot.getY() == 0, robot.getDirection() == Direction.UP

>Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:

```java
robot.turnRight();
robot.stepForward();
robot.stepForward();
robot.stepForward();
```

>Требования:  
>- должен быть метод `public static void moveRobot(Robot robot, int toX, int toY)`
>- метод `moveRobot` должен переместить робота в позицию `int toX, int toY`

### [Решение:]()
```java
public static void moveRobot(Robot robot, int toX, int toY) {
    int stepsX = toX - robot.getX();
    int stepsY = toY - robot.getY();
    
    if (stepsY >= 0) {
        while (robot.getDirection() != Direction.UP) {
            robot.turnRight();
        }
        for (int step = 0; step < stepsY; step++) {
            robot.stepForward();
        }
    } else {
        while (robot.getDirection() != Direction.DOWN) {
            robot.turnRight();
        }
        for (int step = 0; step < -1 * stepsY; step++) {
            robot.stepForward();
        }
    }
    if (stepsX >= 0) {
        while (robot.getDirection() != Direction.RIGHT) {
            robot.turnRight();
        }
        for (int step = 0; step < stepsX; step++) {
            robot.stepForward();
        }
    } else {
        while (robot.getDirection() != Direction.LEFT) {
            robot.turnRight();
        }
        for (int step = 0; step < -1 * stepsX; step++) {
            robot.stepForward();
        }
    }
}
```
