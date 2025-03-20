package jeu;

import cartes.Carte;

public class Joueur {
    private String name;
    private ZoneDeJeu zoneDeJeu;
    private MainJoueur mainJoueur;

    public void donner(Carte c) {
        mainJoueur.prendre(c);
    }

    public Carte prendreCarte(Sabot sabot) {
        Carte carte = sabot.piocher();

        if(carte == null)
            return null;

        mainJoueur.prendre(carte);

        return carte;
    }

    public boolean estDepotAutorise(Carte c) {
        return zoneDeJeu.estDepotAutorise(c);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Joueur)
            return name.equals(((Joueur) obj).name);

        return false;
    }
}
