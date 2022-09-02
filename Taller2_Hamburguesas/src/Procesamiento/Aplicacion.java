package Procesamiento;
import java.io.File;
import Modelo.Restaurante;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Aplicacion {
	
	public static void ejecutarAplicacion()
	{
		System.out.println("Pedidos El Corral\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				System.out.println("Seleccione una opcion:");
				int opcion_seleccionada = Integer.parseInt(System.console().readLine());
				
				if (opcion_seleccionada <= 0 || opcion_seleccionada > 5)	
				System.out.println("Ingrese una opcion valida");
				mostrarMenu()
				
				else if (opcion_seleccionada == 1)
					
				else if (opcion_seleccionada == 2)
					
				else if (opcion_seleccionada == 3)
					
				else if (opcion_seleccionada == 4)
					
				else if (opcion_seleccionada == 5)
					
				else if (opcion_seleccionada != )
					
				// falta investigar como hacer un input
					
			}
		}
		
	}
	
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar el menú");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la información de un pedido dado su id");
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
		//ejecutarAplicacion();
	}
	
	
	
	

}
