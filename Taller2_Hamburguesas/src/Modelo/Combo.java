package Modelo;
import java.util.ArrayList;

public class Combo  {

    private double descuento;
    private String nombreCombo;
    private ArrayList productos;
    private int precio;

    public Combo (String nombre, double descuento) {
        this.nombreCombo=nombre;
        this.descuento=descuento;
        this.precio=0;
        this.productos= new ArrayList (Producto[] <productos>);
    }

    public void agregarItemACombo (Producto itemCombo){
        this.precio += itemCombo.getPrecio();
        this.productos.add(itemCombo);
    }
    public double getPrecio () {
        return precio * (100-descuento);
    }

    public String generarTextoFactura () {
        for(Producto p : productos){
            //p.getNombre() p.getPrecio(); revisar como arreglar string
        }
    }
    public String getNombre () {
        return nombreCombo;
    }
}
