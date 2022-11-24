package dao;

import entita.Contatto;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Classe che implementa l’interfaccia ContattoDao
 */

public class ContattoDaoImpl implements ContattoDao {

    public Contatto aggiuntaContatto(Contatto contatto) throws DaoException {
        String sql = "insert into contacts(name, gender, email, phone, city, country) values (?,?,?,?,?,?)";

        try(
                Connection conn = DbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setString(1, contatto.getNome());
            stmt.setString(2, contatto.getGenere());
            stmt.setString(3, contatto.getEmail());
            stmt.setString(4, contatto.getTelefono());
            stmt.setString(5, contatto.getCitta());
            stmt.setString(6, contatto.getNazione());

            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();
            keys.next();
            contatto.setId(keys.getInt(1));

            return contatto;

        }catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public Contatto ricercaContattoPerId(Integer id) throws DaoException {
        return null;
    }

    public Contatto modificaContatto(Contatto contatto) throws DaoException {
        String sql = "update contacts set name=?, gender=?, email=?, phone=?, city=?, country=? where id=?";

        try(
                Connection conn = DbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, contatto.getNome());
            stmt.setString(2, contatto.getGenere());
            stmt.setString(3, contatto.getEmail());
            stmt.setString(4, contatto.getTelefono());
            stmt.setString(5, contatto.getCitta());
            stmt.setString(6, contatto.getNazione());
            stmt.setInt(7,contatto.getId());

            int count = stmt.executeUpdate();
            if (count == 0) {
                throw new DaoException("Nessun record da modificare; id fornito non valido - " + contatto.getId());
            }

        } catch(Exception ex) {
            throw new DaoException(ex);
        }
        return contatto;
    }

    public void cancellazioneContatto(Integer id) throws DaoException {
        String sql = "delete form contacts where id = ?";

        try(
                Connection conn = DbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1,id);

            int count = stmt.executeUpdate();
            if (count == 0) {
                throw new DaoException("Nessun record da cancellare; id fornito non valido - " + id);
            }
        }catch(Exception ex) {
            throw new DaoException(ex);
        }
    }

    public List<Contatto> ricercaTuttiIContatti() throws DaoException {
        return null;
    }

    public List<Contatto> ricercaContattoPerCitta(String citta) throws DaoException {
        return null;
    }

    public List<Contatto> ricercaContattoPerPaese(String paese) throws DaoException {
        return null;
    }
}
