package jeu;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Comparator;
import java.util.TreeSet;

import cartes.JeuDeCartes;
import cartes.Carte;
import utils.GestionCartes;

public class Jeu {
    private Sabot sabot;
    private List<Joueur> joueurs = new ArrayList<>();
    private Iterator<Joueur> iterator;
    private static final int NBCARTES = 6;

    public Jeu() {
        Random rand = new Random();
        JeuDeCartes jeu = new JeuDeCartes();
        List<Carte> liste = new ArrayList<>();
        for(Carte carte : jeu.donnerCartes()) {
            liste.add(carte);
        }
        List<Carte> listeMelangee = GestionCartes.melanger(liste, rand);

        sabot = new Sabot(listeMelangee.toArray(new Carte[0]));
    }

    public void inscrire(Joueur... listeJoueurs) {
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

    public String jouerTour(Joueur joueur) {
        StringBuilder sb = new StringBuilder();

        Carte cartePiochee = joueur.prendreCarte(sabot);
        HashSet<Joueur> participants = new HashSet<>(joueurs);
        
        sb.append(joueur.toString())
          .append(" a pioché la carte ")
          .append(cartePiochee.toString())
          .append("\n");

        sb.append(joueur.afficherEtatJoueur())
          .append("\n");
        
        Coup coup = joueur.choisirCoup(participants);

        sb.append(joueur.toString())
          .append(" ")
          .append(coup.toString())
          .append("\n");

        if(coup.getCible() == null) {
            joueur.retirerDeLaMain(coup.getCarte());
            sabot.ajouterCarte(coup.getCarte());
        } else {
            joueur.retirerDeLaMain(coup.getCarte());
            if(coup.getCible().deposer(coup.getCarte()) == -1)
                sabot.ajouterCarte(coup.getCarte());
        }

        return sb.toString();
    }

    private Joueur donnerJoueurSuivant() {
        if(!iterator.hasNext())
            iterator = joueurs.iterator();

        Joueur joueurSuivant = iterator.next();
        return joueurSuivant;
    }

    public String lancer() {
        StringBuilder sb = new StringBuilder();

        distribuerCartes();
        iterator = joueurs.iterator();

        // b. si l’un des joueurs est arrivé à 1000 bornes le jeu est terminé

        while(!sabot.estVide()) {
            Joueur joueurSuivant = donnerJoueurSuivant();
            sb.append(jouerTour(joueurSuivant));

            for(Joueur joueur : joueurs) {
                if(joueur.getKmParcourus() >= 1000) {
                    sb.append("Le joueur ")
                      .append(joueur.toString())
                      .append(" a gagné !");
                    return sb.toString();
                }
            }
        }

        sb.append("Les joueurs sont trop lents, le sabot est vide !\n")
          .append("Le classement est :\n");

        List<Joueur> classement = classement();

        for(Joueur joueur : classement)
            sb.append(joueur.toString())
              .append(" : ")
              .append(joueur.getKmParcourus())
              .append("\n");

        return sb.toString();
    }

    public List<Joueur> classement() {
        TreeSet<Joueur> classement = new TreeSet<>(new Comparator<Joueur>() {
            @Override
            public int compare(Joueur j1, Joueur j2) {
                return Integer.compare(j2.getKmParcourus(), j1.getKmParcourus());
            }
        });

        classement.addAll(joueurs);

        return new ArrayList<>(classement);
    }
}
