package br.com.escola.infra.aluno;

import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.dominio.aluno.AlunoRepositorio;
import br.com.escola.dominio.aluno.CPF;
import br.com.escola.dominio.exceptions.AlunoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAlunosEmMemoria implements AlunoRepositorio {
    private List<Aluno> alunos = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        return alunos.stream()
                .filter(aluno -> aluno.getCpf().equals(cpf.getNumero()))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontradoException(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return alunos;
    }
}
