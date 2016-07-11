package interware.realexample.Models;

import io.realm.RealmObject;

/**
 * Created by chelixpreciado on 7/8/16.
 */
public class Producto extends RealmObject {

    private int id;
    private String name;
    private String price;
    private Categoria categoria;
    private Tienda tienda;

    public Producto() {
    }

    public Producto(int id, String name, String price, Categoria categoria, Tienda tienda) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoria = categoria;
        this.tienda = tienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
