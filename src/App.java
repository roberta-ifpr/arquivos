import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World csv!");
        Aluno aluno = new Aluno();
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("Informe o Id do aluno");
        aluno.setId(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Informe o nome do aluno");
        aluno.setNome(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Informe o email do aluno");
        aluno.setEmail(scanner.nextLine());
        scanner.nextLine();

        GeradorCSV.criarCSV(aluno);

    }
}
