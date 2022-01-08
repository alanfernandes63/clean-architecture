package br.com.escola.infra.aluno;

import br.com.escola.dominio.aluno.CifradorSenha;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CifradorSenhaMD5 implements CifradorSenha {
    @Override
    public String cifrar(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < bytes.length;i++) {
                sb.append(Integer.toHexString((bytes[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao cifrar senha");
        }
    }

    @Override
    public Boolean validarSenha(String senhaCifrada, String senhaAberta) {
        return senhaCifrada.equals(cifrar(senhaAberta));
    }
}
