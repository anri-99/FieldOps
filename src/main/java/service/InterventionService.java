package service;

import DTO.Intervento;
import DTO.Stato;
import repository.InMemoryInterventionRepository;
import repository.InterventionRepository;

import java.util.List;

public class InterventionService{

    private int countId = 0;
    private Intervento intervento;

    private InterventionRepository repository;

    public InterventionService(InterventionRepository repository) {
        this.repository = repository;
    }

    public void salvaTicket(String titoloIntervento, String descrizioneIntervento) throws Exception{
        intervento = new Intervento(generaId(), titoloIntervento, descrizioneIntervento, Stato.NEW);
        repository.save(intervento);
    }

    public Intervento trovaTicket(int id) throws Exception{
        return repository.findById(id);
    }

    public List<Intervento> listaTicket() throws Exception{
        return repository.findAll();
    }

    public void eliminaTicket(int id) throws Exception{
        repository.deleteById(id);
    }

    public void modificaTitolo(int id, String titolo) throws Exception{
        intervento = repository.findById(id);
        intervento.setTitolo(titolo);
        repository.save(intervento);
    }

    public void modificaDescrizione(int id, String descrizione) throws Exception{
        intervento = repository.findById(id);
        intervento.setDescrizione(descrizione);
        repository.save(intervento);
    }

    public void modificaStato(int id, Stato stato) throws Exception{
        intervento = repository.findById(id);
        intervento.setStato(stato);
        repository.save(intervento);
    }

    private int generaId(){
        return ++countId;
    }
}
