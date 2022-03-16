package mx.cursos.spapicatalogos.services;

import mx.cursos.spapicatalogos.dao.IUsuarioDao;
import mx.cursos.spapicatalogos.models.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario user = usuarioDao.findByNombreUsuario(nombreUsuario);

        if(user == null) {
            logger.error("Error en el login: no existe el usuario '" + nombreUsuario + "'");
            throw new UsernameNotFoundException("Error en el login: no existe el usuario '" + nombreUsuario );
        }
        // Se maneja con flujos pero no es reactivo
        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .collect(Collectors.toList());

        return new User(user.getNombreUsuario(), user.getContrasena(), user.getHabilitado(),
                true, true, true, authorities);
    }
}
