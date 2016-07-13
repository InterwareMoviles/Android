package interware.realexample.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import interware.realexample.Activities.CategoriesActivity;
import interware.realexample.Models.Categoria;
import interware.realexample.Models.Tienda;
import interware.realexample.R;
import interware.realexample.Realm.CategoriesDao;
import interware.realexample.Realm.TiendasDao;

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
        loadTiendas();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.op_productos:
                startActivity(new Intent(this, AddProductActivity.class));
                break;
            case R.id.op_categorias:
                startActivity(new Intent(this, CategoriesActivity.class));
                break;
            case R.id.op_tiendas:
                startActivity(new Intent(this, TiendasActivity.class));
                break;
        }
    }

    private void loadTiendas(){
        TiendasDao tiendasDao = new TiendasDao(getApplicationContext());
        if (!tiendasDao.haveTiendas()){
            tiendasDao.insertTienda(new Tienda(1, "Liverpool", "Insurgentes Sur 1310", "Benito Juarez"));
            tiendasDao.insertTienda(new Tienda(2, "Sears", "Avenida Universidad 1000", "Benito Juarez"));
            tiendasDao.insertTienda(new Tienda(3, "Walmart", "Calz Ignacio Zaragoza 58", "Venustiano Carranza"));
            tiendasDao.insertTienda(new Tienda(3, "Sears", "Av. Ejército Nacional 980", "Miguel Hidalgo"));
        }
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
    }
}
