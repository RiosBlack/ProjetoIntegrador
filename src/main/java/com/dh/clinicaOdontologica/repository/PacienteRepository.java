package com.dh.clinicaOdontologica.repository;
import com.dh.clinicaOdontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
//    Optional<Paciente> buscarPorCpf(String cpf);

    Optional<Paciente> findByCpf(String cpf);

    List<Paciente> findByEnderecoId(Long id); //testando LAIANE
//Este método informa que deve-se buscar o atributo endereco em paciente (que é do tipo CestaDeCompra) e usar o atributo id do endereco dentro de Paciente para recuperar os registros desejados.
// Ele vai recuperar todos os produtos que estiverem associados ao id do endereco passado como parâmetro.
}

