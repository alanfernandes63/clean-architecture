import br.com.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.dominio.aluno.AlunoRepositorio;
import br.com.escola.dominio.aluno.CPF;
import br.com.escola.infra.aluno.RepositorioAlunosEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatricularAlunoTest {

    @Test
    public void alunoDeveriaSerPersistido(){
        AlunoRepositorio repositorio = new RepositorioAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio);
        MatricularAlunoDto alunoDto =
                new MatricularAlunoDto(
                        "Fulano", "12345678900", "fulano@mail.com");
        useCase.executa(alunoDto);
        Aluno encontrado = repositorio.buscarPorCPF(new CPF("12345678900"));
        assertEquals("Fulano", encontrado.getNome());
    }
}
