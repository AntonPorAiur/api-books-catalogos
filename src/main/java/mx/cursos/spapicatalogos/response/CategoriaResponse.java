package mx.cursos.spapicatalogos.response;

import lombok.Data;
import mx.cursos.spapicatalogos.models.Categoria;
import java.util.List;

@Data
public class CategoriaResponse {

    private List<Categoria> categoria;

}
