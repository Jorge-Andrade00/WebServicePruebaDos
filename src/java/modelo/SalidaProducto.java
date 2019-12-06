/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jofas
 */
public class SalidaProducto {

    private int nuemroSalida;
    private String sku;
    private int cantidadSalida;

    public SalidaProducto() {
    }

    public SalidaProducto(int nuemroSalida, String sku, int cantidadSalida) {
        this.nuemroSalida = nuemroSalida;
        this.sku = sku;
        this.cantidadSalida = cantidadSalida;
    }

    public int getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(int cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public int getNuemroSalida() {
        return nuemroSalida;
    }

    public void setNuemroSalida(int nuemroSalida) {
        this.nuemroSalida = nuemroSalida;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

}
