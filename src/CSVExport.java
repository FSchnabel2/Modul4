import java.util.ArrayList;

public class CSVExport extends Export {
    @Override
    public void export(ArrayList<Artikel> al) {
        for(Artikel a : al) {
            System.out.println(a.getNummer()+";"+a.getBezeichnung()+";"+a.getEinkaufspreis()+";"+a.getAblaufdatum()+";"+a.getKategorienummer());
        }
    }
}
