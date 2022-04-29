package edu.upc.dsa;

//imports de classes model
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

public class GameTest {
    private static Logger logger = Logger.getLogger(String.valueOf(GameTest.class));
    GameManager manager = GameManagerImpl.getInstance();
    @Before
    public void SetUp(){
        //añadir objetos
        manager.addObjecto("Lapiz", "rosa", 2);
        manager.addObjecto("Rotulador", "verde", 1);

        //Crear Usuaris
        manager.addUser("Irene", "Gordun", "Salazar", "08022000", "irene@gmail.com","hola");
        manager.addUser("Pol", "Garcia", "Lopez", "09022001", "pol@gmail.com","pol");

    }
    @After
    public void tearDown(){manager.clear();}

    @Test
    public void testAddUser(){
        manager.addUser("Paco", "Ramon", "Lluc", "09092001", "paco@gmail.com", "paco");
        logger.info("Usuario añadido"); ;
    }
    @Test
    public void compraUsuer(){
        manager.compra("2","boli");
        logger.info("obje"+ manager.listaObjetosUser("2"));
    }
}
