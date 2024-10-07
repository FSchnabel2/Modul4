import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class App {
	private static ArrayList<Artikel> al = artikellisteAusDBDummy();

	public static void main(String[] args)
	{
		//zu verarbeitende Artikelliste kommt aus untenstehender Hilfsmethode:
		ArrayList<Artikel> al = artikellisteAusDBDummy();

		//Je nach Kommandozeilenparameter sollen verschiedene Exporte durchgeführt werden.
		//In Eclipse können diese Paramter gesetzt werden über (noch ist keiner gesetzt):
		//über Run->Run Configurations -> Arguments -> Programm Arguments
		//Je nach Kommandozeilenparameter sollen verschiedene Exporte durchgef�hrt werden.
		//In Eclipse k�nnen diese Paramter gesetzt werden �ber (noch ist keiner gesetzt):
		//�ber Run->Run Configurations -> Arguments -> Programm Arguments
		if(args.length>0)
		{
			String parameter = args[0];
			switch(parameter)
			{
				case "CSV":
					//CSV-Export durchführen
					csvExport();
					break;
				case "JSON":
					//JSON-Export durchführen
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					String json = gson.toJson(al);
					System.out.println(json);
					break;
				default:
					csvExport();
					break;
			}
		} else //kein Parameter, dann CSV-Export (Standard)
		{
			//CSV-Export
			csvExport();
		}
	}
	public static void csvExport() {
		for(Artikel a : al) {
			System.out.println(a.getNummer()+";"+a.getBezeichnung()+";"+a.getEinkaufspreis()+";"+a.getAblaufdatum()+";"+a.getKategorienummer());
		}
	}

	/**
	 * Diese Methode liefert eine Beispielliste mit Artikeln,
	 * wie sie von der Export-Applikation verarbeitet werden soll.
	 * Später wird diese Methode die Daten aus einer Datenbank holen.
	 * Sp�ter wird diese Methode die Daten aus einer Datenbank holen.
	 * Das ist aber nicht Teil des aktuellen JAVA Export Prototpyen.
	 * @return Beispielliste, mit der gearbeitet werden soll.
	 */
	public static ArrayList<Artikel> artikellisteAusDBDummy() {
		ArrayList<Artikel> liste = new ArrayList<>();
		liste.add(new Artikel("1","Sekt",90.23,new GregorianCalendar(2019,3,4),24));
		liste.add(new Artikel("2","Fanta",9.90,new GregorianCalendar(2019,11,1),23));
		liste.add(new Artikel("3","Cola",9.90,new GregorianCalendar(2019,1,12),23));
		liste.add(new Artikel("4","Beinschinken",12.23,new GregorianCalendar(2019,11,12),45));
		liste.add(new Artikel("5","Speck",5.23,new GregorianCalendar(2018,2,3),45));
		return liste;
	}
}
