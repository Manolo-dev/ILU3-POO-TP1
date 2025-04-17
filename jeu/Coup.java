package jeu;

import cartes.*;

public class Coup {
    Joueur joueur;
    Carte carte;
    Joueur cible;

    public Coup(Joueur joueur, Carte carte, Joueur cible) {
        this.joueur = joueur;
        this.carte = carte;
        this.cible = cible;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Carte getCarte() {
        return carte;
    }

    public Joueur getCible() {
        return cible;
    }

    public boolean estValide() {
        if(carte instanceof Attaque || carte instanceof Limite)
            return cible != null && cible != joueur;
    
        return cible == joueur;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Coup) {
            Coup other = (Coup) obj;
            return joueur.equals(other.joueur) && carte.equals(other.carte) && cible.equals(other.cible);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (joueur != null ? joueur.hashCode() : 0);
        hash = 31 * hash + (carte != null ? carte.hashCode() : 0);
        hash = 31 * hash + (cible != null ? cible.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        if(cible == null) {
            sb.append("défausse la carte ")
              .append(carte.toString());
        } else {
            sb.append("dépose la carte ")
              .append(carte.toString())
              .append(" dans la zone de jeu de ")
              .append(cible.toString());
        }

        return sb.toString();
    }

    public int compareTo(Coup coup) {
        Joueur cibleDuCoup = coup.getCible();

        if(joueur.equals(this.cible) && joueur.equals(cibleDuCoup))
            return 0;

        if(this.cible == null && cibleDuCoup == null)
            return 0;

        if(joueur.equals(this.cible))
            return 1;

        if(joueur.equals(cibleDuCoup))
            return -1;

        return this.cible.compareTo(cibleDuCoup);
    }
}
