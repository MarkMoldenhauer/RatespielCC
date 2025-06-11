package RatespielCC;

import java.util.Random;
import java.util.Scanner;

/**
 * @Autor Dr. Tikko
 * 
 * Ein Spiel, in dem das Programm eine Zahl ausgibt und der Spieler versucht, sie zu erraten.
 */
public class RatespielCC {

	// Konstanten
	private static final String SPIEL_GESTARTET = "Ich habe eine Zahl ausgedacht. Rate sie! \n";
	private static final String ZAHL_EINGEBEN = "Gebe die Zahl ein und drücke die Enter-Taste\n";
	private static final String RICHTIG = "Richtig!\n";
	private static final String FALSCH = "Falsch! Versuch es noch mal!\n";
	private static final String NOCH_MAL = "Noch mal spielen? Wenn ja, tippe 1 (und Enter), sonst egal was (und Enter).\n";
	private static final String TSCHUESS = "Tschüss! Bis zum nächsten Mal :-)";
	private static final String JA = "1";
	private static final String KEINE_ZAHL = "Das war keine Zahl. Interpretiere als ";
	private static final String VERSUCHE_ANZEIGE = "Du hast %d Versuch(e) gebraucht.\n";
	private static final String FRAGE_UNTERGRENZE = "Gib die Untergrenze ein:";
	private static final String FRAGE_OBERGRENZE = "Gib die Obergrenze ein:";
	private static final String FALSCHE_OBERGRENZE = "Die Obergrenze muss größer als die Untergrenze sein. Bitte erneut eingeben.";
	private static final String SPIELER1_EINGABE = "Spieler 1: Denke dir eine Zahl aus.";
	private static final String SPIELER1_GIBT_ZAHL = "Spieler 1, gib die geheime Zahl ein:";
	private static final String MODUS_AUSWAHL = "Willkommen beim Ratespiel.\nBitte Modus wählen: 1 = Gegen Computer, 2 = Zwei-Spieler-Modus";
	private static final String UNGUELTIGE_EINGABE = "Ungültige Eingabe. Bitte eine ganze Zahl eingeben.";

	private int meineZahl;
	private Random zufall = new Random();
	private Scanner scan = new Scanner(System.in);
	private int untergrenze = -1;
	private int obergrenze = -1;
	private int counter = 0;
	private int modus = -1;

	/**
	 * Standardkonstruktor – spielt gegen den Computer.
	 */
	public RatespielCC() {
		super();
		starteEinSpiel();
	}

	/**
	 * Konstruktor mit Spielmodus (1 = gegen Computer, 2 = gegen Mitspieler)
	 */
	public RatespielCC(int modus) {
		this.modus = modus;
		starteEinSpiel();
	}

	/**
	 * In dieser Methode wird das eigentliche Spiel gestartet.
	 */
	private void starteEinSpiel() {
		setzeGrenzen();
		counter = 0;
		meineZahl = ausdenke();
		System.out.println(meineZahl); // Eingetippte Zahl; nur für uns relevant
		ausgabe(SPIEL_GESTARTET);
		spieleEineRunde();
	}

	/**
	 * Hier wird eine komplette Spielrunde absolviert.
	 */
	private void spieleEineRunde() {
		counter++;
		ausgabe(ZAHL_EINGEBEN);
		int zahl = zahlEinlesen();

		if (zahl == meineZahl) {
			ausgabe(RICHTIG);
			ausgabe(String.format(VERSUCHE_ANZEIGE, counter));
			wiederholeDasSpiel();
		} else {
			ausgabe(FALSCH);
			spieleEineRunde();
		}
	}

	/**
	 * Hier wird evaluiert, ob der Spieler noch mal spelen m�chte. Davon h�ng die
	 * weitere Vorgehensweise ab.
	 */
	private void wiederholeDasSpiel() {
		ausgabe(NOCH_MAL);
		String antwort = textEinlesen();

		if (antwort.equals(JA))
			starteEinSpiel();
		else
			verabschiede();
	}

	/**
	 * Hier wird das Spiel beendet. Wir denken vorausschauend: Hier k�nnen
	 * eventuelle weitere Aufgaben erledigt werden, z.B. speichern
	 */
	private void verabschiede() {
		ausgabe(TSCHUESS);
		scan.close();
	}
	
	/**
	 * Hier werden die Grenzen des Ratespiels gesetzt. Der Spieler gibt die
	 * Unter- und Obergrenze ein. Die Obergrenze muss dabei größer als die
	 * Untergrenze sein.
	 */
	private void setzeGrenzen() {
		ausgabe(FRAGE_UNTERGRENZE);
		untergrenze = zahlEinlesen();
		ausgabe(FRAGE_OBERGRENZE);
		obergrenze = zahlEinlesen();

		if (obergrenze <= untergrenze) {
			ausgabe(FALSCHE_OBERGRENZE);
			setzeGrenzen();
		}
	}

	/**
	 * Generiert eine Zufalszahl aus
	 * 
	 * @return
	 */
	private int ausdenke() {
		if (modus == 1) {
			return zufall.nextInt(untergrenze, obergrenze + 1);
		} else {
			ausgabe(SPIELER1_EINGABE);
			return eingabeGrenze(SPIELER1_GIBT_ZAHL);
		}
	}

	/**
	 * Liest die Benutzereingabe als Text ein
	 */
	private String textEinlesen() {
		return scan.next();
	}

	/**
	 * Liest die Benutzereingabe als eine Zahl ein
	 * 
	 * @return eine Zahl, wenn die Eingabe eine Zahl war, char-Wert entsprechend dem
	 *         ersten Zeichen der Eingabe
	 */
	private int zahlEinlesen() {
		String eingabe = textEinlesen();
		int zahl;
		try {
			zahl = Integer.parseInt(eingabe);
		} catch (NumberFormatException e) {
			zahl = eingabe.charAt(0);
			ausgabe(KEINE_ZAHL + zahl);
		}
		return zahl;
	}

	/**
	 * Gibt einen Text auf die Konsole aus
	 * 
	 * @param text auszugebene Text
	 */
	private void ausgabe(String text) {
		System.out.println(text);
	}

	/**
	 * Fragt eine gültige Zahl als Grenze ab.
	 */
	private int eingabeGrenze(String aufforderung) {
		int wert;
		while (true) {
			ausgabe(aufforderung);
			try {
				wert = Integer.parseInt(scan.next());
				break;
			} catch (NumberFormatException e) {
				ausgabe(UNGUELTIGE_EINGABE);
			}
		}
		return wert;
	}

	/**
	 * Hier startet das Programm.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(MODUS_AUSWAHL);
		int modus = scanner.nextInt();
		new RatespielCC(modus);
	}

}
