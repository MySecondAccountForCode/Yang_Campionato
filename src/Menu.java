import java.util.List;

import static java.lang.System.out;

/**
 * classe Menu usato per stampare il contenuto del menu.
 * ed offre anche dei metodi per stampare List di partite e List di squadre
 * tutti i suoi metodi sono statici, quindi non c'e' bisogno di istanziare
 * un suo oggetto per usarlo.
 *
 * @author Yang Lorenzo
 */
public class Menu {
    /**
     * stampa il menu
     */
    public static void menu() {
        out.println("1) partite per giornata");
        out.println("2) partite per squadra");
        out.println("3) classifica del campionato");
        out.println("0) fine programma");
    }

    /**
     * stampa la lista di partite
     *
     * @param lista una lista di partite
     */
    public static void stampaPartite(List<Partita> lista) {
        if (lista != null && !lista.isEmpty()) {
            for (Partita p : lista)
                out.println(p);
            out.println();
        } else {
            out.println("lista vuota");
            out.println();
        }
    }

    /**
     * stampa la lista di squadre
     *
     * @param lista una lista di squadre
     */
    public static void stampaSquadre(List<Squadra> lista) {
        if (lista != null && !lista.isEmpty()) {
            for (Squadra s : lista)
                out.println(s);
            out.println();
        } else {
            out.println("lista vuota");
            out.println();
        }
    }

}
