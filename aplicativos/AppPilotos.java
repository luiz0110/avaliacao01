package aplicativos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import classes.Pessoa;
import classes.Pilotos;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int MAX_ELEMENTOS = 2;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        // Defino a estrutura de dados que vai armazenar os pilotos!
        List<Pessoa> piloto = new ArrayList<>();
        

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }
                //Cadastre seu piloto aqui
                Pessoa pessoa = new Pessoa();
                System.out.printf("Nome do Piloto: ");
                pessoa.setNome(in.nextLine());

                System.out.printf("CPF: ");
                pessoa.setCpf(in.nextLine());
                       
                piloto.add(pessoa);
                qtdCadastrados++;                

                System.out.println("\nPiloto cadastrado com sucesso.");
                
               // voltarMenu(in);
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                System.out.println("\nNão há Pilotos cadastrados para exibir.");
                    voltarMenu(in);
                continue;
                }else 

                // Exiba os pilotos aqui
                System.out.println(piloto);
                               
               voltarMenu(in);
            } else if (opcao == 3) {
                System.out.print("Digite o CPF do piloto a ser buscado: ");
                Pilotos cpfBusca = new Pilotos("", sc.nextLine());          
                
                int posicaoPiloto = piloto.indexOf(cpfBusca);

                if (posicaoPiloto > -1) {
                    Pilotos cpfEncontrado = (Pilotos) piloto.get(posicaoPiloto);
                    System.out.printf("Piloto de CPF %s: %s\n", cpfEncontrado.getCpf(), cpfEncontrado.getNome());
      } else
       System.out.println("Piloto não encontrado!");


            } else if (opcao == 4) {
                MAX_ELEMENTOS++;
                System.out.println("Armazenamento Ampliado!");
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}