package cartes;

public class JeuDeCartes {
    Configuration typesDeCartes[] = {
        new Configuration(new DebutLimite(), 4),
        new Configuration(new FinLimite(), 6),
        new Configuration(new Botte(Type.FEU      ), 1),
        new Configuration(new Botte(Type.ACCIDENT ), 1),
        new Configuration(new Botte(Type.CREVAISON), 1),
        new Configuration(new Botte(Type.ESSENCE  ), 1),
        new Configuration(new Attaque(Type.FEU      ), 5),
        new Configuration(new Attaque(Type.ACCIDENT ), 3),
        new Configuration(new Attaque(Type.CREVAISON), 3),
        new Configuration(new Attaque(Type.ESSENCE  ), 3),
        new Configuration(new Parade(Type.FEU      ), 14),
        new Configuration(new Parade(Type.ACCIDENT ), 6),
        new Configuration(new Parade(Type.CREVAISON), 6),
        new Configuration(new Parade(Type.ESSENCE  ), 6),
        new Configuration(new Borne(200), 4),
        new Configuration(new Borne(100), 12),
        new Configuration(new Borne(75), 10),
        new Configuration(new Borne(50), 10),
        new Configuration(new Borne(25), 10),
    };

    public String affichageJeuDeCartes() {
        StringBuilder sb = new StringBuilder();

        for(Configuration config : typesDeCartes)
            sb  .append(config.getNbExemplaires())
                .append("\t")
                .append(config.getCarte())
                .append("\n");

        return sb.toString();
    }

    public Carte[] donnerCartes() {
        int total = 0;
        
        for(Configuration config : typesDeCartes)
            total += config.getNbExemplaires();
    
        Carte[] cartes = new Carte[total];
        int index = 0;
    
        for(Configuration config : typesDeCartes)
            for(int i = 0; i < config.getNbExemplaires(); i++)
                cartes[index++] = config.getCarte();
    
        return cartes;
    }    

    private static class Configuration {
        private Integer nbExemplaires;
        private Carte carte;
    
        private Configuration(Carte carte, Integer nbExemplaires) {
            this.nbExemplaires = nbExemplaires;
            this.carte = carte;
        }

        public Carte getCarte() {
            return carte;
        }

        public Integer getNbExemplaires() {
            return nbExemplaires;
        }
    }
}
