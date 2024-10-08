import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class JSONExport extends Export {
    @Override
    public void export(ArrayList<Artikel> al) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(al);
    }
}
