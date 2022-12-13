package homework2;
import java.io.IOException; 
import java.util.InputMismatchException; 
import java.util.Scanner; 
import java.util.logging.FileHandler; 
import java.util.logging.Logger; 
import java.util.logging.SimpleFormatter; 
 
public class HomeWork5 { 
    /* 
     * Реализуйте алгоритм сортировки пузырьком числового массива,  
     * результат после каждой итерации запишите в лог-файл. 
     */ 
    private static Logger logger = Logger.getLogger(HomeWork5.class.getName());
 
    public static void main(String[] args) throws IOException { 
        FileHandler fh = new FileHandler("BubbleLogs.txt");
        logger.addHandler(fh); 
        SimpleFormatter sFormat = new SimpleFormatter(); 
        fh.setFormatter(sFormat); 
 
        ArrayBubble myArray = new ArrayBubble(); 
 
        myArray.bubbleSorter(); 
        System.out.println(" "); 
        myArray.printer(); 
 
    }   
} 
class ArrayBubble { 
        int n; 
        int[] ar; 
        private static Logger logger = Logger.getLogger(HomeWork5.class.getName()); 
 
        ArrayBubble(){ 
            Scanner input = new Scanner(System.in); 
            System.out.println("Введите размер массива"); 
            try { 
                n = input.nextInt(); 
            }catch(InputMismatchException inputMismatchException){ 
                logger.warning("Введен неправильный тип данных, введите целое число"); 
            } 
            input.close(); 
 
            ar=new int[n]; 
            for(int i = 0;i<n;i++){ 
                ar[i] = ((int) (Math.random() * 31) + 5); 
                System.out.print(ar[i] + " "); 
            } logger.info("Распечатали массив в консоль");     
        }    
 
 
    void printer(){
        for (int i = 0; i < n; i++){
            System.out.print(ar[i] + " ");                                        
 
        } logger.info("Выполнился метод вывода массива в консоль");     
    }     
 
    void toSwap(int first, int second) {
        int dummy = ar[first]; 
        ar[first] = ar[second];
        ar[second] = dummy;
        logger.info("Выполнился метод замены мест 2х элементов из массива, а их "+ n); 
    } 
 
    void bubbleSorter() { 
        for (int i = n - 1; i >= 1; i--) { 
            for (int j = 0; j < i; j++) {
                if (ar[j] > ar[j + 1])  
                    toSwap(j, j + 1); 
            } 
        } 
        logger.info("Выполнилась сортировка массива пузырьком"); 
    } 
}