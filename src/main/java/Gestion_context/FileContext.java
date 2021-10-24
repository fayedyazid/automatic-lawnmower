package Gestion_context;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileContext {

    public static final String path_file = "/file_data.txt";

    private FileContext(){ }//constructeur
    public static String getFile(String path_file) throws IOException {

        InputStream inputStream = FileContext.class.getResourceAsStream(path_file);
        return readFromInputStream(inputStream);
    }

    private static String readFromInputStream(InputStream inputStream)
            throws IOException {
            StringBuilder resultStringBuilder = new StringBuilder();
            try (BufferedReader br  = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

public static void  Filefile(){
    try (Stream<String> lines =
                 (Files.newBufferedReader(Paths.get("/file_data.txt"))
                         .lines())) {
        lines.forEach(System.out::println);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}