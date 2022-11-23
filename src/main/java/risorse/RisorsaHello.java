package risorse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class RisorsaHello {

    @GET
    public String saluto(){ //http://localhost:8080/Rubrica_REST/hello
        return "Ciao, piacere di conoscerti!";
    }
}
