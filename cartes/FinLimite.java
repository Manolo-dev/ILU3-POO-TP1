package cartes;

public class FinLimite extends Limite {
	public FinLimite() {
		super();
	}

	@Override
	public String toString() {
		return "Fin Limite";
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof DebutLimite;
	}
}
