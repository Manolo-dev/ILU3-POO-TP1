package jeu;

import java.util.Set;
import java.util.HashSet;
import cartes.*;
import strategies.Strategie;

public class Joueur {
    private String name;
    private ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
    private MainJoueur mainJoueur = new MainJoueur();
    private Strategie strategie;

    public Joueur(String name, Strategie strategie) {
        this.name = name;
        this.strategie = strategie;
    }

    public String getName() {
        return name;
    }

    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }

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
            return strategie.selectionnerDefausse(coupsDefausse());
        
        return strategie.selectionnerCoup(coupsPossibles);
    }

    public String afficherEtatJoueur() {
        StringBuilder sb = new StringBuilder();

        sb.append("Il a : ")
          .append(zoneDeJeu.toString())
          .append(mainJoueur.getList());

        return sb.toString();
    }

    public Bataille donnerSommetPile() {
        return zoneDeJeu.getSommetPile();
    }

    public int deposer(Carte c) {
        return zoneDeJeu.deposer(c);
    }

    public int getKmParcourus() {
        return zoneDeJeu.donnerKmParcourus();
    }

    public Set<Botte> donnerBottes() {
        return zoneDeJeu.getBottes();
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

    public int compareTo(Joueur joueur) {
        if(getKmParcourus() == joueur.getKmParcourus())
            return getName().compareTo(joueur.getName());
        
        return Integer.compare(getKmParcourus(), joueur.getKmParcourus());
    }
}
