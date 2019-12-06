/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import DAO.SalidaProductoDAO;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.SalidaProducto;
import modelo.Stock;

/**
 *
 * @author jofas
 */
@WebService(serviceName = "NewWebServiceStock")
public class WebServiceStock {
    SalidaProductoDAO spd = new SalidaProductoDAO();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listaProducto")
    public List<Stock> listaProducto(@WebParam(name = "sku") String sku) {
        List<Stock> datos = spd.listarProducto(sku);
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizaSctock")
    @Oneway
    public void actualizaSctock(@WebParam(name = "cantidadSalida") int cantidadSalida, @WebParam(name = "sku") String sku, @WebParam(name = "stock") int stock) {
        spd.actualizaStock(cantidadSalida, sku, stock);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "guardarRegistro")
    @Oneway
    public void guardarRegistro(@WebParam(name = "sp") SalidaProducto sp) {
        spd.guardarRegistro(sp);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "varificarProducto")
    public int varificarProducto(@WebParam(name = "numeroSalida") int numeroSalida) {
        //TODO write your implementation code here:
        return spd.verificar(numeroSalida);
    }
}
