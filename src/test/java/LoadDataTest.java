import Gestion_context.FileContext;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class LoadDataTest {

    @Test
    public void whenReadSmallFileJava7_thenCorrect()
            throws IOException {
        String expected_value = "5 5";

       // Path path = Paths.get("/file_data.txt");

        String[] fileData = FileContext.getFile("/file_data.txt").split("\n");
        assertEquals("GAGAGAGAA", fileData[2]);
    }
}
