/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexion.ConexionMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.ProductoDTO;
import modelo.interfaces.Obligacion;

/**
 *
 * @author Alex
 */
public class ProductoDAO implements Obligacion <ProductoDTO>{

   
    private static final String SQL_CREATE = "INSERT INTO tb_producto (nombre_producto, descripcion_producto, unidades, valor ) VALUES(?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM tb_producto WHERE id_producto = ?";
    private static final String SQL_UPDATE = "UPDATE tb_producto SET nombre_producto = ?, descripcion_producto = ?, unidades = ?, valor = ? WHERE id_producto = ? ";
    private static final String SQL_READ = "SELECT * FROM tb_producto WHERE id_producto";
    private static final String SQL_READALL = "SELECT * FROM tb_producto";
    
    private static final ConexionMySQL con = ConexionMySQL.getInstace();
    
    @Override
    public boolean create(ProductoDTO nuevo) {
        try {
            PreparedStatement ps;
            ps = con.getCnn().prepareStatement(SQL_CREATE);
            ps.setString(1, nuevo.getNombre_prod());
            ps.setString(2, nuevo.getDescripcion_prod());
            ps.setInt(3, nuevo.getUnd());
            ps.setInt(4, (int) nuevo.getValor());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al crear producto: " + ex.getMessage());
        }finally{
        con.CerrarConexion();
        }
        return false;
    }

    @Override
    public List<ProductoDTO> readAll() {
        List<ProductoDTO> lista = null;
        PreparedStatement ps;
        try{
            ps = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while(rs.next()){
                ProductoDTO obj = new ProductoDTO(
                rs.getInt("id_producto"),
                rs.getString("nombre_producto"),
                rs.getString("descripcion_producto"),
                rs.getInt("unidades"),
                rs.getLong("valor"));
            lista.add(obj);
            }
        }catch(SQLException ex){
            System.out.println("Error en consulta readAll" + ex.getMessage());
        }finally{
            con.CerrarConexion();
        }
        return lista;
    }

    @Override
    public ProductoDTO read(ProductoDTO filtro) {
        ProductoDTO objRes = null;
        PreparedStatement psnt;
        try{
            psnt = con.getCnn().prepareStatement(SQL_READ);
            psnt.setInt(1, filtro.getId_prod());
            ResultSet rs = psnt.executeQuery();
            if(rs.next()){
                objRes = new ProductoDTO(
                rs.getInt("id_producto"),
                rs.getString("nombre_producto"),
                rs.getString("descripcion_producto"),
                rs.getInt("unidades"),
                rs.getLong("valor"));
            }
        }catch(SQLException ex){
            System.out.println("Error en consulta read" + ex.getMessage());
        }finally{
            con.CerrarConexion();
        }
        return objRes;
    }

    @Override
    public boolean update(ProductoDTO item) {
        PreparedStatement ps;
        try{
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, item.getNombre_prod());
            ps.setString(1, item.getDescripcion_prod());
            ps.setInt(3, item.getUnd());
            ps.setLong(4, item.getValor());
            ps.setInt(5, item.getId_prod());
            if (ps.executeUpdate() > 0){
                return true;
            }
        }catch(SQLException ex){
            System.out.println("Error al actualizar productoDTO " + ex.getMessage());
        }finally{
            con.CerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(ProductoDTO item) {
        PreparedStatement ps;
        try{
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getId_prod());
            if (ps.executeUpdate() > 0){
                return true;
            }
        }catch(SQLException ex){
            System.out.println("Error al borrar producto " + ex.getMessage());
        }finally{
            con.CerrarConexion();
        }
        return false;
    }
    
}
