package cartes;

public enum Type {
    FEU("FeuRouge", "FeuVert", "VehiculePrioritaire"),
    ESSENCE("PanneEssence", "Essence", "Citerne"),
    CREVAISON("PanneCrevaison", "Crevaison", "RoueDeSecours"),
    ACCIDENT("Accident", "Reparation", "Asurance");

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