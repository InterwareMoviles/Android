package interware.retrofitexample.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import interware.retrofitexample.Models.ClassGroup;
import interware.retrofitexample.Presenters.StudentsPresenter;
import interware.retrofitexample.R;

public class StudentsActivity extends AppCompatActivity {

    private ListView lvStudents;
    private TextView txtGroupName;
    private ClassGroup classGroup;
    private StudentsPresenter studentsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        txtGroupName = (TextView)findViewById(R.id.txt_group_name);
        lvStudents = (ListView)findViewById(R.id.lv_students);

        classGroup = getIntent().getParcelableExtra("grupo");
        txtGroupName.setText(classGroup.getNombre());

        studentsPresenter = new StudentsPresenter(this, lvStudents);
        studentsPresenter.loadStudents(classGroup.getGrupo());
    }
}
