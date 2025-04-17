package cartes;

import java.util.HashMap;
import java.util.Map;

public class JeuDeCartes {
    private Map<Carte, Integer> typesDeCartes = new HashMap<>();
    public JeuDeCartes() {        
        typesDeCartes.put(new DebutLimite(), 4);
        typesDeCartes.put(new FinLimite(), 6);
        typesDeCartes.put(new Botte(Type.FEU      ), 1);
        typesDeCartes.put(new Botte(Type.ACCIDENT ), 1);
        typesDeCartes.put(new Botte(Type.CREVAISON), 1);
        typesDeCartes.put(new Botte(Type.ESSENCE  ), 1);
        typesDeCartes.put(new Attaque(Type.FEU      ), 5);
        typesDeCartes.put(new Attaque(Type.ACCIDENT ), 3);
        typesDeCartes.put(new Attaque(Type.CREVAISON), 3);
        typesDeCartes.put(new Attaque(Type.ESSENCE  ), 3);
        typesDeCartes.put(new Parade(Type.FEU      ), 14);
        typesDeCartes.put(new Parade(Type.ACCIDENT ), 6);
        typesDeCartes.put(new Parade(Type.CREVAISON), 6);
        typesDeCartes.put(new Parade(Type.ESSENCE  ), 6);
        typesDeCartes.put(new Borne(200), 4);
        typesDeCartes.put(new Borne(100), 12);
        typesDeCartes.put(new Borne(75), 10);
        typesDeCartes.put(new Borne(50), 10);
        typesDeCartes.put(new Borne(25), 10);
    }

    public String affichageJeuDeCartes() {
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Carte, Integer> config : typesDeCartes.entrySet())
            sb.append(config.getKey().toString())
              .append("\t")
              .append(config.getValue())
              .append("\n");

        return sb.toString();
    }

    public Carte[] donnerCartes() {
        int total = 0;
        
        for(Map.Entry<Carte, Integer> config : typesDeCartes.entrySet())
            total += config.getValue();
    
        Carte[] cartes = new Carte[total];
        int index = 0;
    
        for(Map.Entry<Carte, Integer> config : typesDeCartes.entrySet())
            for(int i = 0; i < config.getValue(); i++)
                cartes[index++] = config.getKey();
    
        return cartes;
    }

    public boolean checkCount() {
        Map<Carte, Integer> count = new HashMap<>();

        for(Carte carte : donnerCartes())
            count.put(carte, count.getOrDefault(carte, 0) + 1);
        
        for(Map.Entry<Carte, Integer> config : typesDeCartes.entrySet())
            if(count.get(config.getKey()) != config.getValue())
                return false;
        
        return true;
    }
}
