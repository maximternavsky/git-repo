package geekbrains.lesson3;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Shusharina", new Date("NOVEMBER 26 1992"));
        map.put("Ternavsky", new Date("APRIL 11 1993"));
        map.put("Kalita", new Date("JUNE 1 1995"));
        map.put("Tin", new Date("JUNE 1 1980"));
        map.put("Nefedov", new Date("JUNE 1 1980"));
        map.put("Burkas", new Date("JUNE 1 1980"));
        map.put("Gus", new Date("JUNE 1 1980"));
        map.put("Latsabidze", new Date("JUNE 1 1980"));
        map.put("Philatov", new Date("JUNE 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        for(Map.Entry<String, Date> i : map.entrySet()){
            if(i.getValue().getMonth() == 5 || i.getValue().getMonth() == 6 || i.getValue().getMonth() == 7){
                System.out.println(i.getValue().getMonth());
                map.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
        for(Map.Entry<String, Date> i : map.entrySet()){
            System.out.println(i.getKey());
        }
    }
}
