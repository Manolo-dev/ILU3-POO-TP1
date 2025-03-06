package testsfonctionnels;

import cartes.*;

public class TestMethodeEquals {
    public static void main(String[] args) {
        Borne b1 = new Borne(25);
        Borne b2 = new Borne(25);

        System.out.println(b1.equals(b2));

        Attaque f1 = new Attaque(Type.FEU);
        Attaque f2 = new Attaque(Type.FEU);

        System.out.println(f1.equals(f2));

        Parade p1 = new Parade(Type.FEU);

        System.out.println(f1.equals(p1));
    }
}
