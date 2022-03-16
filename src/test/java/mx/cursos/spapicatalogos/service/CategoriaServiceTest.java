package mx.cursos.spapicatalogos.service;

import mx.cursos.spapicatalogos.dao.CategoriaDao;
import mx.cursos.spapicatalogos.models.Categoria;
import mx.cursos.spapicatalogos.response.CategoriaResponseRest;
import mx.cursos.spapicatalogos.services.CategoriaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CategoriaServiceTest {

    @InjectMocks
    CategoriaServiceImpl service;

    @Mock // Indica que generamos una copia, no va a la implementación real
    CategoriaDao categoriaDao;

    List<Categoria> list = new ArrayList<>();

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.cargarCategorias();
    }

    @Test
    @DisplayName("Metodo obtener categorias service")
    public void buscarCategorias() {
        when(categoriaDao.findAll()).thenReturn(list);
        // De esta forma devolvemos informacion fija, predefinida

        ResponseEntity<CategoriaResponseRest> response = service.buscarCategorias();

        assertEquals(3,response.getBody().getCategoriaResponse().getCategoria().size());

        verify(categoriaDao, times(1)).findAll(); // Test para verificar que se invoco una vez el método
        // findAll()
    }

    public void cargarCategorias() {
        Categoria catUno = new Categoria(Long.valueOf(1), "Abarrotes", "Distintos abarrotes");
        Categoria catDos = new Categoria(Long.valueOf(2), "Bebidas", "Distintos bebidas");
        Categoria catTres = new Categoria(Long.valueOf(3), "Carnes", "Distintos cortes de carne");

        list.add(catUno);
        list.add(catDos);
        list.add(catTres);
    }

    @Test
    @Disabled
    public void buscarCategoriaPorId(){

    }
}
