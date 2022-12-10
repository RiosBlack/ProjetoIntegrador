package com.dh.clinicaOdontologica.security;

import com.dh.clinicaOdontologica.entity.Usuario;
import com.dh.clinicaOdontologica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService{

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByUsername(username);
        if(usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return usuario.get();
    }
}