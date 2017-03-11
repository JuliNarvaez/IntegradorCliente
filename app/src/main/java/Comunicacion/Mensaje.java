package Comunicacion;

import java.io.Serializable;

/**
 * Created by Usuario on 09/03/2017.
 */

public class Mensaje implements Serializable{

    private String tipo;
    private String nombre, contra;
    static final long seriaLversionUID =42L;

    public Mensaje (String tipo, String nombre, String contra){
        this.tipo = tipo;
        this.nombre = nombre;
        this.contra = contra;
    }
}
