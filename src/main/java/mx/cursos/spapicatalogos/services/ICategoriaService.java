package mx.cursos.spapicatalogos.services;

import mx.cursos.spapicatalogos.models.Categoria;
import mx.cursos.spapicatalogos.response.CategoriaResponseRest;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

public interface ICategoriaService {

    public ResponseEntity<CategoriaResponseRest> buscarCategorias();

    public ResponseEntity<CategoriaResponseRest> buscarPorId(Long id);

    public ResponseEntity<CategoriaResponseRest> guardarCategoria(Categoria request);

    public ResponseEntity<CategoriaResponseRest> actualizar(Categoria categoria,Long id);

    public ResponseEntity<CategoriaResponseRest> eliminarCategoria(Long id);

}
