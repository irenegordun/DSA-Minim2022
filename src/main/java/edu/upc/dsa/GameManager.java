package edu.upc.dsa;

//imports de les classes de models
import edu.upc.dsa.models.*;

import java.util.*;

public interface GameManager {

    //operacions enunciat
    // Registro de un usuario con la siguiente información: nombre,apellidos, fecha de nacimiento, correo electrónico y password.
    //El proceso de registro genera un nuevo usuario en el sistema,con un identificador asociado y un saldo inicial de 50
    //dsaCoins. En caso que el sistema ya tenga un usuario con elcorreo electrónico se debe indicar el error.
    public void addUser (String nombre, String apellido1, String apellido2, String fecha, String mail, String password);

    // Registro de un usuario con la siguiente información: nombre,apellidos, fecha de nacimiento, correo electrónico y password.
    //El proceso de registro genera un nuevo usuario en el sistema,con un identificador asociado y un saldo inicial de 50
    //dsaCoins. En caso que el sistema ya tenga un usuario con elcorreo electrónico se debe indicar el error.
    public List<User> listaUsersAlfabeticamente();

    //Login de un usuario (email/password)
    public void login(String mail, String password);

    // Añadir un nuevo objeto (nombre, descripción, coins) en el catálogo de objetos de la tienda.
    public void addObjecto (String nombre, String descripcion, int precio);

    // Listado de objetos, global de la tienda, ordenado por precio(descendentemente)
    public List<Objeto> listaObjetosPrecio ();

    // Compra de un objeto por parte de un usuario. En caso que el usuario no exista o no disponga de saldo suficiente, se deberá
    //informar del error.
    public void compra (String idUser, String nombreObjeto);

    // Listado de objetos comprados por un usuario.
    public List<Objeto> listaObjetosUser (String idUser);

    //operacions extres
    public void clear();
}
