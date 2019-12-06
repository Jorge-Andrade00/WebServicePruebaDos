/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.List;
import modelo.SalidaProducto;

/**
 *
 * @author jofas
 */
public interface SkuI {
    public List listarProducto(String sku);
    public void actualizaStock(int cantidadSalida, String sku, int stock);
    public void guardarRegistro(SalidaProducto sp);
    public int verificar(int numeroSalida);
}
