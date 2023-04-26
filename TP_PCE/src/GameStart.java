import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameStart {


    public static void function1() throws FileNotFoundException {

        File Ficheiro = new File("src/GameStart.csv");
        Scanner in = new Scanner(Ficheiro);


        while (in.hasNextLine()){
            String linha = in.nextLine();
            System.out.println(linha);
        }
        in.close();
    }

    public static void function2() throws FileNotFoundException {

        File Ficheiro = new File("src/GameStart.csv");
        Scanner in = new Scanner(Ficheiro);

        int countVendas = 0;
        double totalVendas = 0;
        double totalCadaVenda = 0;

        in.nextLine();


        while (in.hasNextLine()){
            String linha = in.nextLine();
            countVendas++;

            String[] itensDaLinha = linha.split(";");
            totalCadaVenda = Double.parseDouble(itensDaLinha[8]);
            totalVendas += totalCadaVenda;

        }
        System.out.println("O número total de vendas é: "+countVendas);
        System.out.println("O valor total de vendas é: " +totalVendas+ " €");
        in.close();
    }


    public static void function3() throws FileNotFoundException {

        File Ficheiro = new File("src/GameStart.csv");
        Scanner in = new Scanner(Ficheiro);

        double totalVendas = 0;
        double totalCadaVenda = 0;

        in.nextLine();


        while (in.hasNextLine()) {
            String linha = in.nextLine();
            String[] itensDaLinha = linha.split(";");
            totalCadaVenda = Double.parseDouble(itensDaLinha[8]);
            totalVendas += totalCadaVenda;

        }
        double lucro = 0.10 * totalVendas;
        System.out.println("O total de lucro é: " +lucro+ " €");
        in.close();
    }


    public static void function4() throws FileNotFoundException {

        File Ficheiro = new File("src/GameStart.csv");
        Scanner in = new Scanner(Ficheiro);

        Scanner input = new Scanner(System.in);

        System.out.println("Insira o idCliente que deseja consultar");
        int idCliente = input.nextInt();

        String name = "";
        int contacto = 0;
        String email = "";

        in.nextLine();
        
        while (in.hasNextLine()) {
            String linha = in.nextLine();
            String[] itensDaLinha = linha.split(";");


            if(Integer.parseInt(itensDaLinha[1]) == idCliente){

                name = itensDaLinha[2];
                contacto = Integer.parseInt(itensDaLinha[3]);
                email = itensDaLinha[4];

            }

        }
        System.out.println(name);
        System.out.println(contacto);
        System.out.println(email);

        in.close();


    }

    public static void function5() throws FileNotFoundException {

        File Ficheiro = new File("src/GameStart.csv");
        Scanner in = new Scanner(Ficheiro);

        Scanner input = new Scanner(System.in);

        System.out.println("Insira a editora que deseja consultar");
        String editora = input.next();

        String genero = "";
        String jogo = "";
        String[] jogoArray = new String[100];
        int jogos = 0;
        int i = 0;

        in.nextLine();

        boolean jogoFound = false;

        while (in.hasNextLine()) {
            String linha = in.nextLine();
            String[] itensDaLinha = linha.split(";");


            if (itensDaLinha[5].equals(editora)) {

                genero = itensDaLinha[6];
                jogo = itensDaLinha[7];


                for (i = 0; i < jogos; i++) {

                    if (jogoArray[i].equals(jogo)) {
                        jogoFound = true;
                    }
                }

                if (!jogoFound) {
                    System.out.println(genero);
                    System.out.println(jogo);
                    jogoArray[jogos] = jogo;
                    jogos++;
                }

                    //jogoArray[i] = jogo;

                    //if (!jogoArray[i].equals(jogoAntes)) {

                        //System.out.println(genero);
                        //System.out.println(jogoArray[i]);
                        //jogoAntes = jogoArray[i];

                    //}
                }


            }

        in.close();
        }





    public static void menu() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int opcao;
        String op = null;

        do {
            do {
                System.out.println("Seleccione uma das opções");
                System.out.println("Prima 1 para imprimir conteúdo do ficheiro na consola");
                System.out.println("Prima 2 para imprimir quantas vendas foram executadas e o seu valor total");
                System.out.println("Prima 3 para saber o total de lucro da GameStart");
                System.out.println("Prima 4 para imprimir todas as informações de um dado cliente da GameStart");
                System.out.println("Prima 5 para imprimir todos os géneros e respetivos jogos de uma dada Editora");
                System.out.println("Prima 6 para imprimir o jogo mais caro e os clientes que o compraram");

                opcao = input.nextInt();

            } while (opcao < 1 || opcao > 6);

            switch (opcao) {

                case 1:
                    function1();
                break;
                case 2:
                    function2();
                break;
                case 3:
                    function3();
                break;
                case 4:
                    function4();
                break;
                case 5:
                    function5();
                break;
                case 6:
                break;
            }
            System.out.println("Deseja efetuar mais alguma operação?");
            op = input.next();
            op = op.toUpperCase();

        } while(op.equals("S"));
    }


    public static void main(String[] args) {

        try {
            menu();
        } catch (FileNotFoundException exc) {
            System.out.println("File not found");
        }

    }
}