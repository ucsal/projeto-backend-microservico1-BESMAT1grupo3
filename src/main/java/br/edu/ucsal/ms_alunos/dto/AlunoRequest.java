package br.edu.ucsal.ms_alunos.dto;

import br.edu.ucsal.ms_alunos.entity.enums.AreaInteresse;
import br.edu.ucsal.ms_alunos.entity.enums.Turno;

import java.time.LocalDate;
import java.util.List;

public class AlunoRequest {

    private String matricula;
    private String nome;
    private String email;
    private String telefone;
    private String curso;
    private Turno turno;
    private String github;
    private String linkedin;
    private Integer horasSemanais;
    private LocalDate dataSelecao;
    private List<AreaInteresse> areas;
    private List<String> disciplinasAprovadas;

    // getters e setters
}