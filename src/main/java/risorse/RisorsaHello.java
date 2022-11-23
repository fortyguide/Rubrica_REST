package risorse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class RisorsaHello {

    @GET
    @Produces({"text/plain"})
    public String saluto(){ //http://localhost:8080/Rubrica_REST/hello
        return "Ciao, piacere di conoscerti, da Paolo";
    }

    @GET
    @Produces({"application/xml"})
    public String salutoXML(){
        return"<?xml version=\"1.0\" ?>\n" +
              "\n" +
              "<saluto>\n" +
              "    <messaggio>Ciao, piacere di conoscerti</messaggio>\n" +
              "    <da>Paolo</da>\n" +
              "</saluto>";
    }

    @GET
    @Produces({"application/json"})
    public String salutoJSON(){
        return "{\n" +
                "\t\"saluto\": {\n" +
                "    \"messaggio\": \"Ciao. piacere di conoscerti\"\n" +
                "\t\t\"da\": \"Paolo\" \n" +
                "    }\n" +
                "}";
    }
}
