package testsfonctionnels;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class TestGestionCartes {
    public static void main(String[] args) {
        Random rand = new Random();
        JeuDeCartes jeu = new JeuDeCartes();
        List<Carte> listeCarteNonMelangee = new LinkedList<>();
        for (Carte carte : jeu.donnerCartes()) {
            listeCarteNonMelangee.add(carte);
        }
        List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);

        System.out.println(listeCartes);

        listeCartes = GestionCartes.melanger(listeCartes, rand);

        System.out.println(listeCartes);

        System.out.println("liste mélangée sans erreur ? " + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));

        listeCartes = GestionCartes.rassembler(listeCartes);

        System.out.println(listeCartes);

        System.out.println("liste rassemblée sans erreur ? " + GestionCartes.verifierRassemblement(listeCartes));

    }
}
