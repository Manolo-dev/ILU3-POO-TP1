package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class MainJoueur implements Iterable<Carte> {
    private List<Carte> main;

    public MainJoueur() {
        this.main = new ArrayList<>();
    }

    public void prendre(Carte c) {
        main.add(c);
    }

    public void jouer(Carte c) {
        assert main.contains(c) : "Erreur : la carte n'est pas dans la main du joueur !";
        main.remove(c);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Carte c : main) {
            sb.append("- ").append(c).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Carte> iterator() {
        return main.iterator();
    }
}
