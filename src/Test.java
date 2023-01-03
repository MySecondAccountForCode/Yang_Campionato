import java.util.Scanner;

import static java.lang.System.out;

/**
 * classe Test, per eseguire il programma
 *
 * @author Yang Lorenzo
 */
public class Test {
    private static Scanner input = new Scanner(System.in);

    /**
     * metodo privato della classe Test che serve per ricevere input dall'utente
     *
     * @return restituisce l'opzione scelto
     */
    private static int getOpzione() {
        int op;
        while (true) {
            try {
                out.print("cosa vuoi fare? ");
                op = input.nextInt();
                if ((op < 1 || op > 3) && op != 0) throw new IllegalArgumentException();
                return op;
            } catch (IllegalArgumentException e) {
                out.println("numero invalido");
            }
        }
    }

    /**
     * classe main, da qui si parte il programma
     *
     * @param args i argomenti passati al programma attraverso i commandi di linea
     */
    public static void main(String[] args) {
        Campionato campionato = new Campionato("D:\\Yang\\LezioniJava\\Campionato\\league2020.csv");

        int op = -1;
        while (op != 0) {
            Menu.menu();
            op = getOpzione();
            switch (op) {
                case 1:
                    out.print("inserisci la giornata: ");
                    campionato.partitePerGiornata(input.nextInt());
                    break;
                case 2:
                    out.println("inserisci il nome della squadra: ");
                    input.nextLine(); // per scartare '/n' creato dal println
                    campionato.partitePerSquadra(input.nextLine());
                    break;
                case 3:
                    out.println("la classifica delle squadre");
                    campionato.stampaClassifica();
                    break;
            }
        }
    }
}
