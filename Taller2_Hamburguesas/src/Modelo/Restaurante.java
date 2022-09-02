package Modelo;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;

public class Restaurante {
	
	// Objects of the other classes
	
	private ArrayList<Pedido> pedidos;
	private static Pedido pedidoEnCurso;
	private HashMap<String, ProductoMenu> menuBase;
	private HashMap<String, Bebida> menuBebidas;
	private HashMap<String, Acompanamiento> menuAcompanamientos;
	private HashMap<String, Ingrediente> ingredientes;
	private HashMap<String, Combo> combos;
	
	
	
	public Restaurante () {
		
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente){
		pedidoEnCurso = new Pedido(nombreCliente,direccionCliente);
		
	}
	
	public void cerrarYGuardarPedido(){
		
		
	}
	
	public Pedido getPedidoEnCurso(){
		
		return pedidoEnCurso;
		
	}
	
	public HashMap<String, ProductoMenu> getMenuBase(){
		
		return menuBase;
		
	}
	
	public HashMap<String, Ingrediente> getIngredientes(){
		
		return ingredientes;
		
	}
	
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos, File archivoBebidas, File archivoAcompanamientos) throws IOException {
		
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarBebidas(archivoBebidas);
		cargarAcompanamientos(archivoAcompanamientos);
		cargarCombos(archivoCombos);
		
		
	}
	
	private void cargarIngredientes(File archivoIngredientes) throws IOException{
		
		ingredientes = new HashMap<String,Ingrediente>();
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		String current;
		
		while ((current = br.readLine()) != null) {
			
			String[] nombrePrecio = current.split(";");
			Ingrediente ingrediente = new Ingrediente(nombrePrecio[0],Integer.parseInt(nombrePrecio[1]),Integer.parseInt(nombrePrecio[2]));
			ingredientes.put(nombrePrecio[0],ingrediente);
			
		}
	}
	
	private void cargarMenu(File archivoMenu) throws IOException {
		
		menuBase = new HashMap<String,ProductoMenu>();
		BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
		String current;
		
		while ((current = br.readLine()) != null) {
			
			String[] nombrePrecio = current.split(";");
			ProductoMenu productoMenu = new ProductoMenu(nombrePrecio[0],Integer.parseInt(nombrePrecio[1]),Integer.parseInt(nombrePrecio[2]));
			menuBase.put(nombrePrecio[0],productoMenu);
		}
	}
	
	private void cargarBebidas(File archivoBebidas) throws IOException {
		
		menuBebidas = new HashMap<String,Bebida>();
		BufferedReader br = new BufferedReader(new FileReader(archivoBebidas));
		String current;
		
		while ((current = br.readLine()) != null) {
			
			String[] nombrePrecio = current.split(";");
			Bebida bebida = new Bebida(nombrePrecio[0],Integer.parseInt(nombrePrecio[1]),Integer.parseInt(nombrePrecio[2]));
			menuBebidas.put(nombrePrecio[0],bebida);
			
			
	}
	}
	
	private void cargarAcompanamientos(File archivoAcompanamientos) throws IOException {
		
		menuAcompanamientos = new HashMap<String,Acompanamiento>();
		BufferedReader br = new BufferedReader(new FileReader(archivoAcompanamientos));
		String current;
		
		while ((current = br.readLine()) != null) {
			
			String[] nombrePrecio = current.split(";");
			Acompanamiento acompanamiento = new Acompanamiento(nombrePrecio[0],Integer.parseInt(nombrePrecio[1]),Integer.parseInt(nombrePrecio[2]));
			menuAcompanamientos.put(nombrePrecio[0],acompanamiento);
			
	}
	
	}
	private void cargarCombos(File archivoCombos) throws IOException {
		
		combos = new HashMap<String,Combo>();
		BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
		String current;
		
		while ((current = br.readLine()) != null) {
			
			String[] nombreDescuentoProductos = current.split(";");
			nombreDescuentoProductos[1] = nombreDescuentoProductos[1].replace("%","");
			Double descuento = Double.parseDouble(nombreDescuentoProductos[1])/100;
			
			Combo combo = new Combo(nombreDescuentoProductos[0],descuento);
			
			ProductoMenu producto1 = menuBase.get(nombreDescuentoProductos[2]);
			Acompanamiento producto2 = menuAcompanamientos.get(nombreDescuentoProductos[3]);
			Bebida producto3 = menuBebidas.get(nombreDescuentoProductos[4]);
			combo.agregarItemACombo(producto1);
			combo.agregarItemACombo(producto2);
			combo.agregarItemACombo(producto3);
			 
			combos.put(nombreDescuentoProductos[0], combo);
			
		}
		
			
	}
	

}
	
	