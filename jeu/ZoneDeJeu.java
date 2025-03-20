package jeu;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import cartes.*;


public class ZoneDeJeu {
    private List<Limite> limitations = new ArrayList<Limite>();
    private List<Bataille> batailles = new ArrayList<Bataille>();
    private Collection<Borne> bornes = new ArrayList<Borne>();

    public int donnerLimitationVitesse() {
        if(limitations.isEmpty())
            return 200;
        
        if(limitations.get(limitations.size() - 1) instanceof FinLimite)
            return 200;

        return 50;
    }

    public int donnerKmParcourus() {
        int km = 0;

        for(Borne b : bornes) {
            km += b.getKm();
        }

        return km;
    }

    public int deposer(Carte c) {
        if(c instanceof Borne) {
            bornes.add((Borne) c);
            return 0;
        }

        if(c instanceof Limite) {
            limitations.add((Limite) c);
            return 0;
        }

        if(c instanceof Bataille) {
            batailles.add((Bataille) c);
            return 0;
        }

        return -1;
    }

    public boolean peutAvancer() {
        if(batailles.isEmpty())
            return false;
        
        Bataille carte = batailles.get(batailles.size() - 1);
        
        if(!(carte instanceof Parade))
            return false;
        
        Parade parade = (Parade) carte;

        if(parade.getType() != Type.FEU)
            return false;

        return true;
    }

    private boolean estDepotFeuVertAutorise() {
        if(batailles.isEmpty())
            return true;
        
        Bataille carte = batailles.get(batailles.size() - 1);

        if(carte instanceof Attaque && ((Attaque) carte).getType() == Type.FEU)
            return true;
        
        if(carte instanceof Parade && ((Parade) carte).getType() != Type.FEU)
            return true;
        
        return false;
    }

    private boolean estDepotBorneAutorise(Borne borne) {
        if(!peutAvancer())
            return false;
    
        if(borne.getKm() > donnerLimitationVitesse())
            return false;
    
        int totalKm = donnerKmParcourus() + borne.getKm();

        if(totalKm > 1000)
            return false;
    
        return true;
    }
    
    private boolean estDepotLimiteAutorise(Limite limite) {
        if(limite instanceof DebutLimite) {
            if(limitations.isEmpty())
                return true;
            
            if(!(limitations.get(limitations.size() - 1) instanceof DebutLimite))
                return true;
            
            return false;
        } else {
            if(limitations.isEmpty())
                return false;
            
            if(!(limitations.get(limitations.size() - 1) instanceof DebutLimite))
                return false;
            
            return true;
        }
    }

    private boolean estDepotBatailleAutorise(Bataille bataille) {
        if(bataille instanceof Attaque) {
            return peutAvancer();
        } else {
            Parade parade = (Parade) bataille;

            if(parade.getType() == Type.FEU)
                return estDepotFeuVertAutorise();
            
            if(batailles.isEmpty())
                return false;

            Bataille carte = batailles.get(batailles.size() - 1);
            
            if(!(carte instanceof Attaque))
                return false;
            
            if(carte.getType() != parade.getType())
                return false;
            
            return true;
        }
    }

    public boolean estDepotAutorise(Carte c) {
        if(c instanceof Borne)
            return estDepotBorneAutorise((Borne) c);
        
        if(c instanceof Limite)
            return estDepotLimiteAutorise((Limite) c);
        
        if(c instanceof Bataille)
            return estDepotBatailleAutorise((Bataille) c);
        
        return false;
    }
}
