package br.edu.ucsal.ms_alunos.service;

import br.edu.ucsal.ms_alunos.dto.AlunoRequest;
import br.edu.ucsal.ms_alunos.entity.Aluno;
import br.edu.ucsal.ms_alunos.entity.enums.Status;
import br.edu.ucsal.ms_alunos.exception.ResourceNotFoundException;
import br.edu.ucsal.ms_alunos.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public Aluno criar(AlunoRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Já existe aluno com esse email");
        }

        Aluno aluno = new Aluno();

        aluno.setNome(request.getNome());
        aluno.setEmail(request.getEmail());
        aluno.setTelefone(request.getTelefone());
        aluno.setMatricula(request.getMatricula());
        aluno.setCurso(request.getCurso());
        aluno.setTurno(request.getTurno());
        aluno.setGithub(request.getGithub());
        aluno.setLinkedin(request.getLinkedin());
        aluno.setHorasSemanais(request.getHorasSemanais());
        aluno.setAreas(request.getAreas());
        aluno.setDataSelecao(request.getDataSelecao());
        aluno.setDisciplinasAprovadas(request.getDisciplinasAprovadas());

        aluno.setDataCadastro(LocalDate.now());
        aluno.setStatus(Status.ATIVO);

        return repository.save(aluno);
    }

    public List<Aluno> listar() {
        return repository.findAllByOrderByStatusAsc();
    }

    public Aluno buscar(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Aluno não encontrado"));
    }

    public Aluno ativar(Long id) {

        Aluno aluno = buscar(id);

        aluno.setStatus(Status.ATIVO);

        return repository.save(aluno);
    }

    public Aluno inativar(Long id) {

        Aluno aluno = buscar(id);

        aluno.setStatus(Status.INATIVO);

        return repository.save(aluno);
    }
}