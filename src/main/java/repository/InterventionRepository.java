package repository;

import DTO.Intervento;

import java.util.List;

public interface InterventionRepository {

    public Intervento save(Intervento intervento);

    public Intervento findById(int id);

    public List<Intervento> findAll();

    public void deleteById(int id);
}
