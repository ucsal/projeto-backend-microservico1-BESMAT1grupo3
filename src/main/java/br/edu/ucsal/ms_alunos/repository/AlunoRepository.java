package br.edu.ucsal.ms_alunos.repository;

import br.edu.ucsal.ms_alunos.entity.Aluno;
import br.edu.ucsal.ms_alunos.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    boolean existsByEmail(String email);

    List<Aluno> findByStatus(Status status);

    List<Aluno> findAllByOrderByStatusAsc();

}