package mx.cursos.spapicatalogos.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String nombreUsuario;

    @Column(length = 65) // Va largo para que quepa la encriptación
    private String contrasena;

    private Boolean habilitado;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "USUARIOS_ROLES",
            joinColumns = @JoinColumn(name = "USUARIO_ID"), // Nombre LLave foranea de la entidad usuarios en la tabla intermedia
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"), // Nombre Llave foránea de la entidad roles en la tabla intermedia
            uniqueConstraints = { @UniqueConstraint(columnNames = {"USUARIO_ID","ROLE_ID"} ) }
            //Se agrega uniqueconstraints para evitar duplicidad de roles en cada usuario
    )
    private List<Rol> roles;

    private static final long serialVersionUID = 1L;

}
