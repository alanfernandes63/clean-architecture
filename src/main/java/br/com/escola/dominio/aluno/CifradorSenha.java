package br.com.escola.dominio.aluno;

public interface CifradorSenha {

    String cifrar(String senha);

    Boolean validarSenha(String senhaCifrada, String senhaAberta);
}
