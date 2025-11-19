import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GeradorCSV {

    public static void inserirCSV(Aluno aluno) {
        Path caminho = Paths.get("data/alunos.csv");

        try {
            Files.createDirectories(caminho.getParent());
/*            BufferedWriter writer = Files.newBufferedWriter(
                            caminho,
                            StandardCharsets.UTF_8,
                            StandardOpenOption.CREATE,
                            StandardOpenOption.TRUNCATE_EXISTING) */
            
            try (
                    FileWriter fw = new FileWriter(caminho.toString(), true);   
                    BufferedWriter writer = new BufferedWriter(fw)) {  
                writer.write(aluno.getId() + ";" + aluno.getNome() + ";" + aluno.getEmail());
                writer.newLine();

            } catch (IOException e) {
                System.err.println("Deu ruim " + e.getMessage());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static List<Aluno> listarCSV(){
        Path caminho = Paths.get("data/alunos.csv");
        List<Aluno> alunos = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(caminho)) 
        {
            String linha;
            while ((linha = reader.readLine())!=null) {
                Aluno aluno = new Aluno();
                String dados[] = linha.split(";");
                aluno.setId(dados[0]);
                aluno.setNome(dados[1]);
                aluno.setEmail(dados[2]);
                alunos.add(aluno);
            }
            
        } catch (IOException e) {
            System.out.println("erro "+e.getMessage());
        }
        return alunos;   

    }

    public static void delete(String id){
          Path caminho = Paths.get("data/alunos.csv");
        
          try {
            List<String> linhas = Files.readAllLines(caminho);
            List<String> novasLinhas = new ArrayList<>();

            for (String linha : linhas) {
                String[] dados = linha.split(";");
                if(!dados[0].equals(id)){
                    novasLinhas.add(linha);
                }
            }
            Files.write(caminho, novasLinhas);
            System.out.println("Aluno deletado com sucesso");


          } catch (IOException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
          }
    }

}
