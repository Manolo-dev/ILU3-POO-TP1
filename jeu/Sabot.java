package jeu;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
    private Integer nbCartes;
    private Carte[] cartes;
    private Integer modCount = 0;

    public Sabot(Carte[] cartes) {
        this.cartes = cartes;
        this.nbCartes = cartes.length;
    }

    public boolean estVide() {
        return this.nbCartes == 0;
    }

    public void ajouterCarte(Carte carte) {
        if(this.nbCartes >= this.cartes.length)
            throw new RuntimeException("Le sabot est plein");

        this.cartes[this.nbCartes] = carte;
        this.nbCartes++;

        this.modCount++;
    }

    public Carte piocher() {
        if(estVide())
            throw new RuntimeException("Il n'y a plus de cartes dans le sabot");

        Carte cartePiochée = cartes[nbCartes - 1];
        cartes[nbCartes - 1] = null;
        nbCartes--;
        modCount++;
        
        return cartePiochée;
    }

    @Override
    public Iterator<Carte> iterator() {
        return new SabotIterator();
    }

    private class SabotIterator implements Iterator<Carte> {
        private Integer index = nbCartes - 1;
        private Integer modCountAtCreation = modCount;
        private boolean removed = false;
    
        @Override
        public boolean hasNext() {
            checkForConcurrentModification();
            return index >= 0;
        }
    
        @Override
        public Carte next() {
            checkForConcurrentModification();
    
            if(!hasNext())
                throw new NoSuchElementException("Il n'y a plus de cartes dans le sabot");
    
            removed = false;
            return cartes[index--];
        }
    
        @Override
        public void remove() {
            checkForConcurrentModification();
    
            if(index == nbCartes - 1)
                throw new IllegalStateException("Aucune carte à supprimer, commencez par avancer dans l'itérateur");
    
            if(removed)
                throw new IllegalStateException("La carte a déjà été supprimée");
    
            piocher();
            removed = true;
            modCountAtCreation = modCount;
        }
    
        private void checkForConcurrentModification() {
            if(modCountAtCreation != modCount)
                throw new ConcurrentModificationException("Le sabot a été modifié après la création de l'itérateur");
        }
    }
    
}
