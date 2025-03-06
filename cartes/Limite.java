package cartes;

public abstract class Limite extends Carte {
	public Limite() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		return getClass() == obj.getClass();
	}
}
