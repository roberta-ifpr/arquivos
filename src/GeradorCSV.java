import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class GeradorCSV {

    public static void criarCSV(Aluno aluno){
        Path caminho = Paths.get("alunos.csv");
        try (
            BufferedWriter writer = Files.newBufferedWriter(
                                    caminho,
                                    StandardCharsets.UTF_8,
                                    StandardOpenOption.CREATE,
                                    StandardOpenOption.TRUNCATE_EXISTING)){
            writer.write(aluno.getId()+";"+aluno.getNome()+";"+aluno.getEmail()); 
            //writer.newLine();                         
            
        } catch (IOException e) {
            System.err.println("Deu ruim "+e.getMessage());
        }

    }
}
