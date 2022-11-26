package risorse;

import dao.ContattoDao;
import dao.ContattoDaoImpl;
import dao.DaoException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Classe che esegue le query ed effettua
 * le operazioni CRUD tramite servizi REST
 */

@Path("/contatti")
public class RisorsaContatti {

    private ContattoDao contattoDao = new ContattoDaoImpl();

    @Produces({"application/json"})
    @GET
    public Response getTuttiIContatti() throws DaoException {
        return Response.ok(contattoDao.ricercaTuttiIContatti()).build();
    }

    @Path("id={contact_id}")
    @Produces({"application/json"})
    @GET
    public Response getContattoPerId(@PathParam("contact_id") Integer id) throws DaoException {
        return Response.ok(contattoDao.ricercaContattoPerId(id)).build();
    }

    @Path("citta={contact_citta}")
    @Produces({"application/json"})
    @GET
    public Response getContattoPerCitta(@PathParam("contact_citta") String citta) throws DaoException {
        return Response.ok(contattoDao.ricercaContattoPerCitta(citta)).build();
    }

    @Path("nazione={contact_nazione}")
    @Produces({"application/json"})
    @GET
    public Response getContattoPerNazione(@PathParam("contact_nazione") String nazione) throws DaoException {
        return Response.ok(contattoDao.ricercaContattoPerNazione(nazione)).build();
    }
}
