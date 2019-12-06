/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import config.Conexion;
import interfaz.SkuI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.SalidaProducto;
import modelo.Stock;

/**
 *
 * @author jofas
 */
public class SalidaProductoDAO implements SkuI {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion c = new Conexion();
    
    @Override
    public List listarProducto(String sku) {
        List<Stock> datos = new ArrayList<>();
        String sql = "SELECT * FROM stock WHERE sku = ?";
        try {
            con = c.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, sku);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Stock s = new Stock();
                s.setSku(rs.getString(1));
                s.setCantidad(rs.getInt(2));
                datos.add(s);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return datos;
    }
    
    @Override
    public void actualizaStock(int cantidadSalida, String sku, int stock) {
        stock = stock - cantidadSalida;
        String sql = "UPDATE stock SET cantidad = ? WHERE sku =?";
        try {
            con = c.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setString(2, sku);
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void guardarRegistro(SalidaProducto sp) {
        String sql="INSERT INTO registra_salida (numero_salida, sku, cantidad_salida) VALUES (?,?,?);";
        try {
            con = c.getConexion();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, sp.getNuemroSalida());
            ps.setString(2, sp.getSku());
            ps.setInt(3, sp.getCantidadSalida());
            
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public int verificar(int numeroSalida) {
        int verificador = 0;
        String sql = "SELECT * FROM registra_salida WHERE numero_salida ="+numeroSalida;
        try {
            con = c.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                verificador++;
                return verificador;
            }
        } catch (Exception e) {
            System.out.println(e);
            return verificador =0;
        }
        return verificador;
    }
    
    
}
