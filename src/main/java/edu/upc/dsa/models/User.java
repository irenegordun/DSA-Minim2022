package edu.upc.dsa.models;

import java.util.*;
import edu.upc.dsa.models.*;

public class User {
    //atributs
    private String nombre;
    private String apellido1;
    private String apellito2;
    private String fecha; //ddmmaaaa
    private String mail;
    private String password;
    private int coins=50;
    private String id;
    private List<Objeto> listaobjetos=new ArrayList<>();

    //constructor buit

    //constructor amb atributs
    public User(){};

    public User(String nombre, String apellido1, String apellito2, String fecha, String mail, String password) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellito2 = apellito2;
        this.fecha = fecha;
        this.mail = mail;
        this.password = password;
    }

    //getters i setters
    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido1() {return apellido1;}

    public void setApellido1(String apellido1) {this.apellido1 = apellido1;}

    public String getApellito2() {return apellito2;}

    public void setApellito2(String apellito2) {this.apellito2 = apellito2;}

    public String getFecha() {return fecha;}

    public void setFecha(String fecha) {this.fecha = fecha;}

    public String getMail() {return mail;}

    public void setMail(String mail) {this.mail = mail;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public int getCoins() {return coins;}

    public void setCoins(int coins) {this.coins = coins;}

    public List<Objeto> getListaobjetos() {return listaobjetos;}

    public void setListaobjetos(List<Objeto> listaobjetos) {this.listaobjetos = listaobjetos;}

    public String getId() {return id; }

    public void setId(String id) {this.id = id;}
}
