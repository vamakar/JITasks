import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/***********************************************************************************************************************
 Программа, возвращающая список разменов на 3,5 копеек и 3, 5, 7 копеек.
 ***********************************************************************************************************************
 JRE: 1.8
 ***********************************************************************************************************************
 Проверяемые числа вводятся с консоли, пока не будет введена строка exit.
 Если вместо чисел будут введены другие символы, будет повторный запрос.
 Пример вывода для чисел 5, 8, 11, 12, 20, 59:
 =======================================================================================================================
 5
 Not enough money for exchange
 8
 3, 5: [3, 5]
 11
 3, 5: [3, 3, 5]
 12
 3, 5: [3, 3, 3, 3]
 3, 5, 7: [5, 7]
 20
 3, 5: [5, 5, 5, 5]
 3, 5: [3, 3, 3, 3, 3, 5]
 3, 5, 7: [3, 5, 5, 7]
 59
 3, 5: [3, 3, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5]
 3, 5: [3, 3, 3, 3, 3, 3, 3, 3, 5, 5, 5, 5, 5, 5, 5]
 3, 5: [3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 5, 5, 5]
 3, 5: [3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5]
 3, 5, 7: [3, 3, 5, 5, 5, 5, 5, 7, 7, 7, 7]
 3, 5, 7: [3, 5, 5, 5, 5, 5, 5, 5, 7, 7, 7]
 3, 5, 7: [5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 7]
 3, 5, 7: [3, 3, 3, 3, 3, 3, 5, 5, 5, 5, 7, 7, 7]
 3, 5, 7: [3, 3, 3, 3, 3, 5, 5, 5, 5, 5, 5, 7, 7]
 3, 5, 7: [3, 3, 3, 3, 5, 5, 5, 5, 5, 5, 5, 5, 7]
 3, 5, 7: [3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 5, 5, 7, 7]
 3, 5, 7: [3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 5, 5, 5, 5, 7]
 3, 5, 7: [3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 5, 7]
 =======================================================================================================================
 **********************************************************************************************************************/
public class Coins {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        int money = 0, m = 0;
        int k, p;
        ArrayList<Integer> coins = new ArrayList<>();
        while(!line.equals("exit")){
            try {
                line = reader.readLine();
                money = Integer.parseInt(line);
            } catch (IOException | NumberFormatException e) {
                continue;
            }
            if(money >= 8){
                m = 0;
                for (int i = 0; i <= money/3; i++) {
                    for (int j = 0; j <= i; j++) {
                        k = i - j;
                        m = j*3 + k*5;
                        if (m == money) {
                            for (int l = 0; l < j; l++) {
                                coins.add(3);
                            }
                            for (int l = 0; l < k; l++) {
                                coins.add(5);
                            }
                            System.out.print("3, 5: ");
                            System.out.println(coins);
                        }
                        coins.clear();
                    }
                }
                m = 0;
                for (int i = 0; i <= money/3; i++) {
                    for (int j = 0; j <= i; j++) {
                        k = i - j;
                        for (int q = 0; q <= k; q++) {
                            p = k - q;
                            m = j*3 + k*5 + p*7;
                            if (m == money) {
                                for (int l = 0; l < j; l++) {
                                    coins.add(3);
                                }
                                for (int l = 0; l < k; l++) {
                                    coins.add(5);
                                }
                                for (int l = 0; l < p; l++) {
                                    coins.add(7);
                                }
                                if (coins.contains(7)){
                                    System.out.print("3, 5, 7: ");
                                    System.out.println(coins);
                                }
                            }
                            coins.clear();
                        }
                    }
                }
            }else System.out.println("Not enough money for exchange");
        }
        reader.close();
    }
}
