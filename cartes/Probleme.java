package cartes;

public abstract class Probleme extends Carte {
	private Type type;
	
	protected Probleme(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return getType().getNom(this);
	}

}
