package Modelo;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;

public class Restaurante {
	
	// Objects of the other classes
	
	private ArrayList<Pedido> pedidos;
	private static Pedido pedidoEnCurso;
	private ArrayList<ProductoMenu> menuBase;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Combo> combos;
	
	
	
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
	
	public ArrayList<ProductoMenu> getMenuBase(){
		
		return menuBase;
		
	}
	
	public ArrayList<Ingrediente> getIngredientes(){
		
		return ingredientes;
		
	}
	
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws IOException {
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		
	}
	
	private void cargarIngredientes(File archivoIngredientes) throws IOException{
		
		ingredientes = new ArrayList<Ingrediente>();
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		String current;
		
		while ((current = br.readLine()) != null) {
			
			String[] nombrePrecio = current.split(";");
			Ingrediente ingrediente = new Ingrediente(nombrePrecio[0],Integer.parseInt(nombrePrecio[1]));
			ingredientes.add(ingrediente);
			
		}
	}
	
	private void cargarMenu(File archivoMenu) throws IOException {
		
		menuBase = new ArrayList<ProductoMenu>();
		BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
		String current;
		
		while ((current = br.readLine()) != null) {
			
			String[] nombrePrecio = current.split(";");
			ProductoMenu productoMenu = new ProductoMenu(nombrePrecio[0],Integer.parseInt(nombrePrecio[1]));
			menuBase.add(productoMenu);
		}
	}
	
	private void cargarCombos(File archivoCombos) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
		String combo;
		
		while ((combo = br.readLine()) != null) {
			System.out.println(combo);
		}
	}
	
	public void getProductoUno() {
		Producto producto1 = menuBase.get(1);
		
		String nombre = producto1.getNombre();
		
		System.out.println(nombre);
	}
}
	
	