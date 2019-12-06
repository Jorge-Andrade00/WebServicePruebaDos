/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.SalidaProductoDAO;
import config.Conexion;
import java.util.ArrayList;
import java.util.List;
import modelo.SalidaProducto;
import modelo.Stock;

/**
 *
 * @author jofas
 */
public class Test {
    public static void main(String[] args) {
        //Conexion c = new Conexion();
        //c.getConexion();
        
        SalidaProductoDAO spd = new SalidaProductoDAO();
        List<Stock> datos =  spd.listarProducto("455");
        for (int i = 0; i < datos.size(); i++) {
            Stock s = new Stock();
            s = datos.get(i);
            spd.actualizaStock(5, "455", s.getCantidad());
        }
        //SalidaProducto sp = new SalidaProducto(7377, "123", 5);
        //spd.guardarRegistro(sp);
        //System.out.println(spd.verificar(12243));
    }
}
