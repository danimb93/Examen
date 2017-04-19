import com.sun.deploy.nativesandbox.comm.Response;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;

/**
 * Created by Dani on 19/04/2017.
 */


public class JsonControl {
    protected List<User> users;
    protected List<Objects> object;



    @GET
    @Path("/usuario/got_id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserId(@PathParam("id") int id){

        User finded = new User();

        for (int i = 0; i<users.size(); i++){
            if (users.get(i).getId() == id){
                finded = users.get(i);
            }
        }
        return finded;
    }
    @GET
    @Path("/usuario/got_correo/{correo}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserCorreo(@PathParam("correo") String email){

        User finded = new User();

        for (int i = 0; i<users.size(); i++){
            if (users.get(i).getEmail().equalsIgnoreCase(email)){
                finded = users.get(i);
            }
        }
        return finded;
    }
    @GET
    @Path("/usuario/got_correo/{correo}")
    @Produces(PageAttributes.MediaType.APPLICATION_JSON)
    public User getUserCorreo(@PathParam("correo") String email){

        User finded = new User();

        for (int i = 0; i<users.size(); i++){
            if (users.get(i).getEmail().equalsIgnoreCase(email)){
                finded = users.get(i);
            }
        }
        return finded;
    }
    @POST
    @Path("/user/delete/{id}")
    @Consumes(PageAttributes.MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") int id) {

        if (searchID(id)){
            User u = new User();
            u.delete(id);
            String yesResult = "Usuario eliminado.";
            return Response.status(201).entity(yesResult).build();
        }
        String noResult = "El id no existe.";
        return Response.status(418).entity(noResult).build();
    }
    @POST
    @Path("/objects/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOficinaInJSON(Objects objects) {

        objects.insert();
        String yesResult = "Objeto guardado: " + objects.getNombre();
        return Response.status(201).entity(yesResult).build();
    }
}