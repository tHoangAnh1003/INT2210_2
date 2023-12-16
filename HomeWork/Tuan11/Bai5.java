import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

     public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        
        for (int x : arr) {
            if (map1.containsKey(x)) {
                int tanSuat = map1.get(x);
                map1.put(x, tanSuat + 1);
            }
            else {
                map1.put(x, 1);
            }
        }

        for (int x : brr) {
            if (map2.containsKey(x)) {
                int tanSuat = map2.get(x);
                map2.put(x, tanSuat + 1);
            }
            else {
                map2.put(x, 1);
            }
            if (!map1.containsKey(x)) {
                map1.put(x, 0);
            }
        }
    
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < brr.size(); ++i) {
            int x = brr.get(i);
            if ((map1.get(x) < map2.get(x)) && map2.get(x) > 0) {
                ans.add(x);
                map2.put(x, 0);
            }
        }
        
        Collections.sort(ans);
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
