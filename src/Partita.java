/**
 * classe partita usata per contenere i dati di una partita di calcio
 *
 * @author Yang Lorenzo
 */
public class Partita {
    private int giornata;
    private String data;
    private String squadra_casa;
    private int[] punteggio;
    private String squadra_ospite;

    /**
     * costruttore con parametri
     *
     * @param giornata       il giorno in cui e' stata fatta la partita
     * @param data           la data della partita
     * @param squadra_casa   il nome della squadra casa
     * @param punteggio      il punteggio della partita
     * @param squadra_ospite il nome della squadra ospite
     */
    public Partita(int giornata, String data, String squadra_casa, String punteggio, String squadra_ospite) {
        this.giornata = giornata;
        this.data = data;
        this.squadra_casa = squadra_casa;
        this.punteggio = makePunteggio(punteggio, "-");
        this.squadra_ospite = squadra_ospite;
    }

    // costruttore per la lettura del file

    /**
     * costruttore utilizzato per inizializzare una Partita con una riga di testo di un file.csv
     *
     * @param line riga di testo passato da un file.csv
     * @param del  delimitatore del file.csv
     */
    public Partita(String line, String del) {
        String[] dati = line.split(del);

        giornata = Integer.parseInt(dati[0]);
        data = dati[1];
        squadra_casa = dati[2];
        punteggio = makePunteggio(dati[3], "-");
        squadra_ospite = dati[4];
    }

    /**
     * metodo privato che serve per inizializzare l'attributo punteggio
     *
     * @param str punteggio contenuto in una stringa es: 4-3
     * @param del delimitatore es: '-'
     * @return vettore di int
     * punteggio[0]: punti per la squadra casa
     * punteggio[1]: punti per la squadra ospite
     */
    private int[] makePunteggio(String str, String del) {
        String[] temp = str.split(del);
        return new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
    }

    /**
     * costruttore di copia
     *
     * @param partita un'altra partita
     */
    public Partita(Partita partita) {
        this.giornata = partita.giornata;
        this.data = partita.data;
        this.squadra_casa = partita.squadra_casa;
        this.punteggio = partita.punteggio;
        this.squadra_ospite = partita.squadra_ospite;
    }

    /**
     * restituisce la giornata
     *
     * @return la giornata
     */
    public int getGiornata() {
        return giornata;
    }

    /**
     * restituisce la data
     *
     * @return la data
     */
    public String getData() {
        return data;
    }

    /**
     * restituisce il nome della squadra casa
     *
     * @return il nome della squadra casa
     */
    public String getSquadra_casa() {
        return squadra_casa;
    }

    /**
     * restituisce il punteggio
     *
     * @return il punteggio
     */
    public int[] getPunteggio() {
        return punteggio;
    }

    /**
     * restituisce il nome della squadra ospite
     *
     * @return il nome della squadra ospite
     */
    public String getSquadra_ospite() {
        return squadra_ospite;
    }

    /**
     * restituisce la sua forma in stringa
     *
     * @return tutti i dati della partita
     */
    @Override
    public String toString() {
        return String.format("%s %s\t%30s\t%s\t %-30s", giornata, data, squadra_casa,
                Integer.toString(punteggio[0]) + "-" + Integer.toString(punteggio[1]), squadra_ospite);
    }

}