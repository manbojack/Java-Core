package modules.module6.chapter2.task14;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.*;
import java.util.function.BiConsumer;

public class Solution {
    public static void main(String[] args) throws IOException {
        String input = "" +
                "Алексей 3000\n " +
                "Дмитрий 9000\n " +
                "Антон 3000\n " +
                "Алексей 7000 \n " +
                "Антон 8000";

        Reader reader = new StringReader(input);
        System.out.println(getSalesMap(reader));
    }

    public static Map<String, Long> getSalesMap(Reader reader) throws IOException {
        Map<String, Long> map = new HashMap<>();
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNext()) {
            map.merge(scanner.next(), scanner.nextLong(), Long::sum);
        }
        return map;
    }
}
