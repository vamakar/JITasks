import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***********************************************************************************************************************
 Программа, выполняющая поиск подстроки в строке.
 ***********************************************************************************************************************
 JRE: 1.8
 ***********************************************************************************************************************
 Проверяемые строки вводятся с консоли, пока не будет введена строка exit.
 Пример вывода для пар строк [string, substring], [substring, string], [string, word]:
 =======================================================================================================================
 String: string
 Substring: substring
 Substring is longer than string to be verified
 String: substring
 Substring: string
 substring contains string
 String: string
 Substring: word
 string does not contain word
 =======================================================================================================================
 **********************************************************************************************************************/
public class SearchSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = "", substring = "";
        boolean contains = false;
        char[] str, substr;
        while(!string.equals("exit") && !substring.equals("exit")){
            try {
                System.out.print("String: ");
                string = reader.readLine();
                if (string.equals("exit"))continue;
                System.out.print("Substring: ");
                substring = reader.readLine();
            } catch (IOException e) {
                continue;
            }
            if (string.length() >= substring.length()){
                str = string.toCharArray();
                substr = substring.toCharArray();
                for (int i = 0; i <= str.length - substr.length; i++) {
                    contains = true;
                    for (int j = 0; j < substr.length; j++) {
                        if(str[i + j] != substr[j]){
                            contains = false;
                            break;
                        }
                    }
                    if(contains)break;
                }
                if (contains) System.out.println(string + " contains " + substring);
                else System.out.println(string + " does not contain " + substring);
            }else System.out.println("Substring is longer than string to be verified");
        }
        reader.close();
    }
}
