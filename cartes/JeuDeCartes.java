package cartes;

public class JeuDeCartes {
    Configuration configuration[] = {
        new Configuration(new Borne(25), 10),
        new Configuration(new Borne(50), 10),
        new Configuration(new Borne(75), 10),
        new Configuration(new Borne(100), 10),
        new Configuration(new Borne(200), 10),
        new Configuration(new Parade(Type.FEU), 14),
        new Configuration(new FinLimite(), 6),
        new Configuration(new Parade(Type.ESSENCE), 6),
        new Configuration(new Parade(Type.CREVAISON), 6),
        new Configuration(new Parade(Type.ACCIDENT), 6),
        new Configuration(new Attaque(Type.FEU), 5),
        new Configuration(new DebutLimite(), 4),
        new Configuration(new Attaque(Type.CREVAISON), 3),
        new Configuration(new Attaque(Type.ACCIDENT), 3),
        new Configuration(new Botte(Type.FEU), 1),
        new Configuration(new Botte(Type.ESSENCE), 1),
        new Configuration(new Botte(Type.CREVAISON), 1),
        new Configuration(new Botte(Type.ACCIDENT), 1)
    };

    public String affichageJeuDeCartes() {
        StringBuilder sb = new StringBuilder();

        for(Configuration config : configuration) {
            sb.append(config.getNbExemplaires());
            sb.append(" ");
            sb.append(config.getCarte());
        }

        return sb.toString();
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
