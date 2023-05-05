package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class S4 {
    public static void main(String[] args) {
        FileRead();
        System.out.println("_________________________________________");
        FileReadSplit();
        System.out.println("_________________________________________");
        FileReadSplitLists();
        System.out.println("_________________________________________");
        FileReadSplitSort();
    }

    public static void FileRead() {
        String text = "Это строка для записи в файл";
        String fileName = "test.txt";


        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
            System.out.println("Строка записана в файл");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


        try (FileReader reader = new FileReader(fileName)) {
            StringBuilder stringBuilder = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                stringBuilder.append((char) character);
            }
            System.out.println("Строка, прочитанная из файла: " + stringBuilder.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void FileReadSplit() {
        String fileName = "fio.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {

                List<String> parts = Arrays.asList(line.split(" "));


                String fullName = parts.get(0);
                String initials = parts.get(1).substring(0, 1) + "." + parts.get(2).substring(0, 1) + ".";
                String age = parts.get(3);
                String gender = parts.get(4).equals("м") ? "М" : "Ж";
                System.out.println(fullName + " " + initials + " " + age + " " + gender);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }



    public static void FileReadSplitLists() {
            String fileName = "fio.txt";


            List<String> surnames = new ArrayList<>();
            List<String> names = new ArrayList<>();
            List<String> patronymics = new ArrayList<>();
            List<Integer> ages = new ArrayList<>();
            List<String> genders = new ArrayList<>();


            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {

                    List<String> parts = Arrays.asList(line.split(" "));


                    surnames.add(parts.get(0));
                    names.add(parts.get(1));
                    patronymics.add(parts.get(2));
                    ages.add(Integer.parseInt(parts.get(3)));
                    genders.add(parts.get(4));
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }


            System.out.println("Фамилии: " + surnames);
            System.out.println("Имена: " + names);
            System.out.println("Отчества: " + patronymics);
            System.out.println("Возрасты: " + ages);
            System.out.println("Пол: " + genders);
        }



    public static void FileReadSplitSort() {
            String fileName = "fio.txt";


            List<String> surnames = new ArrayList<>();
            List<String> names = new ArrayList<>();
            List<String> patronymics = new ArrayList<>();
            List<Integer> ages = new ArrayList<>();
            List<String> genders = new ArrayList<>();


            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {

                    List<String> parts = Arrays.asList(line.split(" "));


                    surnames.add(parts.get(0));
                    names.add(parts.get(1));
                    patronymics.add(parts.get(2));
                    ages.add(Integer.parseInt(parts.get(3)));
                    genders.add(parts.get(4));
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }


            List<Integer> indexes = new ArrayList<>();
            for (int i = 0; i < ages.size(); i++) {
                indexes.add(i);
            }


            indexes.sort((i1, i2) -> ages.get(i1).compareTo(ages.get(i2)));


            for (int index : indexes) {
                System.out.printf("%s %s %s %d %s%n",
                        surnames.get(index),
                        names.get(index),
                        patronymics.get(index),
                        ages.get(index),
                        genders.get(index)
                );
            }
        }
}

//fio.txt
//        Иванов Иван Алексеевич 32 м
//        Мальцев Илья Степанович 23 м
//        Ковалева Елизавета Давидовна 22 ж
//        Власова Полина Даниловна 45 ж
//        Попов Павел Маркович 30 м