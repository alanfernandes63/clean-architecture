package br.com.escola.dominio.aluno;

public class Email {
    private String endereco;

    public Email(String endereco) {
        if (endereco == null || this.validar(endereco)) {
            throw new IllegalArgumentException("E-mail inválido!");
        }
        this.endereco = endereco;
    }

    private boolean validar(String endereco) {
        return !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
