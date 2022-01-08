package br.com.escola.dominio.indicacao;

import br.com.escola.dominio.aluno.Aluno;

import java.time.LocalDateTime;

public class Indicacao {

    private Aluno indicador;
    private Aluno indicando;
    private LocalDateTime data;

    public Indicacao(Aluno indicador, Aluno indicando) {
        this.indicador = indicador;
        this.indicando = indicando;
        this.data = LocalDateTime.now();
    }
}
