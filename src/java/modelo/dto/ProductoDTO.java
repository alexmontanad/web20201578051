/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;

/**
 *
 * @author Alex
 */
public class ProductoDTO implements Serializable{
    private int id_prod;
    private String nombre_prod;
    private String descripcion_prod;
    private int und;
    private long valor;

    public ProductoDTO() {
    }

    public ProductoDTO(int id_prod, String nombre_prod, String descripcion_prod, int und, long valor) {
        this.id_prod = id_prod;
        this.nombre_prod = nombre_prod;
        this.descripcion_prod = descripcion_prod;
        this.und = und;
        this.valor = valor;
    }

    public ProductoDTO(String nombre_prod, String descripcion_prod, int und, long valor) {
        this.nombre_prod = nombre_prod;
        this.descripcion_prod = descripcion_prod;
        this.und = und;
        this.valor = valor;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public String getDescripcion_prod() {
        return descripcion_prod;
    }

    public void setDescripcion_prod(String descripcion_prod) {
        this.descripcion_prod = descripcion_prod;
    }

    public int getUnd() {
        return und;
    }

    public void setUnd(int und) {
        this.und = und;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return nombre_prod;
    }
    
    
}
