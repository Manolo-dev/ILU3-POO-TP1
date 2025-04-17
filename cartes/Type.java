package cartes;

public enum Type {
    ESSENCE("Panne Essence", "Bidon Essence", "Citerne"),
    CREVAISON("Crevaison", "Roue De Secours", "Increvable"),
    ACCIDENT("Accident", "Reparation", "As Du Volant"),
    FEU("Feu Rouge", "Feu Vert", "Vehicule Prioritaire");

    private final String nomAttaque;
    private final String nomParade;
    private final String nomBotte;

    Type(String nomAttaque, String nomParade, String nomBotte) {
        this.nomAttaque = nomAttaque;
        this.nomParade = nomParade;
        this.nomBotte = nomBotte;
    }
    
    public String getNom(Probleme probleme) {
        if(probleme instanceof Attaque)
            return nomAttaque;
        
        if(probleme instanceof Parade)
            return nomParade;
        
        if(probleme instanceof Botte)
            return nomBotte;
        
        return null;
    }
}