package mx.cursos.spapicatalogos.services;

import mx.cursos.spapicatalogos.dao.CategoriaDao;
import mx.cursos.spapicatalogos.models.Categoria;
import mx.cursos.spapicatalogos.response.CategoriaResponseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    private static final Logger log = LoggerFactory.getLogger(CategoriaServiceImpl.class);

    @Autowired
    CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoriaResponseRest> buscarCategorias() {

        CategoriaResponseRest response = new CategoriaResponseRest();

        try{

            List<Categoria> categoriaList = (List<Categoria>) categoriaDao.findAll();
            response.getCategoriaResponse().setCategoria(categoriaList);
            response.setMetadata("Respuesta ok","1","Respuesta exitosa");

        }catch (Exception e) {
            response.setMetadata("Respuesta error","2","Respuesta incorrecta");
            log.error(e.getMessage());
            return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoriaResponseRest> buscarPorId(Long id) {

        CategoriaResponseRest response = new CategoriaResponseRest();

        try{
            Optional<Categoria> cat = categoriaDao.findById(id);

            if(cat.isPresent()) {
                List<Categoria> categoriaList = new ArrayList<>();
                categoriaList.add(cat.get());

                response.setMetadata("Respuesta ok","1","Respuesta exitosa");
                response.getCategoriaResponse().setCategoria(categoriaList);

            }else {
                response.setMetadata("Respuesta ok","1","No existe esa categoria");
                return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e) {
            log.error(e.getMessage());
            response.setMetadata("Respuesta error","2","Respuesta incorrecta");
            return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoriaResponseRest> guardarCategoria(Categoria request) {
        CategoriaResponseRest response = new CategoriaResponseRest();

        try{
            Categoria saved = categoriaDao.save(request);

            if(saved != null) {
                List<Categoria> categoriaList = new ArrayList<>();
                categoriaList.add(saved);
                response.setMetadata("Respuesta ok","1","Respuesta exitosa");

            }else {
                response.setMetadata("Respuesta error","2","No se logro salvar");
                return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e)  {
            response.setMetadata("Respuesta error","2","No se logro salvar");
            return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.CREATED);
    }

    @Override
    @Transactional(readOnly = false)
    public ResponseEntity<CategoriaResponseRest> actualizar(Categoria categoria, Long id) {

        CategoriaResponseRest response = new CategoriaResponseRest();

        List<Categoria> categoriaList = new ArrayList<>();

        try{
            Optional<Categoria> categoriaBusca = categoriaDao.findById(id);

            if(categoriaBusca.isPresent()) {
                categoriaBusca.get().setNombre(categoria.getNombre());
                categoriaBusca.get().setDescripcion(categoria.getDescripcion());

                Categoria categoriaAct = categoriaDao .save(categoriaBusca.get());

                if(categoriaAct != null) {
                    response.setMetadata("Respuesta ok","1","Categoria actualizada");
                    categoriaList.add(categoriaAct);
                    response.getCategoriaResponse().setCategoria(categoriaList);
                }else {
                    response.setMetadata("Respuesta error","2","No se logro actualizar");
                    return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.BAD_REQUEST);
                }
            }else {
                response.setMetadata("Respuesta error","2","Categoria no encontrada");
                return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = false)
    public ResponseEntity<CategoriaResponseRest> eliminarCategoria(Long id) {
        CategoriaResponseRest response = new CategoriaResponseRest();

        try{
            categoriaDao.deleteById(id);

            response.setMetadata("Respuesta ok","1","Categoria eliminada");

        }catch (Exception e) {
            log.error(e.getMessage());
            response.setMetadata("Respuesta error","2","No se logró eliminar cateoria");
            return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
    }

}
