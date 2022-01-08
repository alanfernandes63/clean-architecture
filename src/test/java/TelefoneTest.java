import br.com.escola.dominio.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TelefoneTest {
    @Test
    public void naoDeveCriarTelefoneDDDInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("123", "123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("abc", "123456789"));
    }

    @Test
    public void naoDeveCriarTelefoneNumeroInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone("12", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("12", "12345678a"));
    }

    @Test
    public void deveCriarTelefoneDDDNumeroValidos() {
        assertNotNull(new Telefone("12", "123456789"));
    }
}
