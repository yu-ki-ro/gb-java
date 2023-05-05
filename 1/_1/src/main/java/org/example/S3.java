package org.example;

import java.util.*;

public class S3 {
    public static void main(String[] args) {
        ReverseSort();
        RemoveEvenNumbers();
        ListMinMaxAverage();
        MergeLists();
        CompareArrayListAndLinkedList();

    }

    public static void ReverseSort() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5));
        Comparator<Integer> reverseOrder = (a, b) -> b - a;
        Collections.sort(list, reverseOrder);
        System.out.println(list);
    }

    public static void RemoveEvenNumbers() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5));

        list.removeIf(num -> num % 2 == 0);

        System.out.println(list);
    }

    public static void ListMinMaxAverage() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5));

        int min = Collections.min(list);
        int max = Collections.max(list);
        double average = list.stream().mapToDouble(a -> a).average().orElse(0);

        System.out.println("Min: " + min + " Max: " + max + " Average: " + average);
    }

    public static void MergeLists() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 7, 1, 8, 2, 8, 1, 8));

        Set<Integer> set = new HashSet<>(list1);

        list2.stream().filter(num -> !set.contains(num)).forEach(set::add);

        List<Integer> mergedList = new ArrayList<>(set);

        System.out.println(mergedList);
    }
    public static void ArrayListWithZeros() {
        List<Integer> list = new ArrayList<>(Collections.nCopies(10000, 0));
        System.out.println(list.size());
    }
    public static void LinkedListWithZeros() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(0);
        }
        System.out.println(list.size());
    }

    public static void CompareArrayListAndLinkedList() {
        long startTime, endTime, arrayListTime, linkedListTime;


        startTime = System.nanoTime();
        ArrayListWithZeros();
        endTime = System.nanoTime();
        arrayListTime = endTime - startTime;


        startTime = System.nanoTime();
        LinkedListWithZeros();
        endTime = System.nanoTime();
        linkedListTime = endTime - startTime;

        System.out.println("ArrayList time: " + arrayListTime + " ns");
        System.out.println("LinkedList time: " + linkedListTime + " ns");

        if (arrayListTime < linkedListTime) {
            System.out.println("ArrayList > LinkedList");
        } else if (arrayListTime > linkedListTime) {
            System.out.println("LinkedList > ArrayList");
        } else {
            System.out.println("ArrayList = LinkedList-");
        }
    }

}