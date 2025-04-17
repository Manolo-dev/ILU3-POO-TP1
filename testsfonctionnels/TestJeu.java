package testsfonctionnels;

import jeu.*;
import strategies.*;

public class TestJeu {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();

        Joueur jack  = new Joueur("Jack", new Strategie() {});
        Joueur bill  = new Joueur("Bill", new Strategie() {});
        Joueur luffy = new Joueur("Luffy", new Presse() {});

        jeu.inscrire(jack, bill, luffy);

        System.out.println(jeu.lancer());
    }
}
