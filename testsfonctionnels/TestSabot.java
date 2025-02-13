package testsfonctionnels;

import java.util.Iterator;

import jeu.Sabot;
import cartes.Carte;
import cartes.Botte;
import cartes.JeuDeCartes;
import cartes.Type;

public class TestSabot {
    public static void main(String[] args) {
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        Sabot sabot;
        
        sabot = new Sabot(jeuDeCartes.donnerCartes());

        while(!sabot.estVide())
            System.out.println("Je pioche " + sabot.piocher());
        
        System.out.println("=====================================");
        
        sabot = new Sabot(jeuDeCartes.donnerCartes());
        Iterator<Carte> it = sabot.iterator();
        while(it.hasNext()) {
            System.out.println("Je pioche " + it.next());
            it.remove();
        }

        System.out.println("=====================================");
        
        try {
            sabot = new Sabot(jeuDeCartes.donnerCartes());
            Iterator<Carte> it2 = sabot.iterator();
            while(it2.hasNext()) {
                System.out.println("Je pioche " + it2.next());
                it2.remove();
                sabot.piocher();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("=====================================");
        
        try {
            sabot = new Sabot(jeuDeCartes.donnerCartes());
            sabot.piocher();
            Iterator<Carte> it2 = sabot.iterator();
            while(it2.hasNext()) {
                System.out.println("Je pioche " + it2.next());
                it2.remove();
                sabot.ajouterCarte(new Botte(Type.ACCIDENT));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
