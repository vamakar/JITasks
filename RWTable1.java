//JRE: 1.8

import java.io.*;

public class RWTable1 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = null;
        String inputFile = "input.txt"; //название входного файла

        reader = new BufferedReader(new FileReader(inputFile));
        String[] title = reader.readLine().split(";");
        if (title.length != 3) throw new Exception();
        //проверка числа сторк в файле для опрелеления размера массивов
        int numberOfLines = 0;
        while (!(reader.readLine() == null)) {
            numberOfLines++;
        }

        reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));
        String[] uniqCountries = new String[numberOfLines];
        int[] uniqIdcount = new int[numberOfLines];
        int[] uniqId = new int[numberOfLines];
        int[] count = new int[numberOfLines];
        int numberOfCountries = 0;
        int k = 0;
        String[] line;
        boolean containsCountry;
        boolean containsId;

        //заполнение массивов с учетом уникальности поля country
        line = reader.readLine().split(";");
        writer.write(line[2] + ";" + "sum(" + line[1] + ");" + "count_uniq(" + line[0] + ")");
        label:
        for (int i = 0; i < numberOfLines; i++) {
            line = reader.readLine().split(";");
            if (line.length != 3) throw new Exception();
            containsCountry = false;
            containsId = false;
            try {
                uniqId[i] = Integer.parseInt(line[0]);
            } catch (NumberFormatException e) {
                continue;
            }
            for (int j = 0; j < uniqCountries.length; j++) {
                if (uniqCountries[j] == null) break;
                if (uniqCountries[j].equalsIgnoreCase(line[2])) {
                    containsCountry = true;
                    k = j;
                    break;
                }
            }
            if (containsCountry) {
                try {
                    count[k] = count[k] + Integer.parseInt(line[1]);
                } catch (NumberFormatException e) {
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (uniqId[j] == 0) break;
                    try {
                        if (uniqId[j] == Integer.parseInt(line[0])) {
                            containsId = true;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        continue label;
                    }
                }
            } else {
                try {
                    count[numberOfCountries] = Integer.parseInt(line[1]);
                } catch (NumberFormatException e) {
                    continue;
                }
                k = numberOfCountries;
                uniqCountries[numberOfCountries++] = line[2];
            }
            if (!containsId) {
                uniqIdcount[k]++;
            }
        }

        //запись в файл в том же формате
        for (int i = 0; i < uniqCountries.length; i++) {
            if (uniqCountries[i] == null) break;
            writer.newLine();
            writer.write(uniqCountries[i] + ";" + count[i] + ";" + uniqIdcount[i]);
        }

        reader.close();
        writer.close();
    }
}
