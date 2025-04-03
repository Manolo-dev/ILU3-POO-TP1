package jeu;

import java.util.Set;
import java.util.HashSet;
import java.util.Random;
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

    public HashSet<Coup> coupsPossibles(Set<Joueur> participants) {
        HashSet<Coup> coupsPossibles = new HashSet<Coup>();

        for(Carte carte : mainJoueur) {
            for(Joueur cible : participants) {
                Coup coup = new Coup(this, carte, cible);

                if(coup.estValide())
                    coupsPossibles.add(coup);
            }
        }

        return coupsPossibles;
    }

    public HashSet<Coup> coupsDefausse() {
        HashSet<Coup> coupsDefausse = new HashSet<Coup>();
    
        for(Carte carte : mainJoueur)
            coupsDefausse.add(new Coup(this, carte, null));
    
        return coupsDefausse;
    }

    public Carte retirerDeLaMain(Carte carte) {
        mainJoueur.jouer(carte);

        return carte;
    }

    public Coup choisirCoup(Set<Joueur> participants) {
        HashSet<Coup> coupsPossibles = coupsPossibles(participants);

        if(coupsPossibles.isEmpty())
            coupsPossibles = coupsDefausse();

        Random random = new Random();
        int index = random.nextInt(coupsPossibles.size());

        return (Coup) coupsPossibles.toArray()[index];
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
