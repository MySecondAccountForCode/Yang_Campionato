import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * classe Campionato che elabora i dati letti dal file.csv
 * una volta istanziato un oggetto di Campionato, si puo' stampare
 * la classifica e stampare le partite per gionata e nome della squadra.
 *
 * @author Yang Lorenzo
 */
public class Campionato {
    private final String PATH;
    // DATI DEL CAMPIONATO:  serie e stagione
    private final String serie;
    private final String stagione;

    // BufferedReader br per la lettura dei dati da file
    private BufferedReader reader;

    // HASHMAP partite_giornate(K,V)
    // K = numero giornata  V = Elenco partite giocata in quella giornata
    private Map<Integer, List<Partita>> partite_giornate;

    // TREEMAP partite_squadre(K,V)
    // K = nome squadra  V = Elenco partite giocate da quella squadra
    private Map<String, List<Partita>> partite_squadre;

    // ARRAYLIST classifica  ( del campionato ordinata per punteggio decrescente )
    private List<Squadra> classifica;

    /**
     * costruttore predefinito
     */
    public Campionato() {
        this("Premier League", "2020", ".\\Campionato\\league2020.csv");
    }

    /**
     * costruttore con parametri
     *
     * @param serie    la serie del campionato
     * @param stagione la stagione del campionato
     */
    public Campionato(String serie, String stagione) {
        this(serie, stagione, ".\\Campionato\\league2020.csv");
    }

    /**
     * costruttore con parametri
     *
     * @param serie    la serie del campionato
     * @param stagione la stagione del campionato
     * @param filename il percorso del file.csv
     */
    public Campionato(String serie, String stagione, String filename) {
        this.PATH = filename;
        this.serie = serie;
        this.stagione = stagione;
        this.partite_giornate = new HashMap<>();
        this.partite_squadre = new HashMap<>();
        this.classifica = new ArrayList<>();
        carica_dati();
        aggiornaClassifica();
    }

    /**
     * inizializza partite_giornate e partite_squadre
     */
    private void carica_dati() {
        try {
            reader = new BufferedReader(new FileReader(PATH));
            reader.readLine(); // salta la prima riga
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dati = line.split(",");
                Partita p = new Partita(Integer.parseInt(dati[0]), dati[1], dati[2], dati[3], dati[4]);

                if (!partite_giornate.containsKey(p.getGiornata()))
                    partite_giornate.put(p.getGiornata(), new LinkedList<>());
                if (!partite_squadre.containsKey(p.getSquadra_casa()))
                    partite_squadre.put(p.getSquadra_casa(), new LinkedList<>());
                if (!partite_squadre.containsKey(p.getSquadra_ospite()))
                    partite_squadre.put(p.getSquadra_ospite(), new LinkedList<>());

                partite_giornate.get(p.getGiornata()).add(p);
                partite_squadre.get(p.getSquadra_casa()).add(p);
                partite_squadre.get(p.getSquadra_ospite()).add(p);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file");
        }
    }


    /**
     * inizializza List di Squadra
     */
    private void aggiornaClassifica() {
        for (String key : partite_squadre.keySet()) {
            int punti = 0, vittorie = 0, pareggi = 0, sconfitte = 0;

            for (Partita p : partite_squadre.get(key)) {
                punti += key.equals(p.getSquadra_casa()) ? p.getPunteggio()[0] : p.getPunteggio()[1];

                int diff = key.equals(p.getSquadra_casa()) ? p.getPunteggio()[0] - p.getPunteggio()[1]
                        : p.getPunteggio()[1] - p.getPunteggio()[0];

                if (diff > 0) vittorie++;
                else if (diff < 0) sconfitte++;
                else pareggi++;
            }
            classifica.add(new Squadra(key, punti, vittorie, pareggi, sconfitte));
        }
        Collections.sort(classifica);
    }

    /**
     * stampa le partite giocate in quella giornata
     *
     * @param giornata una giornata del campionato
     */
    public void partitePerGiornata(int giornata) {
        Menu.stampaPartite(partite_giornate.get(giornata));
    }

    /**
     * stampa le partite giocate da una squadra
     *
     * @param nome il nome della squadra
     */
    public void partitePerSquadra(String nome) {
        Menu.stampaPartite(partite_squadre.get(matchName(nome)));
    }

    /**
     * stampa la classifica delle squadre
     */
    public void stampaClassifica() {
        Menu.stampaSquadre(classifica);
    }

    /**
     * metodo privato usato per ottenere il nome completo di una squadra
     *
     * @param name il nome della squadra
     * @return il nome completo della squadra
     */
    private String matchName(String name) {
        for (String key : partite_squadre.keySet())
            if (name.equalsIgnoreCase(key.substring(0, name.length()))) return key;
        return null;
    }
}

