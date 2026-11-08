package service;

import DTO.Intervento;
import DTO.Stato;
import repository.InterventionRepository;
import utilities.EsitoOperazione;
import utilities.RisultatoOperazione;

import java.util.List;

public class InterventionService{

    private int countId = 0;

    private InterventionRepository repository;
    private NotificationService notificationService;

    public InterventionService(InterventionRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void salvaTicket(String titoloIntervento, String descrizioneIntervento) throws Exception{
        Intervento intervento = new Intervento(generaId(), titoloIntervento, descrizioneIntervento, Stato.NEW);
        repository.save(intervento);
        notificationService.ritornaMessaggio(NotificationService.Esito.OK,"OK");
    }

    public RisultatoOperazione trovaTicket(int id) {
        Intervento intervento = repository.findById(id);
        if(intervento == null){
            return new RisultatoOperazione(EsitoOperazione.NOT_FOUND, "Intervento non trovato", null);
        }
        return new RisultatoOperazione(EsitoOperazione.TROVATO,"Intervento trovato", intervento);
    }

    public List<Intervento> listaTicket() throws Exception{
        return repository.findAll();
    }

    public void eliminaTicket(int id) throws Exception{
        repository.deleteById(id);
        notificationService.ritornaMessaggio(NotificationService.Esito.OK,"OK");
    }

    public void modificaTitolo(int id, String titolo) throws Exception{
        Intervento intervento = repository.findById(id);
        if(intervento != null){
            intervento.setTitolo(titolo);
            repository.save(intervento);
            notificationService.ritornaMessaggio(NotificationService.Esito.OK,"OK");
        }else{
            //errore
            notificationService.ritornaMessaggio(NotificationService.Esito.NOT_FOUND,"NOT_FOUND");
        }
    }

    public void modificaDescrizione(int id, String descrizione) throws Exception{
        Intervento intervento = repository.findById(id);
        if(intervento != null){
            intervento.setDescrizione(descrizione);
            repository.save(intervento);
            notificationService.ritornaMessaggio(NotificationService.Esito.OK,"OK");
        }else{
            //errore
            notificationService.ritornaMessaggio(NotificationService.Esito.NOT_FOUND,"NOT_FOUND");
        }
    }

    public RisultatoOperazione modificaStato(int id, Stato stato) {
        Intervento intervento = repository.findById(id);

        if (intervento == null) {
            return new RisultatoOperazione(
                    EsitoOperazione.NOT_FOUND,
                    "Intervento non trovato",
                    null
            );
        }
        EsitoTransizione esito = validaTransizione(intervento.getStato(), stato);

        if (esito == EsitoTransizione.STATO_GIA_RAGGIUNTO) {
            return new RisultatoOperazione(
                    EsitoOperazione.STATO_GIA_RAGGIUNTO,
                    "Stato già raggiunto",
                    intervento
            );
        }
        if (esito == EsitoTransizione.NON_CONSENTITA) {
            return new RisultatoOperazione(
                    EsitoOperazione.TRANSIZIONE_NON_CONSENTITA,
                    "Transizione non consentita",
                    null
            );
        }
        intervento.setStato(stato);
        Intervento interventoSalvato = repository.save(intervento);

        return new RisultatoOperazione(
                EsitoOperazione.MODIFICATO,
                "Intervento modificato",
                interventoSalvato
        );
    }

    public void completaStato(int id) throws Exception{
        modificaStato(id, Stato.COMPLETED);
//        Intervento intervento = repository.findById(id);
//        if(intervento != null){
//
//            EsitoTransizione esito = validaTransizione(intervento.getStato(), Stato.COMPLETED);
//            if(esito == EsitoTransizione.CONSENTITA){
//                intervento.setStato(Stato.COMPLETED);
//                repository.save(intervento);
//                notificationService.ritornaMessaggio(NotificationService.Esito.OK,"OK");
//            }else if(esito == EsitoTransizione.STATO_GIA_RAGGIUNTO){
//                notificationService.ritornaMessaggio(NotificationService.Esito.OK,"OK");
//            }else{
//                //errore per impossibilità
//                notificationService.ritornaMessaggio(NotificationService.Esito.KO,"KO");
//                }
//        }else{
//            //errore
//            notificationService.ritornaMessaggio(NotificationService.Esito.NOT_FOUND, "NOT_FOUND");
//        }
    }

    private EsitoTransizione validaTransizione(Stato oldStato, Stato newStato){
        if(oldStato == newStato){
            //non un operazione valida
            return EsitoTransizione.STATO_GIA_RAGGIUNTO;
        }else if(oldStato == Stato.COMPLETED && newStato == Stato.NEW){
            //non si puo fare
            return EsitoTransizione.NON_CONSENTITA;
        }else{
            //per ora tutte le altre operazioni sono ok
            return EsitoTransizione.CONSENTITA;
        }
    }

    private enum EsitoTransizione {
        CONSENTITA,
        STATO_GIA_RAGGIUNTO,
        NON_CONSENTITA
    }

    private int generaId(){
        return ++countId;
    }
}
