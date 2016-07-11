package interware.realexample.Realm;

import android.content.Context;

import java.util.ArrayList;

import interware.realexample.Models.Categoria;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by chelixpreciado on 7/11/16.
 */
public class CategoriesDao extends RealmExample {

    public CategoriesDao(Context context) {
        super(context);
    }

    public void insertCategory(final Categoria categoria){
        getRealm().beginTransaction();
        getRealm().copyToRealm(categoria);
        getRealm().commitTransaction();
    }

    public ArrayList<Categoria> getCategories(){
        ArrayList<Categoria> categorias = new ArrayList<>();
        RealmResults<Categoria> realmResults = getRealm().where(Categoria.class).findAll();
        categorias.addAll(realmResults);
        return categorias;
    }

    public boolean haveCategories(){
        return !getCategories().isEmpty();
    }

}
