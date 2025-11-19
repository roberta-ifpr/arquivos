//import java.util.List;
//import java.util.Scanner;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World csv!");
        int opcao = -1;
        Aluno aluno = new Aluno();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1 - Incluir");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção (1-4): ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Informe o Id do aluno");
                    scanner.nextLine();
                    aluno.setId(scanner.nextLine());
                    scanner.nextLine();
                    System.out.println("Informe o nome do aluno");
                    aluno.setNome(scanner.nextLine());
                    scanner.nextLine();
                    System.out.println("Informe o email do aluno");
                    aluno.setEmail(scanner.nextLine());
                    scanner.nextLine();

                    GeradorCSV.inserirCSV(aluno);
                    break;
                case 2:
                    List<Aluno> alunos = GeradorCSV.listarCSV();
                    System.out.println("======== Listagem de Alunos Cadastrados ==========");
                    for (Aluno aluno2 : alunos) {
                        System.out.println();
                        System.out.println("Id: " + aluno2.getId());
                        System.out.println("Nome: " + aluno2.getNome());
                        System.out.println("email: " + aluno2.getEmail());
                        System.out.println();
                        System.out.println("--------------------------------------------------");
                    }

                case 3:

                    break;

                case 4:
                    System.out.println("informe o id do aluno a deletar");
                    scanner.nextLine();
                    String id = scanner.nextLine();
                    GeradorCSV.delete(id);

                default:
                    break;
            }

        } while (opcao != 0);

        // GeradorCSV.delete("3");
        

    }
}
