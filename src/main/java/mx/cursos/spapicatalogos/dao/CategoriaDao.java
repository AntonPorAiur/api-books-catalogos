package mx.cursos.spapicatalogos.dao;

import mx.cursos.spapicatalogos.models.Categoria;
import org.springframework.data.repository.CrudRepository;

 // Entre diamantes, tipo entity y el tipo del Id
public interface CategoriaDao extends CrudRepository<Categoria, Long> {

}
