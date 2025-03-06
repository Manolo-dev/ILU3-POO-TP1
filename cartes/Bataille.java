package cartes;

public abstract class Bataille extends Probleme {
	protected Bataille(Type type) {
		super(type);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Bataille)
			return super.equals(obj);
		return false;
	}
}
