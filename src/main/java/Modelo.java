import java.sql.SQLException;
import java.util.*;

/**
 * Created by Dani on 19/04/2017.
 */
public class Modelo {
    public Hashtable<Integer, User> dbu;
    private int idGenerado;
    private int idGeneraoUser;
    public List<Objects> db;


    public Modelo() {


        dbu = new Hashtable<Integer, User>();
        db = new ArrayList<>();
        this.idGenerado = 0;
        this.idGeneraoUser = 0;
    }
//Funciones Añadir
    //Añadir usuario
    public void addUs(User e) {
        e.setId(this.idGeneraoUser);
        dbu.put(idGeneraoUser, e);
        this.idGeneraoUser++;
    }

    //Añadir objeto
    public void addOb(Objects e){
        e.setId(this.idGenerado);
        db.add(e);
        this.idGenerado++;
    }
//Funcion modificar/borrar
    //Borar usuario
    public boolean delUs(int id) {
        if (dbu.get(id).getId() == id) {
            dbu.remove(id);
            return true;
        } else return false;

    }
//Borrar objeto
    public boolean delOb (int id){
        for (int i=0;i<db.size();i++){
            if (db.get(i).getId()==id){
                db.remove(i);
                return true;
            }
        }
        return false;
    }
    //Mostrar usuarios
    public Enumeration<User> getListaUs() {
        return dbu.elements();
    }
    public List<Objects> getListaOb(){
        return db;
    }//mostrar objetos
 private String[] keysOrdenadas(Hashtable ht) {//ordenar por nombre
        Object[] valores = ht.keySet().toArray();
        ArrayList lista = new ArrayList();

        for (int i = 0; i < valores.length; i++) {
            lista.add((String) valores[i]);
        }
        Collections.sort(lista);

        Object[] valores_ordenados = lista.toArray();

        String[] indice = new String[valores_ordenados.length];
        for (int i = 0; i < valores_ordenados.length; i++) {
            indice[i] = (String) valores_ordenados[i];
        }

        return indice;
    }

    //buscar usuarios
    public User buscarNombreUs(String nombre) {
        List<User> busqueda = Collections.list(getListaUs());
        User encontrado = new User();
        for (int i = 0; i < dbu.size(); i++) {
            if (dbu.get(i).nombre.equals(nombre)) {
                encontrado = dbu.get(i);
                break;
            }
        }
        return encontrado;
    }
    //Buscar objetos
    public Objects buscarNombreOb(String nombre){
        Objects encontrado=new Objects();
        for (int i=0;i<db.size();i++){
            if (db.get(i).nombre.equals(nombre)){
                encontrado = db.get(i);
                break;
            }
        }
        return encontrado;
    }
}
