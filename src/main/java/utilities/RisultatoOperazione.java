package utilities;

import DTO.Intervento;

public class RisultatoOperazione {

    private final EsitoOperazione codice;
    private final String messaggio;
    private final Intervento intervento;

    public RisultatoOperazione(EsitoOperazione codice, String messaggio, Intervento intervento) {
        this.codice = codice;
        this.messaggio = messaggio;
        this.intervento = intervento;
    }

    public EsitoOperazione getCodice() {
        return codice;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public Intervento getIntervento() {
        return intervento;
    }
}
