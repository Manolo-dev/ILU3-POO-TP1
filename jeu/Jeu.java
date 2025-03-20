package jeu;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import cartes.JeuDeCartes;
import cartes.Carte;
import utils.GestionCartes;

public class Jeu {
    Sabot sabot;

    Jeu() {
        Random rand = new Random();
        JeuDeCartes jeu = new JeuDeCartes();
        List<Carte> liste = new ArrayList<>();
        for(Carte carte : jeu.donnerCartes()) {
            liste.add(carte);
        }
        List<Carte> listeMelangee = GestionCartes.melanger(liste, rand);

        sabot = new Sabot(listeMelangee.toArray(new Carte[0]));
    }
}
