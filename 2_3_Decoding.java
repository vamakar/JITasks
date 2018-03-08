import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/***********************************************************************************************************************
 Программа выполняющая Run-length encoding декодирование строки (3a1b2c2d->aaabccdd).
 ***********************************************************************************************************************
 Запуск в IntelliJ IDEA 2017.3.4:
  Main class: Decoding
  JRE: 1.8
 ***********************************************************************************************************************
 Декодируемые строки вводятся с консоли. Введенная строка должна содержать числа в четных элементах,
 где первый символ - нулевой элемент, иначе будет повторный запрос.
 Считанный символ '0' в четных элементах строки считается за 10 символов подряд.
 Программа работает до тех пор, пока не будет введена пустая строка.
 Пример вывода для сторок 1s1t1r1i1n1g, 7s4t2r, 0a0a4a4b, 615540:
 =======================================================================================================================
 1s1t1r1i1n1g
 string
 7s4t2r
 sssssssttttrr
 0a0a4a4b
 aaaaaaaaaaaaaaaaaaaaaaaabbbb
 615540
 111111555550000
 =======================================================================================================================
 **********************************************************************************************************************/
public class Decoding {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in;
        String out;
        char[] cin, cout;
        int count, c;
        label:
        while(!(in = reader.readLine()).equals("")){
            cin = in.toCharArray();
            out = "";
            count = 0;
            if (cin.length < 2) continue;
            for (int i = 0; i < cin.length; i = i + 2) {
                if(cin[i] == '0') count += 10;
                else try {
                    count += Integer.parseInt(String.valueOf(cin[i]));
                } catch (NumberFormatException e) {
                    continue label;
                }
            }
            cout = new char[count];
            count = 0;
            for (int i = 0; i < cin.length; i = i + 2) {
                c = Integer.parseInt(String.valueOf(cin[i]));
                c = c == 0 ? 10 : c;
                for (int j = 0; j < c; j++) {
                    cout[count++] = cin[i + 1];
                }
            }
            System.out.println(String.valueOf(cout));
        }
    }
}
