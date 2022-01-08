package br.com.escola.dominio.aluno;

public class FabricaAluno {
    private Aluno aluno;

    public FabricaAluno comNomeCPFEmail(String nome, String cpf, String email) {
        this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public FabricaAluno comTelefone(Telefone telefone) {
        this.aluno.adicionaTelefone(telefone);
        return this;
    }

    public Aluno criar() {
        return this.aluno;
    }
}
