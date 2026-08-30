package org.example;

import DTO.Intervento;
import DTO.Stato;
import repository.InterventionRepository;
import service.InterventionService;
import userInterface.MenuView;
import utilities.ScannerDati;

public class FieldOpsController {


    private String choice;
    private boolean flag = true;
    private boolean flagY = true;
    private ScannerDati scan = new ScannerDati();
    private Intervento intervento;
    private String titoloIntervento;
    private String descrizioneIntervento;
    InterventionService interventionService;

    public FieldOpsController(InterventionService interventionService) {
        this.interventionService = interventionService;
    }

    public void startFieldOps(){

        while (flag) {

            MenuView.menuPrincipale();
            choice = scan.scanDati();

            switch(choice){
                case "1":
                    inserisciNuovoTicket();
                    break;
                case "2":
                    gestisciTicket();
                    break;
                case "3":
                    eliminaTicket();
                    break;
                case "4":
                    MenuView.stampaMessaggioLogout();
                    flag = false;
                    break;
                default:
                    MenuView.stampaMessaggioErrore1();
                    break;
            }
        }

    }

    private void inserisciNuovoTicket(){
        MenuView.stampaInserimentoTitoloTicket();
        titoloIntervento = scan.scanDati();
        MenuView.stampaInserimentoDescrizioneTicket();
        descrizioneIntervento = scan.scanDati();
        try {
            interventionService.salvaTicket(titoloIntervento, descrizioneIntervento);
        } catch (Exception e) {
            MenuView.stampaErrore(e);
        }
        MenuView.stampaInserimentoSegnalazioneTicket();
    }

    private void gestisciTicket(){

        int idTicket;

        while (flagY) {

            MenuView.messaggioRicercaTicket();
            idTicket = Integer.parseInt(scan.scanDati());
            try {
                MenuView.stampaInterventoCercato(interventionService.trovaTicket(idTicket));

                MenuView.menuTicket();
                choice = scan.scanDati();

                switch (choice) {
                    case "1": //cambia titolo
                        MenuView.modificaTitolo();
                        String titolo = scan.scanDati();
                        interventionService.modificaTitolo(idTicket, titolo);
                        break;
                    case "2": //cambia descrizione
                        MenuView.modificaDescrizione();
                        String descrizione = scan.scanDati();
                        interventionService.modificaDescrizione(idTicket, descrizione);
                        break;
                    case "3": //cambia stato
                        MenuView.modificaStato();
                        String stato = scan.scanDati();
                        Stato newStato;
                        switch (stato.toLowerCase()) {
                            case "new":
                                interventionService.modificaStato(idTicket, Stato.NEW);
                                break;
                            case "test":
                                interventionService.modificaStato(idTicket, Stato.TEST);
                                break;
                            case "resolved":
                                interventionService.modificaStato(idTicket, Stato.RESOLVED);
                                break;
                            case "completed":
                                interventionService.modificaStato(idTicket, Stato.COMPLETED);
                                break;
                            case "active":
                                interventionService.modificaStato(idTicket, Stato.ACTIVE);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "4": //indietro
                        flagY = false;
                        break;
                    default:
                        MenuView.stampaMessaggioErrore1();
                        break;
                }
            }catch (Exception e){
                MenuView.stampaErrore(e);
            }
        }
    }

    private void eliminaTicket(){

        boolean flagX = true;
        int id;
        String titolo;
        while(flagX){
            MenuView.messaggioRicercaById();
            id = Integer.parseInt(scan.scanDati());
            try {
                MenuView.stampaInterventoCercato(interventionService.trovaTicket(id));
                MenuView.messaggioConfermaEliminazione();
                choice = scan.scanDati();
                if (choice.equalsIgnoreCase("Y")) {
                    interventionService.eliminaTicket(id);
                    MenuView.messaggioConfermaEliminazioneConSuccesso();
                    flagX = false;
                    break;
                } else if (choice.equalsIgnoreCase("N")) {
                    MenuView.messaggioRiprovaRicerca();
                    break;
                } else {
                    MenuView.stampaMessaggioErrore1();
                    break;
                }
            }catch (Exception e){
                MenuView.stampaErrore(e);
            }
        }
    }



}
