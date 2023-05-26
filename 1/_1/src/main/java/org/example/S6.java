package org.example;

import java.util.*;

public class S6 {
    public static void main(String[] args) {
        mySet mySet = new mySet();
        for (int i = 0; i < 9; i++){
            mySet.add(new Random().nextInt( 10 ));
        }
        System.out.println(mySet.contains(9));
        System.out.println(Arrays.toString(mySet.toArray()));
        Iterator<Integer> iterator = mySet.interator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();
        System.out.println(mySet.getItem(4));


    }
}

class mySet {
    static final Object OBJECT = new Object();
    private LinkedHashMap<Integer, Object> hashMap = new LinkedHashMap<>();

    public boolean add(int num){
        HashSet<Integer> integers;
        return hashMap.put(num,OBJECT) == null;
    }

    public boolean contains(int num) {
        return hashMap.containsKey(num);
    }

    public Object[] toArray(){
        return hashMap.keySet().toArray();
    }

    public Iterator<Integer> interator() {
        return hashMap.keySet().iterator();

    }

    public Integer getItem(int index) {
        return (Integer) toArray()[index];
    }

}

