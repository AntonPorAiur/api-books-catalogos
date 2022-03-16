package mx.cursos.spapicatalogos.dao;

import mx.cursos.spapicatalogos.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

    public Usuario findByNombreUsuario(String nombreUsuario);

    // O se pueden usar queries HSQL
}
