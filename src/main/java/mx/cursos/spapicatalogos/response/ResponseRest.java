package mx.cursos.spapicatalogos.response;

import lombok.Getter;
import java.util.ArrayList;
import java.util.HashMap;

// Un TO para los response
@Getter
public class ResponseRest {

    private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

    public void setMetadata(String tipo, String codigo, String date) {
       HashMap<String, String> mapa = new HashMap<>();
       mapa.put("tipo",tipo);
       mapa.put("codigo",codigo);
       mapa.put("date",date);

       metadata.add(mapa);
    }
}
