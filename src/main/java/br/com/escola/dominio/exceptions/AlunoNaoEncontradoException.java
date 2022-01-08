package br.com.escola.dominio.exceptions;

import br.com.escola.dominio.aluno.CPF;

public class AlunoNaoEncontradoException extends RuntimeException{

    public AlunoNaoEncontradoException(CPF cpf) {
        super("Aluno não encontrado com CPF: "+ cpf.getNumero());
    }
}
