package mx.cursos.spapicatalogos.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

// Toda clase Bean debe implementar Serializable, cumplir estandar de nombres, nomenclatura, Setters y Getters
@Data
@Entity
@Table
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY es autogenerado
    private Long id;

    private String nombre;

    private String descripcion;

    public Categoria() {
        super();
    }

    public Categoria(Long valueOf, String abarrotes, String distintos_abarrotes) {
    }
}
