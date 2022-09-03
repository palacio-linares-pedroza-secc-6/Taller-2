package Modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Pedido {

    private int Idpedido;
    private static int numeroPedidos;
    private String nombreCliente;
    private String direccionCliente;
    private HashMap<String, ProductoMenu> menuBase;
    private ArrayList<Producto> itemsPedido;
    
    public Pedido(String nombreCliente, String direccionCliente, HashMap<String, ProductoMenu> menuBase) {
    	this.nombreCliente = nombreCliente;
    	this.direccionCliente = direccionCliente;
    	this.menuBase = menuBase;
    	
    }
    
    // no se como se calcula o se genera el ID, yo estaba pensando en un generador de numero aleatorio 
    public int getIDPedido() {

Parte de generará ID

Math.random()*100  // Esto da valores de 0.0 a 10.0, excluido el 100.0  // Sacamos un mod 3=1

Guardar en un variable que se le va asignar a la clase pedio 

// todo lo anterior transformarlo a la sintaxis de Java, la función de Math ya es propia de Java 


    			
    	return this.Idpedido;
    }
    
    public void agregarProducto(String nuevoitem) {
    	Producto nuevoProducto = menuBase.get(nuevoitem);
    	itemsPedido.add(nuevoProducto);
    	
    	
    	
    }
    // Desde aca se necesita tener ya desarollado la interface y los productos
    private int getPrecioNetoPedido() {
    	
    	
    	return numeroPedidos;
    }
    
    private int getPrecioTotalPedido() {
    	
    	
    	return numeroPedidos;
    }
    
    private int getPrecioIVAPedido() {
    	
    	return numeroPedidos;
    }
    
    private String generarTextoFactura() {
    	
    	return nombreCliente;
    }
    
    public void guardarFactura(File archivo){
    	
    	String IDString = String.valueOf(Idpedido);
    	String ruta = "/Facturas/" + IDString;
    	
    	// estoy muy confundido con lo de llamar las funciones dentro de si mismo
    	
    }
    
    
}