package strategies;

import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Type;

public interface Priorite {

	public default Integer donnerPrioriteBornes(Carte carte1, Carte carte2) {
		if (carte1 instanceof Borne && carte2 instanceof Borne) {
			Borne borne1 = (Borne) carte1;
			Borne borne2 = (Borne) carte2;
			return borne1.compareTo(borne2);
		}
		if (carte1 instanceof Borne) {
			return 1;
		}
		if (carte2 instanceof Borne) {
			return -1;
		}
		return null;
	}

	public default Integer donnerPrioriteParades(Carte carte1, Carte carte2) {
		if (carte1 instanceof Parade && carte2 instanceof Parade) {
			Parade parade1 = (Parade) carte1;
			Parade parade2 = (Parade) carte2;
			return parade1.compareTo(parade2);
		}
		if (carte1 instanceof Parade) {
			return 1;
		}
		if (carte2 instanceof Parade) {
			return -1;
		}
		return null;
	}

	public default Integer donnerPrioriteBottes(Type typeProbleme, Carte carte1, Carte carte2) {
		if (carte1 instanceof Botte && ((Botte) carte1).getType() == typeProbleme) {
			return 1;
		}
		if (carte2 instanceof Botte && ((Botte) carte2).getType() == typeProbleme) {
			return -1;
		}
		return null;
	}

	public default Integer donnerPrioriteLimites(Carte carte1, Carte carte2) {
		if (carte1 instanceof FinLimite) {
			return 1;
		}
		if (carte2 instanceof FinLimite) {
			return -1;
		}
		return null;
	}
}
