package br.com.escola.aplicacao.aluno.matricular;

import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.dominio.aluno.AlunoRepositorio;

public class MatricularAluno {

    private final AlunoRepositorio alunoRepositorio;

    public MatricularAluno(AlunoRepositorio alunoRepositorio) {
        this.alunoRepositorio = alunoRepositorio;
    }

    public void executa(MatricularAlunoDto aluno) {
        Aluno novo = aluno.criarAluno();
        alunoRepositorio.matricular(novo);
    }
}
