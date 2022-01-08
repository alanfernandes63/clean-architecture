package br.com.escola.infra;

import br.com.escola.aplicacao.EnviarEmailIndicacao;
import br.com.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoJavaMail implements EnviarEmailIndicacao {
    @Override
    public void enviarPara(Aluno aluno) {
        //lógica de envio de email
    }
}
