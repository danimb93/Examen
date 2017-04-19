import java.util.List;

/**
 * Created by Dani on 19/04/2017.
 */
public class User  {
    private int id;
    public String nombre;
    public String pass;
    public String correo;

    public User(String nombre, String pass, String correo){
        this.nombre=nombre;
        this.pass=pass;
        this.correo=correo;
    }

    public User() {

    }




    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getNombre(){return nombre;}
    public void setNombre (String nombre){this.nombre=nombre;}
    public String getEmail(){return correo;}
    public void setEmail(String email){this.correo=correo;}
    public String getPassword(){return pass;}
    public void setPassword(String password){this.pass=pass;}
}

