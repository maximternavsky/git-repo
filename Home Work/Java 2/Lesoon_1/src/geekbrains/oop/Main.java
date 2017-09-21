package geekbrains.oop;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        book.add("89181234567", "Ivanov");
        book.add("89611234567", "Kozlov");
        book.add("+79280332455", "Petrov");
        book.add("+79610332456", "Baranov");
        book.add("+79180332457", "Petrov");
        book.add("+3(4812)033-24-55", "Petrov");
        book.add("8(861)229-00-20", "Sidorov");
        book.add("8(861)229-08-71", "Ivanov");
        book.get("Ivanov");
        book.get("Sidorov");
        book.get("Petrov");

        System.out.println("\n+++++unikalnie slova+++++\n");

        String s = new String();
        int n = 0;
        ArrayList<String> list = new ArrayList<>();
        int[] m;
        list.add("apple");
        list.add("orange");
        list.add("lemon");
        list.add("raspberry");
        list.add("lemon");
        list.add("apple");
        list.add("kiwi");
        list.add("apple");
        list.add("mandarin");
        list.add("papaya");
        list.add("cocount");
        list.add("raspbery");
        list.add("melon");
        list.add("apricot");
        list.add("orange");
        list.add("peach");
        list.add("lime");
        list.add("mandarin");
        list.add("pineapple");
        list.add("kiwi");

        for (int i = 0; i < list.size(); i++) {
            s = list.get(i);
            n = 0;
            for (int j = 0; j < list.size(); j++) {
                if(s.equals(list.get(j))){
                    n++;
                }
            }
            if(n == 1) {System.out.println(s); }
        }

        System.out.println("--------------------------");

        for (int i = 0; i < list.size(); i++) {

            n = 0;
            for (int j = 0; j < list.size(); j++) {
                if(list.get(i).equals(list.get(j))){
                    n++;
                }

            }
            System.out.println(list.get(i) + " " + n);
        }
    }

}

class PhoneBook{
    private HashMap<String, String> list = new HashMap<>();

    public PhoneBook(){

    }

    public void add(String number, String name){
        this.list.put(number, name);
    }

    public HashMap<String, String> get(String s){
        boolean b = true;

        for (Map.Entry<String, String> i : list.entrySet()) {
            if((s.equals(i.getValue())) && b){
                System.out.print(s + " - ");
                b = false;
            }
            if((s.equals(i.getValue())) && !b){
                System.out.print(i.getKey() + ", ");
            }
        }

        System.out.print("\n");

        return  list;
    }
}
