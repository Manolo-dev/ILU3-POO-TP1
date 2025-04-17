package strategies;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Random;

import jeu.Coup;
import jeu.Joueur;
import cartes.*;

public interface Presse extends Strategie, Priorite {
    private int comparerCartes(Joueur joueur, Carte carte1, Carte carte2) {
        Integer comparaison = null;

        Random random = new Random();
        
        comparaison = donnerPrioriteLimites(carte1, carte2);

        if(comparaison != null) {
            return comparaison;
        }
        
        comparaison = donnerPrioriteBornes(carte1, carte2);
        if(comparaison != null)
            return comparaison;
        
        Carte carteSommet = joueur.donnerSommetPile();

        if(carteSommet instanceof Attaque) {
            Attaque attaque = (Attaque) carteSommet;

            Type typeProbleme = attaque.getType();
            if(joueur.donnerBottes().contains(new Botte(typeProbleme)))
                typeProbleme = Type.FEU;
            
            comparaison = donnerPrioriteBottes(typeProbleme, carte1, carte2);

            if(comparaison != null)
                return comparaison;
        }
        
        comparaison = donnerPrioriteParades(carte1, carte2);

        if(comparaison != null)
            return comparaison;

        if (random.nextBoolean())
            return 1;
        else
            return -1;
        
    }

    @Override
    default TreeSet<Coup> trierCoups(Set<Coup> coups) {
        if(coups == null || coups.isEmpty())
            throw new IllegalArgumentException("L'ensemble des coups ne peut pas être vide ou null.");

        TreeSet<Coup> coupsTries = new TreeSet<>(new Comparator<Coup>() {
            @Override
            public int compare(Coup c1, Coup c2) {
                int comparaison = comparerCartes(c1.getJoueur(), c1.getCarte(), c2.getCarte());

                if(comparaison != 0)
                    return comparaison;
                
                return c1.compareTo(c2);
            }
        });
        coupsTries.addAll(coups);

        return coupsTries;
    }
}