package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductoAjustado implements Producto{
    private int precio;
    private String nombre;
    private String tipo;
    private ArrayList<Ingrediente> ingredientes;
    
    public ProductoAjustado (ProductoMenu base){
        this.precio=base.getPrecio();
        this.nombre=base.getNombre();
        
    }
    
    public void removerIngrediente (Ingrediente ingredientearemover) {
        //if (this.ingredientes.contains(ingredientearemover)){
           // this.ingredientes.remove(ingredientearemover);
        //}
    }
    public void añadirIngrediente (Ingrediente ingredienteaañadir) {
        //if (tipo != "Bebida" || tipo != "Acompañamiento") {
            //this.ingredientes.add(ingredienteaañadir);
            //int precioNuevo = ingredienteaañadir.getCostoAdicional() + precio;
            //this.setPrecio(precioNuevo);

        }
    }
    public String getNombre() {
        return nombre;
    }
    private int setPrecio(int precioNuevo) {
        this.precio= precioNuevo;
    }
    public int getPrecio() {
        return precio;
    }
    public String generarTextoFactura() {

}