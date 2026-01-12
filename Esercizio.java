//LEGGERE LE ISTRUZIONI NEL FILE README.md

import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {

    //Input da tastiera
    static Scanner input = new Scanner(System.in);
    
    static boolean inserisciInGriglia(String[][] G, int i, int j, String s) {
        i = i - 1;
        j = j - 1;

        boolean coordinateCorrette = (i >= 0 && i <= 2 && j >= 0 && j <= 2);

        if (coordinateCorrette && G[i][j].equals("-")) {
            G[i][j] = s;
            return true;
        }

        return false;
    }

    static void azzeraGriglia(String[][] G, int righe, int colonne) {
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                G[i][j] = "-";
            }
        }
    }

    static boolean controllaVincita(String[][] G, String s) {
        for (int i = 0; i < 3; i++) {
            if ((G[i][0].equals(s) && G[i][1].equals(s) && G[i][2].equals(s)) ||
                (G[0][i].equals(s) && G[1][i].equals(s) && G[2][i].equals(s))) {
                return true;
            }
        }

        if ((G[0][0].equals(s) && G[1][1].equals(s) && G[2][2].equals(s)) ||
            (G[0][2].equals(s) && G[1][1].equals(s) && G[2][0].equals(s))) {
            return true;
        }

        return false;
    }

    static int contaCaselleLibere(String[][] G) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (G[i][j].equals("-")) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String args[]) {

        String[][] griglia = new String[3][3];
        azzeraGriglia(griglia, 3, 3);

        System.out.println("Griglia di gioco:");
        UtilsMatrice.visualizza(griglia);

        String s = "X";
        boolean haiVinto = false;
        boolean pareggio = false;

        do {
            boolean mossaCorretta;
            int mossaI, mossaJ;

            do {
                System.out.println("Giocatore " + s + ", inserisci la tua mossa (riga e colonna [1-3]):");
                mossaI = Integer.parseInt(input.nextLine());
                mossaJ = Integer.parseInt(input.nextLine());
                mossaCorretta = inserisciInGriglia(griglia, mossaI, mossaJ, s);
            } while (!mossaCorretta);

            System.out.println("Griglia di gioco:");
            UtilsMatrice.visualizza(griglia);

            haiVinto = controllaVincita(griglia, s);
            if (haiVinto) {
                System.out.println(s + " VINCE!");
            }

            pareggio = !haiVinto && contaCaselleLibere(griglia) == 0;
            if (pareggio) {
                System.out.println("PAREGGIO!");
            }

            if (s.equals("X")) {
                s = "O";
            } else {
                s = "X";
            }

        } while (!haiVinto && !pareggio);
    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md
