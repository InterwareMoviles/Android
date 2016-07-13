package interware.realexample.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import interware.realexample.Adapters.CategoriesAdapter;
import interware.realexample.Adapters.TiendasAdapter;
import interware.realexample.R;
import interware.realexample.Realm.CategoriesDao;
import interware.realexample.Realm.ProductsDao;
import interware.realexample.Realm.TiendasDao;

public class AddProductActivity extends AppCompatActivity {

    private EditText edNombre, edCosto;
    private Spinner spTiendas, spCategorias;
    private TiendasAdapter tiendasAdapter;
    private CategoriesAdapter categoriesAdapter;

    private TiendasDao tiendasDao;
    private CategoriesDao categoriesDao;
    private ProductsDao productsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        tiendasDao = new TiendasDao(getApplicationContext());
        categoriesDao = new CategoriesDao(getApplicationContext());
        productsDao = new ProductsDao(getApplicationContext());

        edNombre = (EditText)findViewById(R.id.ed_product_name);
        edCosto = (EditText)findViewById(R.id.ed_product_cost);
        spTiendas = (Spinner)findViewById(R.id.sp_tienda);
        spCategorias = (Spinner)findViewById(R.id.sp_categorias);

        tiendasAdapter = new TiendasAdapter(getApplicationContext());
        tiendasAdapter.addAll(tiendasDao.getTiendas());
        spTiendas.setAdapter(tiendasAdapter);

        categoriesAdapter = new CategoriesAdapter(getApplicationContext());
        categoriesAdapter.addAll(categoriesDao.getCategories());
        spCategorias.setAdapter(categoriesAdapter);

    }


}
