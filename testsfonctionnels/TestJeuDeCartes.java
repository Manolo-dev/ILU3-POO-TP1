package testsfonctionnels;

import cartes.JeuDeCartes;

public class TestJeuDeCartes {
    public static void main(String[] args) {
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        System.out.println(jeuDeCartes.affichageJeuDeCartes());
        System.out.println(jeuDeCartes.checkCount());
    }
}
