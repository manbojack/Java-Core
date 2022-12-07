### [Условие:]()

>Реши предыдущую задачу с использованием `try-with-resources`

### [Решение:]()
```java
public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
    for (int i = 0; i < 3; i++) {
        try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
            robotConnection.moveRobotTo(toX, toY);
            i = 3;
        } catch (RobotConnectionException e) {
            if (i == 2) {
                throw e;
            }
        }
    }
}
```
