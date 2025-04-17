package strategies;

import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import jeu.*;

public interface Strategie {
    default List<Coup> trierCoups(Set<Coup> coups) {
        if (coups == null || coups.isEmpty())
            throw new IllegalArgumentException("L'ensemble des coups ne peut pas être vide ou null.");

        List<Coup> listeCoups = new ArrayList<>(coups);

        Random random = new Random();
        Collections.sort(listeCoups, (c1, c2) -> {
            if (c1.equals(c2)) {
                return 0;
            }
            return random.nextBoolean() ? -1 : 1;
        });

        return listeCoups;
    }

    default Coup selectionnerCoup(Set<Coup> coups) {
        if (coups == null || coups.isEmpty())
            throw new IllegalArgumentException("L'ensemble des coups ne peut pas être vide ou null.");

        List<Coup> listeCoups = trierCoups(coups);
        return listeCoups.get(0);
    }

    default Coup selectionnerDefausse(Set<Coup> coups) {
        if (coups == null || coups.isEmpty())
            throw new IllegalArgumentException("L'ensemble des coups ne peut pas être vide ou null.");

        List<Coup> listeCoups = trierCoups(coups);
        return listeCoups.get(listeCoups.size() - 1);
    }
}
