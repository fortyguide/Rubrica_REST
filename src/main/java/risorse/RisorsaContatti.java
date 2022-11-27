package risorse;

import dao.ContattoDao;
import dao.ContattoDaoImpl;
import dao.DaoException;
import entita.Contatto;

import javax.ws.rs.*;
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

    @Path("aggiunta_contatto")
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @POST
    public Response postAggiuntaContatto(Contatto contatto) throws DaoException {
        contatto = contattoDao.aggiuntaContatto(contatto);
        return Response.ok(contatto).build();
    }

    @Path("modifica_contatto_con_id={contact_id}")
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @PUT
    public Response putModificaContatto(@PathParam("contact_id") Integer id, Contatto contatto) throws DaoException {
        contatto.setId(id);
        contatto = contattoDao.modificaContatto(contatto);
        return Response.ok(contatto).build();
    }

    @Path("cancella_contatto_con_id={contact_id}")
    @Produces({"application/json"})
    @DELETE
    public Response deleteCancellaContatto(@PathParam("contact_id") Integer id) throws DaoException {
        contattoDao.cancellazioneContatto(id);
        return Response.ok().build();
    }
}
