package Modelo;
import java.util.ArrayList;

public class Combo implements Producto {

    private double descuento;
    private String nombreCombo;
    private ArrayList<Producto> productos;
    private int precio;
    private int calorias;

    public Combo (String nombre, double descuento) {
        this.nombreCombo=nombre;
        this.descuento=descuento;
        this.precio=0;
        this.calorias=0;
        this.productos= new ArrayList<Producto>();
        
    }

    public void agregarItemACombo (Producto itemCombo){
    	
        this.precio += itemCombo.getPrecio();
        this.productos.add(itemCombo);
        this.calorias += itemCombo.getCalorias();
    }
    
    public int getPrecio () {
    	
        return (int) (precio * (1-descuento));
    }

    public String generarTextoFactura() {
        for(Producto p : productos){
            //p.getNombre() p.getPrecio(); revisar como arreglar string
        }
    }
    public String getNombre () {
        return nombreCombo;
    }
}
