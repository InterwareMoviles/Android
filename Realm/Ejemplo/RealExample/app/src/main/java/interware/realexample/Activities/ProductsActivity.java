package interware.realexample.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import interware.realexample.Adapters.ProductsAdapter;
import interware.realexample.R;
import interware.realexample.Realm.ProductsDao;

public class ProductsActivity extends AppCompatActivity {

    private ListView lvProducts;
    private ProductsAdapter adapter;
    private ProductsDao productsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        productsDao = new ProductsDao(getApplicationContext());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductsActivity.this, AddProductActivity.class));
            }
        });

        lvProducts = (ListView)findViewById(R.id.lv_productos);
        adapter = new ProductsAdapter(getApplicationContext());
        lvProducts.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.clear();
        adapter.addAll(productsDao.getProductos());
    }
}
