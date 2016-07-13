package interware.realexample.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import interware.realexample.Adapters.CategoriesAdapter;
import interware.realexample.R;
import interware.realexample.Realm.CategoriesDao;

public class CategoriesActivity extends AppCompatActivity {

    private ListView lvCategories;
    private CategoriesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        lvCategories = (ListView)findViewById(R.id.lv_categories);
        adapter = new CategoriesAdapter(getApplicationContext());

        loadCategories();
    }

    private void loadCategories(){
        CategoriesDao categoriesDao = new CategoriesDao(getApplicationContext());
        adapter.addAll(categoriesDao.getCategories());
        lvCategories.setAdapter(adapter);
    }
}
