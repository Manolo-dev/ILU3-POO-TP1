package utils;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import cartes.Carte;

public class GestionCartes {
    public static <T> T extraire(List<T> liste, Random rand) {
        int index = rand.nextInt(liste.size());
        
        return liste.remove(index);
    }

    // public static <T> T extraire(List<T> liste, Random rand) {
    //     ListIterator<T> it = liste.listIterator();
    //     int index = rand.nextInt(liste.size());

    //     while(it.hasNext()) {
    //         if(index == it.nextIndex())
    //             return liste.remove(it.nextIndex());
    //         it.next();
    //     }
        
    //     return liste.remove(0);
    // }

    public static <T> List<T> melanger(List<T> liste, Random rand) {
        List<T> listeMelangee = new ArrayList<T>();

        while(!liste.isEmpty())
            listeMelangee.add(extraire(liste, rand));

        return listeMelangee;
    }

    public static <T> boolean verifierMelange(List<T> l1, List<T> l2) {
        Map<T, Integer> m1 = new HashMap<>();
        Map<T, Integer> m2 = new HashMap<>();

        for(T t : l1)
            m1.put(t, m1.getOrDefault(t, 0) + 1);
        
        for(T t : l2)
            m2.put(t, m2.getOrDefault(t, 0) + 1);
        
        return m1.equals(m2);
    }

    public static <T> List<T> rassembler(List<T> liste) {
        Map<T, Integer> map = new HashMap<>();

        for(T t : liste)
            map.put(t, map.getOrDefault(t, 0) + 1);
        
        List<T> res = new ArrayList<>();

        for(Map.Entry<T, Integer> entry : map.entrySet())
            for(int i = 0; i < entry.getValue(); i++)
                res.add(entry.getKey());
        
        return res;
    }

    public static <T> boolean verifierRassemblement(List<T> liste) {
        ListIterator<T> it = liste.listIterator();

        while(it.hasNext()) {
            if(it.next() != it.previous()) {
                ListIterator<T> it2 = liste.listIterator(it.nextIndex());
                while(it2.hasNext()) {
                    if(it2.next() == it.previous())
                        return false;
                }
            }
        }

        return true;
    }
}
