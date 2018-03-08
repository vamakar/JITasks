import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***********************************************************************************************************************
 Программа, возвращающая n-й по величине элемент набора чисел.
 ***********************************************************************************************************************
 Запуск в IntelliJ IDEA 2017.3.4:
  Main class: NMaximum
  JRE: 1.8
 ***********************************************************************************************************************
 Проверяемый массив nums задан с коде программы.
 Порядковый номер максимума, который нужно вывести, вводится с консоли.
 Если будет введен нечисловой символ или число, превосходящее по величине длину массива либо меньше единицы,
 то запрос будет повторен. Программа работает пока не будет введена строка "exit".
 Пример вывода для текущего варианта nums и введенных чисел 1, 2. 3, 6 и 10:
 =======================================================================================================================
 Enter n to get Nth maximum: 1
 1st maximum is 7200.11
 Enter n to get Nth maximum: 2
 2nd maximum is 5688.0
 Enter n to get Nth maximum: 3
 3th maximum is 11.12
 Enter n to get Nth maximum: 6
 6th maximum is 5.89
 Enter n to get Nth maximum: 10
 10th maximum is -33.49
 =======================================================================================================================
 **********************************************************************************************************************/
public class NMaximum {
    private static double[] nums = {0.0, 5.5, 5.89, 4.87, 11.12, 7200.11, 5688.00, 9, 8.1, -33.49};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        int n;
        while (!line.equals("exit")) {
            try {
                System.out.print("Enter n to get Nth maximum: ");
                line = reader.readLine();
                n = Integer.parseInt(line);
                if(n < 1 || n > nums.length) continue;
            } catch (IOException | NumberFormatException e) {
                continue;
            }
            double max1 = nums[0];
            double min = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if(max1 < nums[i]) max1 = nums[i];
                if(min > nums[i]) min = nums[i];
            }
            double maxn = max1;
            for (int j = 0; j < n - 1; j++) {
                maxn = min;
                for (int i = 0; i < nums.length; i++) {
                    if(maxn < nums[i] && nums[i] < max1){
                        maxn = nums[i];
                    }
                }
                max1 = maxn;
            }
            if(n == 1) System.out.println(n + "st maximum is " + maxn);
            else if(n == 2) System.out.println(n + "nd maximum is " + maxn);
            else System.out.println(n + "th maximum is " + maxn);
        }
        reader.close();
    }
}
