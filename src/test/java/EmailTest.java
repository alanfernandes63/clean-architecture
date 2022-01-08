import br.com.escola.dominio.aluno.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailTest {

    @Test
    public void naoDeveCriarEmailComEnderecosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("invalido"));
    }

    @Test
    public void deveCriarEmail() {
        assertNotNull(new Email("test@mail.com"));
    }
}
