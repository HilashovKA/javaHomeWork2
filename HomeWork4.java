package homework2;
import java.io.IOException; 
import java.io.FileReader; 
import java.util.Scanner; 
 
public class HomeWork4 { 
    /* 
     * Распарсить файл с логами из заданий, выполненных на семинаре, найти записи уровня INFO/DEBUG. 
     */ 
 
 
    public static void main(String[] args) throws IOException { 
 
        System.out.println("Количество строк в файле:"); 
        int count = countStrings(); 
        System.out.println(count + "\n"); 
 
        System.out.println("Содержание исходного файла:"); 
        String[] arrayLines = ReadWrite(count); 
        System.out.println("\n"); 
 
        System.out.println("Логи уровня INFO:"); 
        printConsole(arrayLines); 
 
    } 
 
    // метод подсчета строк в файле с логами 
    static int countStrings() throws IOException { 
        FileReader inFile = new FileReader("textLogs.txt"); 
        Scanner file = new Scanner(inFile); 
 
        int count = 0; 
        while (file.hasNextLine()) { 
            file.nextLine(); 
            count = count + 1; 
        } 
        file.close(); 
        return count; 
    } 
 
    // Метод записи файла с логами в массив строк 
    static String[] ReadWrite(int count) throws IOException { 
        FileReader inFile = new FileReader("textLogs.txt"); 
        Scanner file = new Scanner(inFile); 
 
        String arrayLines[] = new String[count]; 
        int i = 0; 
 
        while (file.hasNextLine()) { 
            String temp = file.nextLine(); 
            arrayLines[i] = temp; 
            System.out.println(arrayLines[i]); 
            i++; 
        } 
        file.close(); 
        return arrayLines; 
    } 
 
    // метод вывода в консоль списка логов уровня INFO 
    static void printConsole(String[] array) { 
        for (int i = 1; i < array.length; i++) { 
            String temp = array[i]; 
            if (temp.contains("INFO")) { 
                System.out.println(array[i - 1]); 
                System.out.println(array[i]); 
            } 
        } 
    } 
}