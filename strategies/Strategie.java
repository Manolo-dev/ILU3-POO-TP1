package strategies;

import java.util.Set;
import java.util.Random;
import java.util.Comparator;
import java.util.TreeSet;

import jeu.*;

public interface Strategie {
    default TreeSet<Coup> trierCoups(Set<Coup> coups) {
        if (coups == null || coups.isEmpty())
            throw new IllegalArgumentException("L'ensemble des coups ne peut pas être vide ou null.");

        TreeSet<Coup> coupsTries = new TreeSet<>(new Comparator<Coup>() {
            @Override
            public int compare(Coup c1, Coup c2) {
                Random random = new Random();

                if(c1.compareTo(c2) != 0)
                    return random.nextBoolean() ? 1 : -1;
                
                return 0;
            }
        });

        coupsTries.addAll(coups);

        return coupsTries;
    }

    default Coup selectionnerCoup(Set<Coup> coups) {
        if (coups == null || coups.isEmpty())
            throw new IllegalArgumentException("L'ensemble des coups ne peut pas être vide ou null.");

        TreeSet<Coup> coupsTries = trierCoups(coups);
        
        return coupsTries.first();
    }

    default Coup selectionnerDefausse(Set<Coup> coups) {
        if (coups == null || coups.isEmpty())
            throw new IllegalArgumentException("L'ensemble des coups ne peut pas être vide ou null.");

        TreeSet<Coup> coupsTries = trierCoups(coups);

        return coupsTries.last();
    }
}
