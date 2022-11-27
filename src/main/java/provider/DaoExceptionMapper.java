package provider;

import dao.DaoException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Classe che permette la gestione degli errori tramite messaggi chiari all'utente
 */
@Provider
public class DaoExceptionMapper implements ExceptionMapper<DaoException> {

    @Override
    public Response toResponse(DaoException e) {
        Map<String, String> errore = new HashMap<>();
        errore.put("messaggio", e.getMessage());
        errore.put("data", new Date().toString());
        return Response.status(500).entity(errore).build();
    }
}
