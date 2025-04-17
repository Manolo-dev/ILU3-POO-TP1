package cartes;

public class Borne extends Carte {
	private Integer km;

	public Borne(Integer km) {
		this.km = km;
	}

	public Integer getKm() {
		return km;
	}

	@Override
	public String toString() {
		return km + "KM";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Borne) {
			Borne b = (Borne) obj;
			return km.equals(b.getKm());
		}
		return false;
	}

	public int compareTo(Borne borne) {
		return km.compareTo(borne.getKm());
	}
}
