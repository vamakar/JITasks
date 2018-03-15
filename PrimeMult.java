import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/***********************************************************************************************************************
 Программа, выполняющая разложение числа на набор простых множителей.
 ***********************************************************************************************************************
 JRE: 1.8
 ***********************************************************************************************************************
 Проверяемое число нужно ввести с консоли.
 Программа будет выполняться снова, пока не будет введена строка "exit".
 Пример вывода для чисел 1, 100, 1256 и 12133 соответственно:
 =======================================================================================================================
 1
 []
 100
 [2, 2, 5, 5]
 1256
 [2, 2, 2, 157]
 12133
 [11, 1103]
 =======================================================================================================================
 **********************************************************************************************************************/
public class PrimeMult {
    static ArrayList<Integer> multipliers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = "";
        int num;
        int number;
        boolean isPrime;
        while (!in.equals("exit")) {
            try {
                in = reader.readLine();
                num = Integer.parseInt(in);
            } catch (IOException | NumberFormatException e) {
                continue;
            }
            number = num;
            for (int i = 2; i <= num; i++) {
                isPrime = true;
                for (int j = i; j > 0; j--) {
                    if (i % j == 0 && j != i && j != 1) isPrime = false;
                }
                while(isPrime && number % i == 0){
                    multipliers.add(i);
                    number /= i;
                }
            }
            System.out.println(multipliers);
            multipliers.clear();
        }
        reader.close();
    }
}
