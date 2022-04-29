package edu.upc.dsa.services;

import edu.upc.dsa.models.*;
import edu.upc.dsa.GameManager;
import edu.upc.dsa.GameManagerImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sun.jvm.hotspot.oops.ObjArrayKlass;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Api(value = "/Game", description = "Endpoint to Text Service")
@Path("/game")
public class GameService {

    private GameManager manager;

    public GameService(){
        this.manager  = GameManagerImpl.getInstance();
        if(true){
            //this.manager.addUser("Joel","1",null);
            //this.manager.addUser("Maria", "2", null);
            //manager.addPuntoInteresToUser("Joel","Puente");
            //manager.addPuntoInteresToUser("Maria", "Porta1");
        }
    }
    
    //Añadir usuario
    @POST
    @ApiOperation(value = "Añadir un usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response=User.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUsuer(User user) {
        if (user.getNombre()==null )  return Response.status(500).entity(user).build();
        this.manager.addUser(new User(user.getNombre(), user.getApellido1(), user.getApellito2(), user.getFecha(), user.getMail(), user.getPassword());
        return Response.status(201).entity(user).build();
    }

    //lista usuarios alfabeticamente
    @GET
    @ApiOperation(value = "Listado de usuarios ordenado alfabéticamente", notes = "alfabeticamente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
            @ApiResponse(code = 404, message= "Lista de usuarios no encontrada (está vacía)")
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarUsuariosOrdenados(){

        List<User> usuarioList = this.manager.listaUsersAlfabeticamente();
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(usuarioList) {};

        if(usuarioList.size() > 0)
            return Response.status(201).entity(entity).build();
        return Response.status(404).entity(entity).build();
    }
    //login
    @GET
    @ApiOperation(value = "Login usuario", notes = "Login")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Usuario not found")
    })
    @Path("/{id}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarInfoUsuario(@PathParam("id") String id, @PathParam("password")String password) {
        User user = this.manager.login(user.getMail(),user.getPassword());
        if (user == null) return Response.status(404).build();
        else  return Response.status(201).entity(user).build();
    }

    //añadir nuevo objeto a catálogo
    @POST
    @ApiOperation(value = "Añadir un objeto al catálogo", notes = "añadir objeto tienda")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response=Objeto.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addObjeto(Objeto objeto) {
        if (objeto.getNombre()==null )  return Response.status(500).entity(objeto).build();
        this.manager.addObjecto(objeto.getNombre(), objeto.getDescripcion(), objeto.getPrecio());
        return Response.status(201).entity(objeto).build();
    }

    //lista objetos tienda
    @GET
    @ApiOperation(value = "Listado de usuarios ordenado descendentemente por puntos de interés por los que han pasado", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer="List"),
            @ApiResponse(code = 404, message= "Lista de objetos no encontrada (está vacía)")
    })


    @Path("/getUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listadoUsuariosPorPuntos(){

        List<Objeto> objetosList = this.manager.listaObjetosPrecio();
        List<Objeto> objetosList2= new LinkedList<>();
        for(Objeto objeto:objetosList){
            objetosList2.add(objeto.getNombre(), objeto.getDescripcion(), objeto.getPrecio());
        }
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetosList2) {};

        if(objetosList.size() > 0)
            return Response.status(201).entity(entity).build();
        else
            return Response.status(404).entity(entity).build();
    }

    //compra objeto
    @GET
    @ApiOperation(value = "Comprar objeto", notes = "Compra objeto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Usuario not found")
    })
    @Path("/{id}/{nombreObjeto}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response compra(@PathParam("id") String id, @PathParam("id") Objeto objeto ) {
        User user = this.manager.compra(user.getId(), objeto.getNombre());
        if (user == null || user.getCoins()==0) return Response.status(404).build();
        else  return Response.status(201).entity(user).build();
    }

    //lista objetos usuario INACABADA
    @GET
    @ApiOperation(value = "Listado de objetos usuario", notes = "objetos usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer="List"),
            @ApiResponse(code = 404, message= "Lista de objetos no encontrada (está vacía)")
    })


    @Path("/getObjetos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaObjetosUser((){

        List<Objeto> objetoList = this.manager.listaObjetosUser();
        List<Objeto> usuarioList2= new LinkedList<>();
        for(Objeto objeto:objetoList){
            usuarioList2.add(new Objeto(objeto.getNombre(), objeto.getDescripcion(), objeto.getPrecio());
        }
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(usuarioList2) {};

        if(objetoList.size() > 0)
            return Response.status(201).entity(entity).build();
        else
            return Response.status(404).entity(entity).build();
    }

}
