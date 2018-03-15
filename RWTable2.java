import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
/***********************************************************************************************************************
 Программа, сортирующая данные в таблице из файла result.txt.
 ***********************************************************************************************************************
 JRE: 1.8
 ***********************************************************************************************************************
 Программа построчно считывает данные, разделенные символом ';'. 
 Формат данных в файле result.txt: 
 country;sum(count);count_uniq(user_id)
 Сортировка происходит по убыванию в колонке данных sum(count). 
 В случае одинаковых значений sum(count) строки сортируются по возрастанию по count_uniq(user_id)
 **********************************************************************************************************************/

public class RWTable2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("result.txt"));
        String[] title = reader.readLine().split(";");
        if (title.length != 3) throw new Exception();
        String string;
        String[] line;
        int sumCount;

        //Каждому ключу в основном словаре соответствует свой словарь
        TreeMap<Integer, TreeMap<Integer, String>> map = new TreeMap<>(Collections.reverseOrder());
        while ((string = reader.readLine()) != null) {
            line = string.split(";");
            if (line.length != 3) continue;
            try {
                sumCount = Integer.parseInt(line[1]);
                if (!map.containsKey(sumCount)) {
                    map.put(sumCount, new TreeMap<>());
                }
                map.get(sumCount).put(Integer.parseInt(line[2]), line[0]);
            } catch (NumberFormatException e) {
                continue;
            }
        }
        reader.close();

        //Запись отсортированных в TreeMap данных
        BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));
        for (Map.Entry<Integer, TreeMap<Integer, String>> pair : map.entrySet()) {
            for (Map.Entry<Integer, String> innerMapPair : pair.getValue().entrySet()) {
                writer.write(innerMapPair.getValue() + ";" + pair.getKey() + ";" + innerMapPair.getKey());
                writer.newLine();
            }
        }
        writer.close();
    }
}
