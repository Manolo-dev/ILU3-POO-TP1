package cartes;

public class Botte extends Probleme {
	public Botte(Type type) {
		super(type);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Botte && super.equals(obj);
	}
}
