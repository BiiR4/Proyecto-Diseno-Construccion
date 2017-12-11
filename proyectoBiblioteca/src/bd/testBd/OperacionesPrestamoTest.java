package bd.testBd;

import java.io.IOException;
import org.junit.BeforeClass;
import bd.OperacionesPrestamo;

public class OperacionesPrestamoTest {
  OperacionesPrestamo operaciones = null;

  @BeforeClass
  public static void setUp() {
    // recrear BD de prueba
    Process p;
    try {
      p = Runtime.getRuntime().exec("sh restaurarBD");
      p.waitFor();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
