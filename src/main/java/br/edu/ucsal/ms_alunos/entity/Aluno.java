package br.edu.ucsal.ms_alunos.entity;

import br.edu.ucsal.ms_alunos.entity.enums.AreaInteresse;
import br.edu.ucsal.ms_alunos.entity.enums.Status;
import br.edu.ucsal.ms_alunos.entity.enums.Turno;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;
    private String nome;
    private String email;
    private String telefone;
    private String curso;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    private String github;
    private String linkedin;

    private Integer horasSemanais;

    private LocalDate dataCadastro;

    private LocalDate dataSelecao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AreaInteresse> areas = new ArrayList<>();

    @ElementCollection
    private List<String> disciplinasAprovadas = new ArrayList<>();
}