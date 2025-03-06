package cartes;

public class Attaque extends Bataille {
	public Attaque(Type type) {
		super(type);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Attaque && super.equals(obj);
	}
}
