package pc1;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Test
public class RegistrAppTest {

    @Test(invocationCount = 100, threadPoolSize = 100)
    public void constructorTest() {
        RegistrApp test = new RegistrApp("Jesus Bellido");
        boolean result = false;
        if(test.getNombreProfesor() == "Jesus Bellido") {
            result = true;
        }
        Assert.assertEquals(String.valueOf(result), "true");
    }

    public void descriptionTest() throws Exception {
        RegistrApp test = new RegistrApp("Jesus Bellido");
        boolean result = test.getDescription("2020-II, CS2901, ES, Ingeniería de Software I, 1, Semana05, Jesus Bellido, 10/08, 08:00-10:00, Laboratorio");

        Assert.assertEquals(String.valueOf(result), "true");
    }

    public void linkTest() throws Exception {
        RegistrApp test = new RegistrApp("Jesus Bellido");
        boolean result = test.getLink("https://utec.zoom.us/rec/share/lakdsjlaj");
        Assert.assertEquals(String.valueOf(result), "true");
    }
}
