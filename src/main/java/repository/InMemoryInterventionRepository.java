package repository;

import DTO.Intervento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryInterventionRepository implements InterventionRepository {

    private Map<Integer, Intervento> mappa = new HashMap<>();

    @Override
    public Intervento save(Intervento intervento) {
        mappa.put(intervento.getId(),intervento);
        return intervento;
    }

    @Override
    public Intervento findById(int id) {
        Intervento intervento = mappa.get(id);
        if (intervento == null) {
            return null;
        }
        return new Intervento(intervento.getId(),intervento.getTitolo(),intervento.getDescrizione(),intervento.getStato());
    }

    @Override
    public List<Intervento> findAll() {
        ArrayList<Intervento> list = new ArrayList<>();
        mappa.forEach((key, value) -> list.add(value));
        return list;
    }

    @Override
    public void deleteById(int id) {
        mappa.remove(id);
    }
}
