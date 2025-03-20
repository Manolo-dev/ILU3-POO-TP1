package cartes;

public final class Cartes {
    public static final Attaque FEU_ROUGE = new Attaque(Type.FEU);
    public static final Parade FEU_VERT   = new Parade(Type.FEU);
    public static final Botte PRIORITAIRE = new Botte(Type.FEU);

    public static final Attaque PANNE = new Attaque(Type.ESSENCE);
    public static final Parade BIDON  = new Parade(Type.ESSENCE);
    public static final Botte CITERNE = new Botte(Type.ESSENCE);

    

    private Cartes() {}    
}
