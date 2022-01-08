package br.com.escola.dominio.aluno;

public class CPF {
    private String numero;

    public CPF(String numero) {
        validar(numero);
        this.numero = numero;
    }

    private void validar(String numero) {
        if(numero == null || !numero.matches("\\d{11}")) {
            throw new IllegalArgumentException("Número de cpf inválido");
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
