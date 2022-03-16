package mx.cursos.spapicatalogos.repository;

import mx.cursos.spapicatalogos.dao.CategoriaDao;
import mx.cursos.spapicatalogos.models.Categoria;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@DataJpaTest
class CategoriaRepositoryTest {

	@Autowired
	CategoriaDao underTest;

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetAllCategories() {
		// having

		// when
		List<Categoria> catList = (List<Categoria>) underTest.findAll();

		// then

	}

}

// TDD -> Definición
// 1.- Escribe una prueba que falle
// 2.- Haz que el código pase la prueba
// 3.- Elimina la redundancia

// Permite escribir código sabiendo lo esperado de la prueba unitaria
// Ahorra tiempo y esfuerzo en resolver errores
// Agiliza el proceso de creación de código

// Herramientas
// No se usan herrmaientas para la metodología
// Herramientas de pruebas automatizadas junit, jest

// Mockito + junit

// assertNotEquals
// assertEquals