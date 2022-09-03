package Procesamiento;
import java.io.File;
import Modelo.Restaurante;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;  

public class Aplicacion {
	
	public static void ejecutarAplicacion()
	{
		System.out.println("Pedidos El Corral\n");

		boolean continuar = true;
		while (continuar)
		{
				mostrarMenu();
				Scanner sc= new Scanner(System.in);
				System.out.println("Seleccione una opcion:");
				int opcion_seleccionada = sc.nextInt();  
				
				
				if  (opcion_seleccionada > 6 || opcion_seleccionada < 0)
					System.out.println("Seleccione una opcion valida");	
				
				else if (opcion_seleccionada == 1)
					restaurante.mostrarMenu();
				else if (opcion_seleccionada == 2){
					restaurante.iniciarPedido(null, null);
				}
				else if (opcion_seleccionada == 3)
					System.out.println("Opcion3");
				else if (opcion_seleccionada == 4)
					System.out.println("Opcion4");
				else if (opcion_seleccionada == 5)
					System.out.println("Opcion5");
				else if (opcion_seleccionada == 6) {
					continuar = false;
					System.out.println("Muchas Gracias Por Usar el Sistema");
				}
				
			}
		}
		
	
	public static void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar el menu");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la información de un pedido dado su id");
		System.out.println("6. Cerrar programa");
	}

	
	private static Restaurante restaurante = new Restaurante();
	
	public static void main(String[] args) throws IOException
	{
		File archivoIngredientes = new File("data/ingredientes.txt");
		File archivoMenu = new File("data/menu.txt");
		File archivoCombos = new File("data/combos.txt");
		File archivoBebidas = new File("data/bebidas.txt");
		File archivoAcompanamientos = new File("data/acompanamientos.txt");
		
		
		restaurante.cargarInformacionRestaurante(archivoIngredientes,archivoMenu,archivoCombos,archivoBebidas,archivoAcompanamientos);
		ejecutarAplicacion();
	}
	
	
	
	

}
