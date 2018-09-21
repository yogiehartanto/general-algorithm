import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.List;
import java.util.HashSet;
import java.util.Collections;
import java.util.Map;

public class Statistics {
  public static Float customMode (List<Float> list) {
    int curr = 0;
    Float currKey =  0f;
    Set<Float> unique = new HashSet<Float>(list);

    HashMap<Float, Integer> hmap = new HashMap<Float, Integer>();

    for (Float key : unique) {
      curr = Collections.frequency(list, key);
      hmap.put(key, curr);
    }

    Integer maxValue = Collections.max(hmap.values());
    Integer minValue = Collections.min(hmap.values());

    System.out.println("Series of numbers with frequency : "+hmap);

    Float keyPoint = 0f;

    if (!minValue.equals(maxValue)) {
      for (int i=minValue; i<maxValue; i++) {
        hmap.values().removeAll(Collections.singleton(i));
      }
    }

    System.out.println("Series of numbers mode candidate : "+hmap.keySet());

    for (Map.Entry<Float, Integer> entry : hmap.entrySet()) {
      keyPoint += entry.getKey();
    }

    currKey = keyPoint / hmap.size();
    System.out.println("Count mode : "+keyPoint+ " / " +hmap.size());
    System.out.println("------------------------------------------------------------");
    System.out.println("MODE VALUE : "+currKey);
    System.out.println("------------------------------------------------------------");

    return currKey;
  }

  public static void main(String[] args) {
    List<Float> numbers = new ArrayList<>();

    numbers.add(15f);
    numbers.add(15f);
    numbers.add(15f);
    numbers.add(15f);
    numbers.add(40f);
    numbers.add(40f);
    numbers.add(40f);
    numbers.add(40f);
    numbers.add(45f);
    numbers.add(45f);

    customMode(numbers);
  }
}


