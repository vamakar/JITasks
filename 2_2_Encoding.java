import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/***********************************************************************************************************************
 Программа выполняющая Run-length encoding кодирование строки (aaabccdd -> 3a1b2c2d).
 ***********************************************************************************************************************
 Запуск в IntelliJ IDEA 2017.3.4:
  Main class: Encoding
  JRE: 1.8
 ***********************************************************************************************************************
 Кодируемые строки вводятся с консоли. Программа работает, пока не будет введена пустая строка.
 Допускается кодирование не более 10 одинаковых символов подряд, чтобы можно было декодировать числа в строке.
 Число 10 в кодированной строке представлено символом '0'.
 Если строка содержит более 10 одинаковых символов подряд, сжатие продолжится уже в следующие символы:
 (aaaaaaaaaaaa ->0a2a)
 Пример вывода для сторок string, sssssssttttrr, aaaaaaaaaaaaaaaaaaaaaaaabbbb, 111111555550000:
 =======================================================================================================================
 string
 1s1t1r1i1n1g
 sssssssttttrr
 7s4t2r
 aaaaaaaaaaaaaaaaaaaaaaaabbbb
 0a0a4a4b
 111111555550000
 615540
 =======================================================================================================================
 **********************************************************************************************************************/
public class Encoding {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in;
        String out;
        char[] cin;
        int count;
        while(!(in = reader.readLine()).equals("")){
            cin = in.toCharArray();
            out = "";
            count = 1;
            for (int i = 0; i < cin.length; i++) {
                if(count == 10){
                    out = out + 0 + cin[i];
                    count = 1;
                }else if (i + 1 == cin.length || cin[i] != cin[i + 1]){
                    out = out + count + cin[i];
                    count = 1;
                }else count++;
            }
            System.out.println(out);
        }
        reader.close();
    }
}
