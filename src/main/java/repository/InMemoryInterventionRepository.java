package repository;

import DTO.Intervento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryInterventionRepository implements InterventionRepository {

    private Map<Integer, Intervento> mappa = new HashMap<>();

    @Override
    public void save(Intervento intervento) {
        mappa.put(intervento.getId(),intervento);
    }

    @Override
    public Intervento findById(int id) {
        return mappa.get(id);
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
