package br.com.escola.infra.aluno;

import br.com.escola.dominio.exceptions.AlunoNaoEncontradoException;
import br.com.escola.dominio.aluno.*;
import br.com.escola.infra.H2Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioAlunoJDBC implements AlunoRepositorio {
    private final Connection connection;

    public RepositorioAlunoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        String sql = "INSERT INTO ALUNOS VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getEmail());
            ps.setString(3, aluno.getNome());
            ps.execute();

            sql = "INSERT INTO TELEFONES (FK_ALUNO, DDD, NUMERO) VALUES (?, ?, ?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone :
                    aluno.getTelefones()) {
                ps.setString(1, aluno.getCpf());
                ps.setString(2, telefone.getDDD());
                ps.setString(3, telefone.getNumero());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {

        String sql = "SELECT * FROM ALUNOS WHERE CPF=?";
        try {
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumero());
            ResultSet rs = ps.executeQuery();
            boolean encontrou = !rs.next();
            if(encontrou) {
                throw new AlunoNaoEncontradoException(cpf);
            }
            String nome = rs.getString("nome");
            String cpfConsulta = rs.getString("cpf");
            String email = rs.getString("email");

            Aluno aluno = new FabricaAluno()
                    .comNomeCPFEmail(nome, cpfConsulta, email)
                    .criar();
            return aluno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        List<Aluno> alunos = new ArrayList<>();
        try {
            ResultSet rs = H2Connection.getConnection()
                    .prepareStatement("SELECT * FROM ALUNOS;")
                    .executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");

                Aluno aluno = new FabricaAluno()
                        .comNomeCPFEmail(nome, cpf, email)
                        .criar();

                alunos.add(aluno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alunos;
    }
}
