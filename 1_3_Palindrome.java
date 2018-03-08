import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***********************************************************************************************************************
 Программа, выполняющая проверку строки на то, что она является палиндромом.
 ***********************************************************************************************************************
 Запуск в IntelliJ IDEA 2017.3.4:
  Main class: Palindrome
  JRE: 1.8
 ***********************************************************************************************************************
 Проверяемая строка вводится с консоли. Если кроме букв были введены другие символы, будет повторный запрос.
 Чтобы завершить работу программы, нужно ввести пустую строку.
 Пример вывода для слов "noon", "sunny", "Bob", "Madam, in Eden, I’m Adam":
 =======================================================================================================================
 noon
 noon is palindrome!
 sunny
 sunny is not palindrome!
 Bob
 Bob is palindrome!
 Madam, in Eden, I’m Adam
 Madam, in Eden, I’m Adam is palindrome!
 =======================================================================================================================
 **********************************************************************************************************************/
public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = null;
        char[] chars = null;
        boolean isPalindrome;
        while(!(in = reader.readLine()).equals("")){
            if(in.matches("(.*[\\d+].*)"))continue;
            chars = in.toLowerCase().replaceAll("(\\W)", "").toCharArray();
            isPalindrome = true;
            for (int i = 0; i < in.length()/2 - 1; i++) {
                if (chars[i] != chars[chars.length - i - 1]) isPalindrome = false;
            }
            if (isPalindrome) System.out.println(in + " is palindrome!");
            else System.out.println(in + " is not palindrome!");
        }
        reader.close();
    }
}
