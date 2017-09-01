/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codocodo.entidades;

/**
 *
 * @author DARIAS
 */
public class Pais {
    
    private Integer id;
    private String  nombre;
    private String  iso;

    public Pais(){};
    
    public Pais(Integer id, String nombre, String iso) {
        this.id = id;
        this.nombre = nombre;
        this.iso = iso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    @Override
    public String toString() {
        return "Pais{" + "nombre=" + nombre + ", iso=" + iso + '}';
    }
    
    
    
    
}
