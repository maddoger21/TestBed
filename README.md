# TestBed
Песочница для запуска консольных Java-программ под Android

https://github.com/vv73/TestBed/blob/master/screenshot.png

**Ограничения:**

- Главный класс должен располагаться в корне (пример - MyProgram.java)
- Для ввода и вывода должны использоваться статические переменные класса - **подклассы** **Scanner** и **PrintStream**, 
инициализированные при объявлении
```java
import java.io.PrintStream;
import java.util.Scanner;

public class MyProgram
{
    // инструменты ввода-вывода
    // TestBed их заменяет на свои
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) {
        out.println("Enter two numbers");
        int x = in.nextInt(), y = in.nextInt();
        int sum = x * y;
        out.println("Sum of them is " + sum );
    }
}
```
