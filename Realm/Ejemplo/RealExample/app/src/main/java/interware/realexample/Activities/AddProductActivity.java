package interware.realexample.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import interware.realexample.Adapters.CategoriesAdapter;
import interware.realexample.Adapters.TiendasAdapter;
import interware.realexample.Models.Categoria;
import interware.realexample.Models.Producto;
import interware.realexample.Models.Tienda;
import interware.realexample.R;
import interware.realexample.Realm.CategoriesDao;
import interware.realexample.Realm.ProductsDao;
import interware.realexample.Realm.TiendasDao;

public class AddProductActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edNombre, edCosto;
    private Spinner spTiendas, spCategorias;
    private TiendasAdapter tiendasAdapter;
    private CategoriesAdapter categoriesAdapter;
    private Button btnAgregar;

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
        btnAgregar = (Button)findViewById(R.id.btn_agregar);
        btnAgregar.setOnClickListener(this);

        tiendasAdapter = new TiendasAdapter(getApplicationContext());
        tiendasAdapter.addAll(tiendasDao.getTiendas());
        spTiendas.setAdapter(tiendasAdapter);

        categoriesAdapter = new CategoriesAdapter(getApplicationContext());
        categoriesAdapter.addAll(categoriesDao.getCategories());
        spCategorias.setAdapter(categoriesAdapter);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_agregar:
                productsDao.insertProducto(new Producto(productsDao.getNextProductId(), edNombre.getText().toString(),
                        edCosto.getText().toString(), (Categoria)spCategorias.getItemAtPosition(spTiendas.getSelectedItemPosition()),
                        (Tienda)spTiendas.getItemAtPosition(spTiendas.getSelectedItemPosition())));
                Toast.makeText(getApplicationContext(), "Producto Agregado", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
