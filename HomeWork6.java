package homework2;
import java.util.Scanner; 
import java.util.logging.FileHandler; 
import java.util.logging.Logger; 
import java.util.logging.SimpleFormatter;   
import java.io.IOException; 
 
public class HomeWork6 { 
    private static Logger logger = Logger.getLogger(HomeWork6.class.getName()); 
    public static void main(String[] args) throws SecurityException, IOException { 
        /* 
         * К калькулятору из предыдущего дз добавить логирование. 
         */ 
        FileHandler fh = new FileHandler("calculatorLogs.txt");  
        logger.addHandler(fh); 
        SimpleFormatter sFormat = new SimpleFormatter(); 
        fh.setFormatter(sFormat); 
 
        System.out.print("Введите первое и второе число "); 
        Scanner in = new Scanner(System.in); 
        int a = in.nextInt(); 
        int b = in.nextInt(); 
        logger.info("Пользователь ввел числа "); 
 
        System.out.print("Введите тип операции, набрав + или - или * или / или % "); 
        char symbol = in.next().charAt(0); 
        logger.info("Пользователь ввел тип операции"); 
        in.close(); 
        calculator(a, b, symbol); 
 
    } 
 
    public static int calculator(int a, int b, char symbol) { 
        int result = 0; 
        if (symbol == '+') { 
            result = a + b; 
            logger.info("Пользователь запросил сложение"); 
 
        } else if (symbol == '-') { 
            result = a - b; 
            logger.info("Пользователь запросил вычитание"); 
 
        } else if (symbol == '*') { 
            result = a * b; 
            logger.info("Пользователь запросил умножение"); 
        } else if (symbol == '%') { 
            result = a % b; 
            logger.info("Пользователь запросил определение остатка от деления"); 
 
        } else if (symbol == '/') { 
            result = a / b; 
            logger.info("Пользователь запросил деление"); 
        } 
 
        System.out.println("Получилось " + result); 
        logger.info("Вычисление произведено"); 
        return result; 
    } 
}