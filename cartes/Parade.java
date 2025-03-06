package cartes;

public class Parade extends Bataille {
	public Parade(Type type) {
		super(type);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Parade && super.equals(obj);
	}
}
