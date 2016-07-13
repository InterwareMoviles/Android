package interware.realexample.Realm;

import android.content.Context;

import java.util.ArrayList;

import interware.realexample.Models.Tienda;
import io.realm.RealmResults;

/**
 * Created by chelixpreciado on 7/11/16.
 */
public class TiendasDao extends RealmExample {

    public TiendasDao(Context context) {
        super(context);
    }

    public void insertTienda(Tienda tienda){
        getRealm().beginTransaction();
        getRealm().copyToRealm(tienda);
        getRealm().commitTransaction();
    }

    public ArrayList<Tienda> getTiendas(){
        ArrayList<Tienda> tiendas = new ArrayList<>();
        RealmResults<Tienda> rt = getRealm().where(Tienda.class).findAll();
        tiendas.addAll(rt);
        return tiendas;
    }

    public boolean haveTiendas(){
        return !getTiendas().isEmpty();
    }
}
