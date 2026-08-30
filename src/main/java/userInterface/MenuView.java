package userInterface;

import DTO.Intervento;
import utilities.ScannerDati;

public class MenuView {

    ScannerDati scan = new ScannerDati();

    public static void menuPrincipale(){
        System.out.println("Menu: ");
        System.out.println(" 1) apri ticket ");
        System.out.println(" 2) gestisci ticket ");
        System.out.println(" 3) elimina ticket ");
        System.out.println(" 4) logout ");
        System.out.println("----------------------");
    }

    public static void menuTicket(){
        System.out.println("Gestisci Ticket: ");
        System.out.println(" 1) cambia titolo ");
        System.out.println(" 2) cambia descrizione ");
        System.out.println(" 3) cambia stato ");
        System.out.println(" 4) indietro ");
        System.out.println("----------------------");
    }

    public static void stampaMessaggioErrore1(){
        System.out.println("L'input inserito non è corretto, inserire uno tra i seguenti valori: 1, 2, 3, 4");
        System.out.println("----------------------");
    }

    public static void stampaMessaggioLogout(){
        System.out.println("Hai eseguito il logout");
        System.out.println("----------------------");
    }

    public static void stampaInserimentoTitoloTicket(){
        System.out.println("Inizia inserendo il titolo del ticket che si vuole aprire");
    }

    public static void stampaInserimentoDescrizioneTicket(){
        System.out.println("Inserisci anche una descrizione relativa al problema riscontrato ");
    }

    public static void stampaInserimentoSegnalazioneTicket(){
        System.out.println("Grazie per la segnalazione");
    }

    public static void cercaEliminazioneTicket(){
        System.out.println("Cerca il ticket che vuoi eliminare tramite id: ");
    }

    public static void messaggioRicercaById(){
        System.out.println("Inserisci id del ticket che si vuole eliminare ");
    }

    public static void messaggioRicercaByTitolo(){
        System.out.println("Inserisci titolo del ticket che si vuole eliminare");
    }

    public static void stampaInterventoCercato(Intervento intervento){
        intervento.toString();
        System.out.println("----------------------");
    }

    public static void messaggioConfermaEliminazione(){
        System.out.println("Questo è il ticket che si vuole eliminare? (Y/N)");
    }

    public static void messaggioConfermaEliminazioneConSuccesso(){

        System.out.println("Questo ticket è stato eliminato con successo");
    }

    public static void messaggioRiprovaRicerca(){
        System.out.println("Ci dispiace ma il ticket cercato non è presente nel sistema");
    }

    public static void messaggioRicercaTicket(){
        System.out.println("Inserisci id del ticket che si vuole modificare ");
    }

    public static void messaggioConfermaModifica(){
        System.out.println("Questo è il ticket cercato? (Y/N)");
    }

    public static void modificaTitolo(){
        System.out.println("Inserisci il nuovo titolo");
    }

    public static void modificaDescrizione(){
        System.out.println("Inserisci la nuova descrizione");
    }

    public static void modificaStato(){
        System.out.println("Inserisci il nuovo stato: (NEW;TEST;ACTIVE;RESOLVED;) ");
    }

    public static void stampaErrore(Exception e){
        System.out.println(e.getStackTrace());
    }
}
