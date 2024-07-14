package com.vasquez.model;
import lombok.Data;
/**
 * @author Jhonatan Vasquez
 * @version 1.0
 * @since 2024-07-14
 */

@Data
public class Currency {
    private String clave;
    private String nombre;

    @Override
    public String toString() {
        return "Moneda{" +
                "clave='" + clave + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
