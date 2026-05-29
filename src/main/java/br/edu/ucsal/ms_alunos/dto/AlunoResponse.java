package br.edu.ucsal.ms_alunos.dto;

import br.edu.ucsal.ms_alunos.entity.Aluno;
import lombok.Getter;

@Getter
public class AlunoResponse {

    private final Long id;
    private final String nome;
    private final String email;

    public AlunoResponse(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
    }
}