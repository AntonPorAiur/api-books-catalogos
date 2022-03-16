package mx.cursos.spapicatalogos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpApiCatalogosApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpApiCatalogosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String pass = "springboot";
		for(int i = 0; i <2; i++) {
			String pbcrypt = passwordEncoder.encode(pass);
			System.out.println("Contraseña: " + pbcrypt);
		}
	}
}
