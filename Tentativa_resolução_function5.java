public class Main {
    public static void function5() throws FileNotFoundException {

        File Ficheiro = new File("src/GameStart.csv");
        Scanner in = new Scanner(Ficheiro);

        Scanner input = new Scanner(System.in);

        System.out.println("Insira a editora que deseja consultar");
        String editora = input.next();

        String genero = "";
        String jogo = "";
        String jogoAntes = "";
        String[] jogoArray = new String[100];
        int i = 0;
        int jogatana = 0;

        in.nextLine();

        boolean jogoFound = false;

        while (in.hasNextLine()) {
            String linha = in.nextLine();
            String[] itensDaLinha = linha.split(";");


            if (itensDaLinha[5].equals(editora)) {

                genero = itensDaLinha[6];
                jogo = itensDaLinha[7];


                for (i = 0; i < jogatana; i++) {

                    if (jogoArray[i].equals(jogo)) {
                        jogoFound = true;
                    }
                }
                    if (!jogoArray[i].equals(jogoAntes)) {
                        jogoFound = false;
                        System.out.println(genero);
                        System.out.println(jogo);
                        jogoArray[jogatana] = jogo;
                        //jogoAntes = jogoArray[i];
                        jogatana++;

                    }
                }
            }
        }
        in.close();
    }
}