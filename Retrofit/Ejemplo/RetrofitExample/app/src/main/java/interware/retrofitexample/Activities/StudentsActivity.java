package interware.retrofitexample.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import interware.retrofitexample.Adapters.StudentsAdapter;
import interware.retrofitexample.Models.ClassGroup;
import interware.retrofitexample.Models.Student;
import interware.retrofitexample.R;
import interware.retrofitexample.WebServices.Requests.GetStudentsRequest;

public class StudentsActivity extends AppCompatActivity implements GetStudentsRequest.GetStudentsRequestListener {

    private ListView lvStudents;
    private TextView txtGroupName;
    private StudentsAdapter adapter;
    private GetStudentsRequest getStudentsRequest;
    private ClassGroup classGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        txtGroupName = (TextView)findViewById(R.id.txt_group_name);
        lvStudents = (ListView)findViewById(R.id.lv_students);

        classGroup = getIntent().getParcelableExtra("grupo");
        txtGroupName.setText(classGroup.getNombre());
        getStudents();

        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student student = (Student)adapter.getItem(i);
                Intent intent = new Intent(StudentsActivity.this, UploadScoresActivity.class);
                intent.putExtra("student", student);
                startActivity(intent);
            }
        });
    }

    /** Metodo para obtener los estudiantes de un grupo **/
    private void getStudents(){
        if (classGroup!=null){
            getStudentsRequest = new GetStudentsRequest(this, this);
            getStudentsRequest.getStudents(classGroup.getGrupo());
        }
    }

    @Override
    public void onStudentsObtained(ArrayList<Student> students) {
        //Llenamos nuestro adapter de estuduantes al obtener el array de estudiantes
        adapter = new StudentsAdapter(getApplicationContext());
        adapter.addAll(students);
        lvStudents.setAdapter(adapter);
    }

    @Override
    public void onError(String errorMsg) {
        Toast.makeText(getApplicationContext(), errorMsg, Toast.LENGTH_SHORT).show();
    }
}
