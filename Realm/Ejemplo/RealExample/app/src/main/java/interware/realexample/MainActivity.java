package interware.realexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import interware.realexample.Models.Categoria;
import interware.realexample.Realm.CategoriesDao;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView opProductos, opCategorias, opTiendas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opProductos = (TextView)findViewById(R.id.op_productos);
        opCategorias = (TextView)findViewById(R.id.op_categorias);
        opTiendas = (TextView)findViewById(R.id.op_tiendas);

        opProductos.setOnClickListener(this);
        opCategorias.setOnClickListener(this);
        opTiendas.setOnClickListener(this);

        loadCategories();
    }

    private void loadCategories(){
        CategoriesDao categoriesDao = new CategoriesDao(getApplicationContext());
        if (!categoriesDao.haveCategories()){
            categoriesDao.insertCategory(new Categoria(1, "Linea Blanca"));
            categoriesDao.insertCategory(new Categoria(2, "Computación"));
            categoriesDao.insertCategory(new Categoria(3, "Videojuegos"));
            categoriesDao.insertCategory(new Categoria(4, "Muebles"));
            categoriesDao.insertCategory(new Categoria(5, "Ropa Mujer"));
            categoriesDao.insertCategory(new Categoria(6, "Ropa Caballero"));
            categoriesDao.insertCategory(new Categoria(7, "Celulares"));
        }

        for (Categoria c : categoriesDao.getCategories())
            Log.i("Chelix", "categoria en BD: " + c.getCategoryName());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.op_productos:

                break;
            case R.id.op_categorias:
                startActivity(new Intent(this, CategoriesActivity.class));
                break;
            case R.id.op_tiendas:

                break;
        }
    }
}
