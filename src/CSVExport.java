import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CSVExport extends Export {
    @Override
    public void export(ArrayList<Artikel> al) {

        for(Artikel a : al) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formatiertesDatum = a.getAblaufdatum().toZonedDateTime().format(formatter);
            System.out.println(a.getNummer()+";"+a.getBezeichnung()+";"+a.getEinkaufspreis()+";"+formatiertesDatum+";"+a.getKategorienummer());
        }
    }
}
