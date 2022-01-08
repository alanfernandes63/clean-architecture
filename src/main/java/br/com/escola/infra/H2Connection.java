package br.com.escola.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2Connection {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/target/h2";

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void createTableAluno(Connection cn) {
        String sql = "CREATE TABLE IF NOT EXISTS ALUNOS (" +
                "CPF VARCHAR(11) NOT NULL PRIMARY KEY," +
                "EMAIL VARCHAR(100) NOT NULL," +
                "NOME VARCHAR(200));";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTableTelefone(Connection cn) {
        String sql = "CREATE TABLE IF NOT EXISTS TELEFONES (" +
                "ID INT NOT NULL NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                "FK_ALUNO VARCHAR(11)," +
                "DDD VARCHAR(2) NOT NULL," +
                "NUMERO VARCHAR(9)," +
                "FOREIGN KEY (FK_ALUNO) REFERENCES ALUNOS(CPF));";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
