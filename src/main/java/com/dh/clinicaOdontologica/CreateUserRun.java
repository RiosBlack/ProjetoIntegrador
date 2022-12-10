package com.dh.clinicaOdontologica;


import com.dh.clinicaOdontologica.entity.Usuario;
import com.dh.clinicaOdontologica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class CreateUserRun implements ApplicationRunner {

    @Autowired
    UsuarioRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder brCrypt = new BCryptPasswordEncoder();

        Usuario usuario = new Usuario();
        usuario.setPassword(brCrypt.encode("654321"));
        usuario.setUsername("Nathany");

        repository.save(usuario);

    }
}
