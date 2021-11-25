package dasniko.peanuts;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
@Path("/peanuts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PeanutsResource {

    @Inject
    PeanutRepository repository;

    @GET
    public List<Peanut> getPeanuts(@QueryParam("search") String search,
                                   @QueryParam("first") @DefaultValue("1") int first,
                                   @QueryParam("max") @DefaultValue("20") int max) {
        return repository.searchPeanuts(search, first, max);
    }

    @GET
    @Path("/{id}")
    public Peanut getPeanutById(@PathParam("id") String id) {
        return repository.getPeanutByUsername(id);
    }

    @GET
    @Path("/{id}/credentials")
    public CredentialData getCredentialData(@PathParam("id") String id) {
        return new CredentialData();
    }

    @PUT
    @Path("/{id}/credentials")
    public void updateCredentialData(@PathParam("id") String id, CredentialData credentialData) {
        // do nothing, just for dummy purposed
    }

}
