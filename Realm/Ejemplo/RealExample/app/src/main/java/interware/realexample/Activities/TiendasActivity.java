package interware.realexample.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import interware.realexample.Adapters.CategoriesAdapter;
import interware.realexample.Adapters.TiendasAdapter;
import interware.realexample.R;
import interware.realexample.Realm.TiendasDao;

public class TiendasActivity extends AppCompatActivity {

    private ListView lvCategories;
    private TiendasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiendas);

        lvCategories = (ListView)findViewById(R.id.lv_categories);
        adapter = new TiendasAdapter(getApplicationContext());

        loadTiendas();
    }

    private void loadTiendas(){
        TiendasDao tiendasDao = new TiendasDao(getApplicationContext());
        adapter.addAll(tiendasDao.getTiendas());
        lvCategories.setAdapter(adapter);
    }
}
