package servicios;

import dao.UsuarioDao;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.json.Json;
import javax.json.JsonObject;
import modelo.Usuario;

@Path("auth")
public class Login 
{
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validar (Usuario usuario)
    {
        boolean status = UsuarioDao.validar(usuario.getUsername(), usuario.getPass());
        if(status)
        {
            String HASH = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IkVzdGVsYSBCYXJhamFzIiwicGFzc3dvcmQiOiJhZG1pbiIsImV4cCI6MTYzODQ5NDcwMX0.YNd1bImfXHBkF7sVPePboiLMkNZR0idAcLL0I6Gbn9A";
            
            JsonObject json = Json.createObjectBuilder()
                                  .add("token", HASH)
                                  .build();
            return Response.status(Response.Status.CREATED).entity(json).build();
        }
        JsonObject json = Json.createObjectBuilder()
                                  .add("mensaje", "Error en los datos")
                                  .build();
        return Response.status(Response.Status.UNAUTHORIZED)
                       .entity(json)
                       .build();
    }
}
