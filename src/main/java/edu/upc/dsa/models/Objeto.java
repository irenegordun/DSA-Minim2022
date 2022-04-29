package edu.upc.dsa.models;

import java.util.*;

public class Objeto {
    private String nombre;
    private String descripcion;
    private int precio;
    private List<Objeto> listaobjetos=null;

    //constructor
    public Objeto(){}

    public Objeto(String nombre, String descripcion, int precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }


    //getters i setters

    public String getNombre() {return nombre;    }

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public int getPrecio() {return this.precio;}

    public void setPrecio(int precio) {this.precio = precio;}
}
