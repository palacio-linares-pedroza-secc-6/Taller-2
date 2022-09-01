package Modelo;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Pedido {

	private int Idpedido;
    private int numeroPedidos;
    private String nombreCliente;
    private String direccionCliente;
    private ArrayList<Producto> itemsPedido;
    
    public Pedido(String nombreCliente, String direccionCliente) {
    	this.nombreCliente = nombreCliente;
    	this.direccionCliente = direccionCliente;
    	
    }
    
    // no se como se calcula o se genera el ID, yo estaba pensando en un generador de numero aleatorio 
    public int getIDPedido() {
    			
    	return this.Idpedido;
    }
    
    public void agregarProducto(Producto nuevoitem) {
    	
    	
    	
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
