package mx.cursos.spapicatalogos.controller;

import mx.cursos.spapicatalogos.controllers.CategoriaController;
import mx.cursos.spapicatalogos.dao.CategoriaDao;
import mx.cursos.spapicatalogos.models.Categoria;
import mx.cursos.spapicatalogos.response.CategoriaResponseRest;
import mx.cursos.spapicatalogos.services.ICategoriaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CategoriaControllerTest {

    @InjectMocks // Injecta la clase con todas sus dependencias
    CategoriaController undertest;

    @Mock
    private ICategoriaService categoriaService;

    @BeforeEach // Por cada prueba unitaria se carga este método
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void crearTest() {
        // having
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Categoria categoria = new Categoria(Long.valueOf(4),"Clásicos","Literatura universal clásicos");
        // Defines que debe devolver el mocks la sentencia dentro del when
        when(undertest.guardarCategoria(any(Categoria.class)))
                .thenReturn(new ResponseEntity<CategoriaResponseRest>(HttpStatus.OK));

        ResponseEntity<CategoriaResponseRest> respuesta = undertest.guardarCategoria(categoria);

        // Then
        assertThat(respuesta.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
