package mx.cursos.spapicatalogos.controllers;


import mx.cursos.spapicatalogos.models.Categoria;
import mx.cursos.spapicatalogos.response.CategoriaResponseRest;
import mx.cursos.spapicatalogos.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/v1")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/categorias")
    public ResponseEntity<CategoriaResponseRest> buscarCategorias() {

        ResponseEntity<CategoriaResponseRest> response = categoriaService.buscarCategorias();

        return response;
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<CategoriaResponseRest> buscaCategoriaPorId(@PathVariable Long id) {
        ResponseEntity<CategoriaResponseRest> response = categoriaService.buscarPorId(id);
        return response;
    }

    @PostMapping("/categorias")
    public ResponseEntity<CategoriaResponseRest> guardarCategoria(@RequestBody Categoria request) {
        ResponseEntity<CategoriaResponseRest> response = categoriaService.guardarCategoria(request);
        return response;
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<CategoriaResponseRest> actualizarCategoria(@RequestBody Categoria request, @PathVariable Long id) {
        ResponseEntity<CategoriaResponseRest> response = categoriaService.actualizar(request, id);
        return response;
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<CategoriaResponseRest> eliminarCategoria(@PathVariable Long id) {
        ResponseEntity<CategoriaResponseRest> response = categoriaService.eliminarCategoria(id);
        return response;
    }
}
