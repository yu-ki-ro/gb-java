package org.example;

import java.util.HashMap;
import java.util.Map;

public class S5 {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        map1.put("key3", "value3");
        map1.put("key4", "value4");
        map1.put("key5", "value5");
        map1.put("key6", "value6");
        System.out.println("-------------------------");
        System.out.println("Значения в map1:");
        System.out.println("-------------------------");
        for (String value : map1.values()) {
            System.out.println(value);
        }

        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String value = entry.getValue();
            entry.setValue(value + "!");
        }

        System.out.println("-------------------------");
        System.out.println("Значения в map2:");
        System.out.println("-------------------------");
        Map<String, String> map2 = new HashMap<>();
        map2.put("key1", "newvalue1");
        map2.put("key3", "newvalue3");
        map2.put("key6", "newvalue6");
        map2.put("key7", "newvalue7");
        map2.put("key8", "newvalue8");
        map2.put("key9", "newvalue9");
        for (String value : map2.values()) {
            System.out.println(value);
        }


        System.out.println("-------------------------");
        System.out.println("Обьединение map2 и map1:");
        System.out.println("-------------------------");
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (map1.containsKey(key)) {
                value = map1.get(key) + "," + value;
            }
            map1.put(key, value);
        }

        System.out.println("Значения в обьединеных map:");
        for (String value : map1.values()) {
            System.out.println(value);
        }
    }
}
