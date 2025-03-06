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

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Probleme && getClass().equals(obj.getClass())) {
			Probleme p = (Probleme) obj;
			return getType().equals(p.getType());
		}
		return false;
	}
}
