package Modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
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
	 
	private ArrayList<String> menuBaseMostrar;
	private ArrayList<String> menuBebidasMostrar;
	private ArrayList<String> menuAcompanamientosMostrar;
	private ArrayList<String> combosMostrar;
	private ArrayList<String> ingredientesMostrar;
	
	
	
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
		ingredientesMostrar = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		String current;
		
		while ((current = br.readLine()) != null) {
			
			String[] nombrePrecio = current.split(";");
			Ingrediente ingrediente = new Ingrediente(nombrePrecio[0],Integer.parseInt(nombrePrecio[1]),Integer.parseInt(nombrePrecio[2]));
			ingredientes.put(nombrePrecio[0],ingrediente);
			ingredientesMostrar.add(nombrePrecio[0]);
		}
	}
	
	private void cargarMenu(File archivoMenu) throws IOException {
		
		menuBase = new HashMap<String,ProductoMenu>();
		menuBaseMostrar = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
		String current;
		
		while ((current = br.readLine()) != null) {
			
			String[] nombrePrecio = current.split(";");
			ProductoMenu productoMenu = new ProductoMenu(nombrePrecio[0],Integer.parseInt(nombrePrecio[1]),Integer.parseInt(nombrePrecio[2]));
			menuBase.put(nombrePrecio[0],productoMenu);
			menuBaseMostrar.add(nombrePrecio[0]);
		}
	}
	
	private void cargarBebidas(File archivoBebidas) throws IOException {
		
		menuBebidas = new HashMap<String,Bebida>();
		menuBebidasMostrar = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(archivoBebidas));
		String current;
		
		while ((current = br.readLine()) != null) {
			
			String[] nombrePrecio = current.split(";");
			Bebida bebida = new Bebida(nombrePrecio[0],Integer.parseInt(nombrePrecio[1]),Integer.parseInt(nombrePrecio[2]));
			menuBebidas.put(nombrePrecio[0],bebida);
			menuBebidasMostrar.add(nombrePrecio[0]);
		}
	}
	
	private void cargarAcompanamientos(File archivoAcompanamientos) throws IOException {
		
		menuAcompanamientos = new HashMap<String,Acompanamiento>();
		menuAcompanamientosMostrar = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(archivoAcompanamientos));
		String current;
		
		while ((current = br.readLine()) != null) {
			
			String[] nombrePrecio = current.split(";");
			Acompanamiento acompanamiento = new Acompanamiento(nombrePrecio[0],Integer.parseInt(nombrePrecio[1]),Integer.parseInt(nombrePrecio[2]));
			menuAcompanamientos.put(nombrePrecio[0],acompanamiento);
			menuAcompanamientosMostrar.add(nombrePrecio[0]);
		}
	
	}
	private void cargarCombos(File archivoCombos) throws IOException {
		
		combos = new HashMap<String,Combo>();
		combosMostrar = new ArrayList<String>();
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
			combosMostrar.add(nombreDescuentoProductos[0]);
			
		}			
	}
	
	public void mostrarMenu() {
		
		System.out.println("-----MenuBase-----");
		Iterator<String> m = menuBaseMostrar.iterator();
		while(m.hasNext()){
			String element = m.next();
			int posicion = menuBaseMostrar.indexOf(element);
		    System.out.println(posicion +" "+ element);
		}
		
		System.out.println("-----Combos-----");
		Iterator<String> c = combosMostrar.iterator();
		while(c.hasNext()){
			String element = c.next();
			int posicion = combosMostrar.indexOf(element);
		    System.out.println(posicion +" "+ element);
		}
		
		System.out.println("-----Acompanamientos-----");
		Iterator<String> a = menuAcompanamientosMostrar.iterator();
		while(a.hasNext()){
			String element = a.next();
			int posicion = menuAcompanamientosMostrar.indexOf(element);
		    System.out.println(posicion +" "+ element);
		}
		
		System.out.println("-----Bebidas-----");
		Iterator<String> b = menuBebidasMostrar.iterator();
		while(b.hasNext()){
			String element = b.next();
			int posicion = menuBebidasMostrar.indexOf(element);
		    System.out.println(posicion +" "+ element);
		}
	}
}
	
	