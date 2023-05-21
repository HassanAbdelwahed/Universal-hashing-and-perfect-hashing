import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StringMapping {
    Random random = new Random();
    Map<String, Integer> map = new HashMap<>();
    public int getMapping(String str){
        if (map.containsKey(str)){
            return map.get(str);
        }
        int x = random.nextInt(Integer.MAX_VALUE);
        while (map.containsKey(x)){
            x = random.nextInt(Integer.MAX_VALUE);
        }
        map.put(str, x);
        return x;
    }
}
