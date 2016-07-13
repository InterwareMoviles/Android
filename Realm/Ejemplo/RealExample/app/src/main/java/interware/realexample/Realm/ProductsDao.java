package interware.realexample.Realm;

import android.content.Context;

import java.util.ArrayList;

import interware.realexample.Models.Producto;
import interware.realexample.Models.Tienda;
import io.realm.RealmResults;

/**
 * Created by chelixpreciado on 7/12/16.
 */
public class ProductsDao extends RealmExample {

    public ProductsDao(Context context) {
        super(context);
    }

    private void insertProducto(Producto producto){
        getRealm().beginTransaction();
        getRealm().copyToRealm(producto);
        getRealm().commitTransaction();
    }

    private ArrayList<Producto> getProductos(){
        ArrayList<Producto> productos = new ArrayList<>();
        RealmResults<Producto> pr = getRealm().where(Producto.class).findAll();
        productos.addAll(pr);
        return productos;
    }
}
