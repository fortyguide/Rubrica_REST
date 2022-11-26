package dao;

import entita.Contatto;

import java.util.List;

/**
 * Interfaccia che contiene le operazioni che si eseguono per fare le query alla tabella;
 */

public interface ContattoDao {

    //OPERAZIONI CRUD
    public Contatto aggiuntaContatto(Contatto contatto) throws DaoException;
    public Contatto ricercaContattoPerId(Integer id) throws DaoException;
    public Contatto modificaContatto(Contatto contatto) throws DaoException;
    public void cancellazioneContatto(Integer id) throws DaoException;

    //QUERY
    public List<Contatto> ricercaTuttiIContatti() throws DaoException;
    public List<Contatto> ricercaContattoPerCitta(String citta) throws DaoException;
    public List<Contatto> ricercaContattoPerNazione(String nazione) throws DaoException;
}
