package za.co.mashandiro.boundary;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Channel;
import za.co.mashandiro.controller.QuotesService;
import za.co.mashandiro.model.Qoute;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/quotes")
public class QuotesResource {

    @Inject
    private QuotesService quotesService;

    @Channel("test-stuff-results")
    private Multi<String> teststuff;

    @GET
    @Path("/stuff")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<String> something() {
        return teststuff;
    }

    @POST
    @Path("/request")
    @Produces(MediaType.TEXT_PLAIN)
    public String createRequest(){
        return quotesService.createRequest();
    }

    @GET
    @Path("test-get")
    @Produces(MediaType.TEXT_PLAIN)
    public String testApp() {
        return "is working it seems";
    }

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Qoute> stream() {
        return quotesService.stream();
    }

    @GET
    @Path("/gg")
    @Produces({MediaType.APPLICATION_JSON})
    public Multi<Qoute>  quites() {
        return  quotesService.stream();
    }
    
}
