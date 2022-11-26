package dao;

import entita.Contatto;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che implementa l’interfaccia ContattoDao
 */

public class ContattoDaoImpl implements ContattoDao {
    DbUtil dbUtil = new DbUtil();

    public Contatto aggiuntaContatto(Contatto contatto) throws DaoException {
        String sql = "insert into contacts(name, gender, email, phone, city, country) values (?,?,?,?,?,?)";

        try(
                Connection conn = dbUtil.getConnection();
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

        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public Contatto ricercaContattoPerId(Integer id) throws DaoException {
        String sql = "select * from contacts where id = ?";

        try(
                Connection conn = dbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                Contatto contatto = new Contatto();
                contatto.setId(rs.getInt("id"));
                contatto.setNome(rs.getString("name"));
                contatto.setGenere(rs.getString("gender"));
                contatto.setEmail(rs.getString("email"));
                contatto.setTelefono(rs.getString("phone"));
                contatto.setCitta(rs.getString("city"));
                contatto.setNazione(rs.getString("country"));
                return contatto;
            }
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
        return null;
    }

    public Contatto modificaContatto(Contatto contatto) throws DaoException {
        String sql = "update contacts set name=?, gender=?, email=?, phone=?, city=?, country=? where id=?";

        try(
                Connection conn = dbUtil.getConnection();
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
        String sql = "delete from contacts where id = ?";

        try(
                Connection conn = dbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1,id);

            int count = stmt.executeUpdate();
            if (count == 0) {
                throw new DaoException("Nessun record da cancellare; id fornito non valido - " + id);
            }
        } catch(Exception ex) {
            throw new DaoException(ex);
        }
    }

    public List<Contatto> ricercaTuttiIContatti() throws DaoException {
        String sql = "select * from contacts";
        List<Contatto> list = new ArrayList<>();

        try(
                Connection conn = dbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
        ){
            while(rs.next()){
                Contatto contatto = new Contatto();
                contatto.setId(rs.getInt("id"));
                contatto.setNome(rs.getString("name"));
                contatto.setGenere(rs.getString("gender"));
                contatto.setEmail(rs.getString("email"));
                contatto.setTelefono(rs.getString("phone"));
                contatto.setCitta(rs.getString("city"));
                contatto.setNazione(rs.getString("country"));
                list.add(contatto);
            }
        } catch(Exception ex) {
            throw new DaoException(ex);
        }
        return list;
    }

    public List<Contatto> ricercaContattoPerCitta(String citta) throws DaoException {
        String sql = "select * from contacts where city = ?";
        List<Contatto> list = new ArrayList<>();

        try(
                Connection conn = dbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, citta);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Contatto contatto = new Contatto();
                contatto.setId(rs.getInt("id"));
                contatto.setNome(rs.getString("name"));
                contatto.setGenere(rs.getString("gender"));
                contatto.setEmail(rs.getString("email"));
                contatto.setTelefono(rs.getString("phone"));
                contatto.setCitta(rs.getString("city"));
                contatto.setNazione(rs.getString("country"));
                list.add(contatto);
            }
        } catch(Exception ex) {
            throw new DaoException(ex);
        }
        return list;
    }

    public List<Contatto> ricercaContattoPerNazione(String nazione) throws DaoException {
        String sql = "select * from contacts where country = ?";
        List<Contatto> list = new ArrayList<>();

        try(
                Connection conn = dbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, nazione);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Contatto contatto = new Contatto();
                contatto.setId(rs.getInt("id"));
                contatto.setNome(rs.getString("name"));
                contatto.setGenere(rs.getString("gender"));
                contatto.setEmail(rs.getString("email"));
                contatto.setTelefono(rs.getString("phone"));
                contatto.setCitta(rs.getString("city"));
                contatto.setNazione(rs.getString("country"));
                list.add(contatto);
            }
        } catch(Exception ex) {
            throw new DaoException(ex);
        }
        return list;
    }
}
