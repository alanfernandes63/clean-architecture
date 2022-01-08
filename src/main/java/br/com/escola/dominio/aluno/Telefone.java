package br.com.escola.dominio.aluno;

public class Telefone {
    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        validarDDD(ddd);
        validarNumero(numero);
        this.ddd = ddd;
        this.numero = numero;
    }

    private void validarDDD(String ddd) {
        if (ddd == null || !ddd.matches("\\d{2}")) {
            throw new IllegalArgumentException("DDD inválido");
        }
    }

    private void validarNumero(String numero) {
        if (numero == null || !numero.matches("\\d{8}|\\d{9}")) {
            throw new IllegalArgumentException("Número de telefone inválido");
        }
    }

    public String getDDD() {
        return ddd;
    }

    public void setDDD(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
