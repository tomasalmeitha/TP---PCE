import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameStart {


    public static void function1() throws FileNotFoundException {

        File Ficheiro = new File("src/GameStart_V2.txt");
        Scanner in = new Scanner(Ficheiro);


        while (in.hasNextLine()) {
            String linha = in.nextLine();
            System.out.println(linha);
        }
        in.close();
    }

    public static void function2() throws FileNotFoundException {

        File Ficheiro = new File("src/GameStart_V2.txt");
        Scanner in = new Scanner(Ficheiro);

        int countVendas = 0;
        double totalVendas = 0;
        double totalCadaVenda = 0;

        in.nextLine();


        while (in.hasNextLine()) {
            String linha = in.nextLine();
            countVendas++;

            String[] itensDaLinha = linha.split(",");
            totalCadaVenda = Double.parseDouble(itensDaLinha[8]);
            totalVendas += totalCadaVenda;

        }
        System.out.println("O número total de vendas é: " + countVendas);
        System.out.println("O valor total de vendas é: " + totalVendas + " €");
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
            String[] itensDaLinha = linha.split(",");
            totalCadaVenda = Double.parseDouble(itensDaLinha[8]);
            totalVendas += totalCadaVenda;

        }
        double lucro = 0.10 * totalVendas;
        System.out.println("O total de lucro é: " + lucro + " €");
        in.close();
    }


    public static void function4() throws FileNotFoundException {

        File Ficheiro = new File("src/GameStart_V2.txt");
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
            String[] itensDaLinha = linha.split(",");


            if (Integer.parseInt(itensDaLinha[1]) == idCliente) {

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

        File Ficheiro = new File("src/GameStart_V2.txt");
        Scanner in = new Scanner(Ficheiro);

        Scanner input = new Scanner(System.in);

        System.out.println("Insira a editora que deseja consultar");
        String editora = input.nextLine();

        String genero = "";
        String jogo = "";
        String cat = "";
        String[] jogoArray = new String[100];
        String[] catArray = new String[100];
        int jogos = 0;
        int cats = 0;

        in.nextLine();

        boolean jogoFound = false;
        boolean catFound = false;

        while (in.hasNextLine()) {
            String linha = in.nextLine();
            String[] itensDaLinha = linha.split(",");


            if (itensDaLinha[5].equals(editora)) {

                genero = itensDaLinha[6];
                jogo = itensDaLinha[7];

                //for (int k = 0; k < cats; k++) {

                catFound = false;


                if (catArray[cats] != null && catArray[cats].equals(genero)) {
                    catFound = true;
                    }
                //}

                if(!catFound){
                    System.out.println(genero);
                    catArray[cats] = cat;
                    cats++;

                }

                //for (int i = 0; i < jogos; i++) {

                    if (jogoArray[jogos] != null && jogoArray[jogos].equals(jogo)) {
                        jogoFound = true;
                    }
                //}

                if (!jogoFound) {
                    //System.out.println(genero);
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


    public static void function6() throws FileNotFoundException {

        File file = new File("src/GameStart_V2.txt");
        Scanner in = new Scanner(file);

        in.nextLine();
        String[][] matriz = new String[100][9];
        int j = 0;

        while (in.hasNextLine()) {
            String linha = in.nextLine();
            String[] itensDaLinha = linha.split(",");

            if (j >= matriz.length){
                matriz = resizeMatriz(matriz);
            }

            matriz[j][0] = itensDaLinha[0];
            matriz[j][1] = itensDaLinha[1];
            matriz[j][2] = itensDaLinha[2];
            matriz[j][3] = itensDaLinha[3];
            matriz[j][4] = itensDaLinha[4];
            matriz[j][5] = itensDaLinha[5];
            matriz[j][6] = itensDaLinha[6];
            matriz[j][7] = itensDaLinha[7];
            matriz[j][8] = itensDaLinha[8];

            j++;


        }

        double precoInicial = Double.parseDouble(matriz[0][8]);

        double precoNovo = 0;

        for (int w = 0; w < j; w++) {

            precoNovo = Double.parseDouble(matriz[w][8]);

            if (precoNovo >= precoInicial) {
                precoInicial = precoNovo;
            }

        }

        System.out.println(precoInicial + " €");


        for (int k = 0; k < j; k++) {

            double newPreco = Double.parseDouble(matriz[k][8]);
            String nome = matriz[k][2];


            if (newPreco == precoInicial) {
                System.out.println(nome);
            }

        }

        in.close();
    }

    public static String[][] resizeMatriz(String[][] matriz){

        String[][] newArray = new String[2 * matriz.length][9];

        for (int i = 0; i < matriz.length; i++){
            newArray[i] = matriz[i];
        }
        return newArray;

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
                    function6();
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