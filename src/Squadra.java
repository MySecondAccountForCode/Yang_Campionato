/**
 * class Squadra che contiene tutte le informazioni di una squadra
 *
 * @author Yang Lorenzo
 */
public class Squadra implements Comparable<Squadra> {
    private String nome;
    private int punti;
    private int vittorie;
    private int pareggi;
    private int sconfitte;

    /**
     * costruttore con i parametri
     *
     * @param nome      nome della squadra
     * @param punti     i punti che ha fatto questa squadra
     * @param vittorie  numero di vittorie
     * @param pareggi   numero di pareggi
     * @param sconfitte numero di sconfitte
     */
    public Squadra(String nome, int punti, int vittorie, int pareggi, int sconfitte) {
        this.nome = nome;
        this.punti = punti;
        this.vittorie = vittorie;
        this.pareggi = pareggi;
        this.sconfitte = sconfitte;
    }

    /**
     * restituisce il nome della squadra
     *
     * @return il nome della squadra
     */
    public String getNome() {
        return nome;
    }

    /**
     * restituisce il numero di vittorie
     *
     * @return il numero di vittorie
     */
    public int getVittorie() {
        return vittorie;
    }

    /**
     * restituisce il numero di pareggi
     *
     * @return il numero di pareggi
     */
    public int getPareggi() {
        return pareggi;
    }

    /**
     * restituisce il numero di sconfitte
     *
     * @return il numero di sconfitte
     */
    public int getSconfitte() {
        return sconfitte;
    }

    /**
     * restituisce i punti che ha fatto
     *
     * @return i punti totali
     */
    public int getPunti() {
        return punti;
    }

    /**
     * restituisce la sua forma in stringa
     *
     * @return tutti i dati di questa squadra
     */
    @Override
    public String toString() {
        // si allinea a sinistra
        return String.format("%-30s punti:%-8s vittorie:%-8s pareggi:%-8s sconfitte:%-8s", nome, punti
                , vittorie, pareggi, sconfitte);
    }

    /**
     * override del metodo derivato dalla sua super class Object
     * le squadre si confrontano in base ai punti che hanno fatto
     *
     * @param o altra squadra
     * @return 0: uguale valore positivo: questa squadra ha fatto piu' punti dell'altra, valore negativo: viceversa
     */
    @Override
    public int compareTo(Squadra o) {
        // ORDINAMENTO DECRESCENTE PER LA CLASSIFICA
        return o.getPunti() - this.getPunti();
    }

}
