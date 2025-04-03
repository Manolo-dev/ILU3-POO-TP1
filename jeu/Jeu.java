package jeu;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import cartes.JeuDeCartes;
import cartes.Carte;
import utils.GestionCartes;

public class Jeu {
    private Sabot sabot;
    private List<Joueur> joueurs = new ArrayList<>();
    private static final int NBCARTES = 6;

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

    public void inscrire(List<Joueur> listeJoueurs) throws RuntimeException {
        for(Joueur joueur : listeJoueurs) {
            if(!joueurs.contains(joueur)) {
                if(joueurs.size() >= 5)
                    throw new RuntimeException("Le nombre de joueurs est limité à 4");
                joueurs.add(joueur);
            }
        }
    }

    public void distribuerCartes() {
        for(Joueur joueur : joueurs) {
            for(int i = 0; i < NBCARTES; i++) {
                joueur.donner(sabot.piocher());
            }
        }
    }
}
