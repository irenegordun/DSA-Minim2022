package edu.upc.dsa;


import edu.upc.dsa.models.*;
import org.apache.log4j.Logger;
import java.util.*;

public class GameManagerImpl implements GameManager {
    //contenidors
    HashMap<String, User> listausers = new HashMap<String, User>();
    HashMap<Integer, Objeto> listaObjetos = new HashMap<Integer, Objeto>();

    //instancia
    private static GameManagerImpl manager;
    //logs
    static final Logger logger = Logger.getLogger(GameManagerImpl.class.getName());

    //Singleton
    public static GameManagerImpl getInstance() {
        if (manager == null) {
            logger.info("New instance edu.upc.dsa.GameManagerImpl");
            manager = new GameManagerImpl();
        }
        return manager;
    }
    private GameManagerImpl() {}

    @Override //add usuario i si existe ya el correo poner error
    public void addUser(String nombre, String apellido1, String apellido2, String fecha, String mail, String password) {

        if (listausers.get(mail)==null) {
            User us= new User(nombre, apellido1, apellido2, fecha, mail, password);
            us.setNombre(nombre);
            us.setApellido1(apellido1);
            us.setApellito2(apellido2);
            us.setFecha(fecha);
            us.setMail(mail);
            us.setPassword(password);
            listausers.put(us.getId(), us);

            logger.info("Usuari afegit correctament");
        }else
            logger.info("Usuari amb aquest correu ja existent");

    }

    @Override //ordenar per nom i si son iguals per cognom
    public List<User> listaUsersAlfabeticamente() {
        List<User> llista= new LinkedList<>(listausers.values());
        Collections.sort(llista, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            if(o1.getNombre().equals(o2.getNombre())){
                public int compare (User o1, User o2){return o1.getApellido1().compareToIgnoreCase(o2.getApellido1())}
            });

            //m'ha faltat comparar correctament cognoms
            }
        });

         return llista;
    }

    @Override
    public void login(String mail, String password) {
        User user = this.listausers.get(mail);
        if(user.getPassword().equals(password)){
            logger.info("Login con exito");
        }
        logger.info("Contraseña incorrecta");
    }

    @Override
    public void addObjecto(String nombre, String descripcion, int precio) {
        Objeto objeto = new Objeto(nombre, descripcion, precio);
        objeto.setNombre(nombre);
        objeto.setDescripcion(descripcion);
        objeto.setPrecio(precio);
        listaObjetos.put(precio, objeto);
        logger.info("Objeto "+ objeto.getNombre() +" añadido al catálogo");
    }

    @Override
    public List<Objeto> listaObjetosPrecio() {
        List<Objeto> llista = new LinkedList<>(listaObjetos.values());
        Collections.sort(llista, new Comparator<Objeto>() {
            @Override
            public int compare(Objeto o1, Objeto o2) {
                return Integer.compare(o1.getPrecio(),o2.getPrecio());
            }
        });
        logger.info("Llista objectes ordenada alfabeticament: "+llista.toString());
        return llista;
    }

    // Compra de un objeto por parte de un usuario. En caso que el
    //usuario no exista o no disponga de saldo suficiente, se deberá
    //informar del error.
    @Override
    public void compra(String idUser, String nombreObjeto) {
        User user = this.listausers.get(idUser);
        Objeto objeto = this.listaObjetos.get(nombreObjeto);
        if (user==null || user.getCoins()==0){
            logger.info("Usuari existent o no te coins");
        }else{
            //afegim objecte comprat
            user.getListaobjetos().add(objeto);
            //restem diners
            int coinsActuals = user.getCoins()-listaObjetos.get(nombreObjeto).getPrecio();
            user.setCoins(coinsActuals);
        }
    }

    @Override
    public List<Objeto> listaObjetosUser(String idUser) {
        User user = listausers.get(idUser);;
        return user.getListaobjetos();
    }

    @Override
    public void clear() {
        listausers.clear();
        listaObjetos.clear();
    }
}
