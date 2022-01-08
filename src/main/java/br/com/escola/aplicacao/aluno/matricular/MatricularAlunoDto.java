package br.com.escola.aplicacao.aluno.matricular;

import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.dominio.aluno.FabricaAluno;

public class MatricularAlunoDto {

    private String nome;
    private String cpf;
    private String email;

    public MatricularAlunoDto(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Aluno criarAluno() {
        return new FabricaAluno()
                .comNomeCPFEmail(nome, cpf, email)
                .criar();
    }
}
