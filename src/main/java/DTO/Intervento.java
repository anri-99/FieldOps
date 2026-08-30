package DTO;

import java.util.Objects;

public class Intervento {

    private int id;
    private String titolo;
    private String descrizione;
    private Stato stato;

    public Intervento() {
    }

    public Intervento(int id, String titolo, String descrizione, Stato stato) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.stato = stato;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitolo(){
        return titolo;
    }

    public void setTitolo(String titolo){
        this.titolo = titolo;
    }

    public String getDescrizione(){
        return descrizione;
    }

    public void setDescrizione(String descrizione){
        this.descrizione = descrizione;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Intervento that = (Intervento) o;
        return Objects.equals(id, that.id) && Objects.equals(titolo, that.titolo) && Objects.equals(descrizione, that.descrizione) && stato == that.stato;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titolo, descrizione, stato);
    }

    @Override
    public String toString() {
        return "Intervento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", stato=" + stato +
                '}';
    }

    public boolean is() {
        return false;
    }
}
