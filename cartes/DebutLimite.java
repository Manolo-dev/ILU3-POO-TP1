package cartes;

public class DebutLimite extends Limite {
	public DebutLimite() {
		super();
	}

	@Override
	public String toString() {
		return "Limite 50";
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof DebutLimite;
	}
}
