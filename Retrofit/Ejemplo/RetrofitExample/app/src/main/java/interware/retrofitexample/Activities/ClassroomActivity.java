package interware.retrofitexample.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import interware.retrofitexample.Adapters.ClassRoomsAdapter;
import interware.retrofitexample.Models.ClassGroup;
import interware.retrofitexample.Presenters.ClassRoomsPresenter;
import interware.retrofitexample.R;

public class ClassroomActivity extends AppCompatActivity implements ClassRoomsAdapter.ClassRoomsAdapterListener {

    private RecyclerView rvGroups;
    private ClassRoomsPresenter classRoomsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom);
        rvGroups = (RecyclerView)findViewById(R.id.rv_groups);
        rvGroups.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvGroups.setLayoutManager(layoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        classRoomsPresenter = new ClassRoomsPresenter(this, rvGroups);
        classRoomsPresenter.loadClassrooms();
    }


    @Override
    public void onGroupSelected(ClassGroup group) {
        Log.i("Chelix", "Grupo seleccionado: " + group.getNombre());
        Intent intent = new Intent(this, StudentsActivity.class);
        intent.putExtra("grupo", group);
        startActivity(intent);
    }

    private void startConnectivityManager(){

    }
}
