package br.com.escola;

import br.com.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.dominio.aluno.AlunoRepositorio;
import br.com.escola.dominio.aluno.FabricaAluno;
import br.com.escola.dominio.aluno.Telefone;
import br.com.escola.infra.H2Connection;
import br.com.escola.infra.aluno.RepositorioAlunoJDBC;
import br.com.escola.infra.aluno.RepositorioAlunosEmMemoria;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //AlunoRepositorio repositorio = new RepositorioAlunoJDBC(H2Connection.getConnection());
        AlunoRepositorio repositorio = new RepositorioAlunosEmMemoria();
        //apagarTabelas();
        //criarTabelas();
        //inserirAlunos(repositorio);

//        List<Aluno> alunos = repositorio.listarTodosAlunosMatriculados();
//        Aluno aluno = repositorio.buscarPorCPF(new CPF("12345678912"));
//        CifradorSenha cs = new CifradorSenhaMD5();
//        String senhaCifrada = cs.cifrar("12346");
//        boolean igual = cs.validarSenha(senhaCifrada, "12345");
        MatricularAluno matricularAluno = new MatricularAluno(repositorio);
        matricularAluno.executa(new MatricularAlunoDto("alan", "12345678912", "alan@mail.com"));
    }

    public static void criarTabelas() {
        H2Connection.createTableAluno(H2Connection.getConnection());
        H2Connection.createTableTelefone(H2Connection.getConnection());
    }

    public static void apagarTabelas() {
        try {
            H2Connection.getConnection()
                    .prepareStatement("DROP TABLE TELEFONES;").execute();
            H2Connection.getConnection()
                    .prepareStatement("DROP TABLE ALUNOS;").execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void inserirAlunos(AlunoRepositorio repositorio) {
        Aluno alan = new FabricaAluno().comNomeCPFEmail("alan", "12345678912","alan@mail.com")
                .comTelefone(new Telefone("84", "123456789"))
                .comTelefone(new Telefone("81", "123456789"))
                .criar();
        repositorio.matricular(alan);

        Aluno maria = new FabricaAluno().comNomeCPFEmail("maria", "23456789123","maria@mail.com")
                .comTelefone(new Telefone("84", "57891234"))
                .criar();
        repositorio.matricular(maria);
    }
}
