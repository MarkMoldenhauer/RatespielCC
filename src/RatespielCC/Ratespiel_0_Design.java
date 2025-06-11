package RatespielCC;

/**
 * @Autor Dr. Tikko
 * 
 *        Hier wird das Spiel skiziert.
 *        Bedarf an Werkzeugen f�r einzelne Schritte ermittelt.
 */
public class Ratespiel_0_Design {

	/**
	 * Standardkonstruktor
	 */
	public Ratespiel_0_Design() {
		super();
		starteEinSpiel();
	}

	/**
	 * In dieser Methode wird das eigentliche Spiel gestartet.
	 */
	private void starteEinSpiel() {
		// TODO Zahl ausdenken 				-> Random	-> Zahl auf eine Variable speichern
		// TODO Spieler auffordern 			-> Sysout
		spieleEineRunde();
	}

	/**
	 * Hier wird eine komplette Spielrunde absolviert.
	 */
	private void spieleEineRunde() {
		// TODO Um eine Zahl bitten 				-> Sysout
		// TODO Zahl von der Konsole einlesen 	-> Scanner	-> Zahl auf eine Variable speichern
		// TODO Zahl vergleichen
		// TODO Wenn Zahl richtig:
		// TODO Ausgabe "Richtig"				-> Sysout
		wiederholeDasSpiel();
		// TODO Wenn Zahl falsch
		// TODO Ausgabe "Falsch! ..."			-> Sysout
		spieleEineRunde();
	}

	/**
	 * Hier wird evaluiert, ob der Spieler noch mal spelen m�chte. Davon h�ng die
	 * weitere Vorgehensweise ab.
	 */
	private void wiederholeDasSpiel() {
		// TODO Fragen, ob noch ein Spiel			-> Sysout
		// TODO Antwort von der Konsole einlesen 	-> Scanner (nur ein Zeichen)
		// TODO wenn ja:
		starteEinSpiel();
		// TODO wenn nein:
		verabschiede();
	}

	/**
	 * Hier wird das Spiel beendet. Wir denken vorausschauend: Hier k�nnen
	 * eventuelle weitere Aufgaben erledigt werden, z.B. speichern
	 */
	private void verabschiede() {
		// TODO Verabschieden			-> Sysout
	}

	/**
	 * Hier startet das Programm.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Das Spiel kann noch nicht gestartet werden, sonst stack overflow!");
	}

}
