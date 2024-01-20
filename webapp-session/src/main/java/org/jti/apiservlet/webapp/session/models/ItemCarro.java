package org.jti.apiservlet.webapp.session.models;

import java.util.Objects;

public class ItemCarro {
    private Integer cantidad;
    private Producto producto;

    public ItemCarro() {
    }

    public ItemCarro(Integer cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;}

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getImporte(){
        return cantidad * producto.getPrecio();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarro itemCarro = (ItemCarro) o;
        return Objects.equals(producto.getId(), itemCarro.producto.getId())
                && Objects.equals(producto.getNombre(), itemCarro.producto.getNombre());
    }
}
