package jeu;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import cartes.*;


public class ZoneDeJeu {
    private List<Limite> limitations = new ArrayList<Limite>();
    private List<Bataille> batailles = new ArrayList<Bataille>();
    private Set<Botte>        bottes = new HashSet<Botte>();
    private Collection<Borne> bornes = new ArrayList<Borne>();

    private boolean estPrioritaire() {
        Botte prioritaire_degenerate = new Botte(Type.FEU);

        return bottes.contains(prioritaire_degenerate);
    }

    public int donnerLimitationVitesse() {
        if(limitations.isEmpty())
            return 200;
        
        if(limitations.get(limitations.size() - 1) instanceof FinLimite)
            return 200;
        
        if(estPrioritaire())
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

        if(c instanceof Botte) {
            bottes.add((Botte) c);
            return 0;
        }

        return -1;
    }

    public boolean peutAvancer() {
        if(batailles.isEmpty())
            return estPrioritaire();
        
        Bataille carte = batailles.get(batailles.size() - 1);
    
        if(carte instanceof Attaque) {
            Attaque attaque = (Attaque) carte;

            if(attaque.getType() == Type.FEU)
                return estPrioritaire();
            
            Type type = attaque.getType();

            if(bottes.contains(new Botte(type)))
                return true;
        }
        
        if(!(carte instanceof Parade))
            return false;
        
        if(estPrioritaire())
            return true;
        
        Parade parade = (Parade) carte;

        if(parade.getType() != Type.FEU)
            return false;

        return true;
    }

    private boolean estDepotFeuVertAutorise() {
        if(estPrioritaire())
            return false;

        if(batailles.isEmpty())
            return true;
        
        Bataille carte = batailles.get(batailles.size() - 1);

        if(carte instanceof Attaque) {
            Attaque attaque = (Attaque)carte;

            if(attaque.getType() == Type.FEU)
                return true;
            
            if(bottes.contains(new Botte(attaque.getType())))
                return true;
        }
        
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
        if(estPrioritaire())
            return false;

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
        Type type = bataille.getType();

        if(bottes.contains(new Botte(type)))
            return false;

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
        
        if(c instanceof Botte)
            return true;
        
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Bottes : [");
        for(Botte b : bottes) {
            sb.append(b.toString());
            sb.append(", ");
        }
        if(!bottes.isEmpty())
            sb.delete(sb.length() - 2, sb.length());
        sb.append("]; ");

        sb.append("Limite : ");
        if(donnerLimitationVitesse() != 200)
            sb.append(donnerLimitationVitesse());
        sb.append("; ");

        sb.append("Bataille : ");
        if(batailles.isEmpty())
            sb.append("null");
        else
            sb.append(batailles.get(batailles.size() - 1).toString());
        sb.append("; ");

        return sb.toString();
    }
}
