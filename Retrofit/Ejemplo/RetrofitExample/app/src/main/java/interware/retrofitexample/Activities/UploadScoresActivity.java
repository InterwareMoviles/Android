package interware.retrofitexample.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import interware.retrofitexample.DialogFragments.Loader;
import interware.retrofitexample.Models.Student;
import interware.retrofitexample.Models.StudentGrades;
import interware.retrofitexample.Presenters.UploadScoresPresenter;
import interware.retrofitexample.R;
import rx.Observer;

public class UploadScoresActivity extends AppCompatActivity implements View.OnClickListener, Observer<StudentGrades> {

    private Student student;
    private TextView txtStudentName;
    private EditText edMatematicas, edEspaniol, edBiologia, edFisica, edQuimica, edHistoria, edCivica, edEdFisica;
    private Button btnPostData;
    private UploadScoresPresenter uploadScoresPresenter;
    private Loader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_scores);

        txtStudentName = (TextView)findViewById(R.id.txt_student_name);
        edMatematicas = (EditText)findViewById(R.id.ed_matematicas);
        edEspaniol = (EditText)findViewById(R.id.ed_espaniol);
        edBiologia = (EditText)findViewById(R.id.ed_biologia);
        edFisica = (EditText)findViewById(R.id.ed_fisica);
        edQuimica = (EditText)findViewById(R.id.ed_quimica);
        edHistoria = (EditText)findViewById(R.id.ed_historia);
        edCivica = (EditText)findViewById(R.id.ed_civica);
        edEdFisica = (EditText)findViewById(R.id.ed_edfisica);
        btnPostData = (Button)findViewById(R.id.btn_post_scores);
        btnPostData.setOnClickListener(this);

        student = getIntent().getParcelableExtra("student");

        txtStudentName.setText(student.getNombre() + " " + student.getApellido());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_post_scores:
                if (validateForm())
                    postData();
                break;
        }
    }

    private void postData(){
        showLoader(true);
        uploadScoresPresenter = new UploadScoresPresenter(this);
        uploadScoresPresenter.uploadScore(getStudent());
    }

    @Override
    public void onCompleted() {
        showLoader(false);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(StudentGrades studentGrades) {
        Toast.makeText(getApplicationContext(), "Las calificaciones de " +
                studentGrades.getNombre() + " fueron subidas con exito", Toast.LENGTH_SHORT).show();
    }

    private boolean validateForm(){
        if (TextUtils.isEmpty(edMatematicas.getText().toString()) || !TextUtils.isDigitsOnly(edMatematicas.getText().toString())) {
            edMatematicas.setError("Valores no validos");
            return false;
        }
        if (TextUtils.isEmpty(edEspaniol.getText().toString()) || !TextUtils.isDigitsOnly(edEspaniol.getText().toString())) {
            edEspaniol.setError("Valores no validos");
            return false;
        }
        if (TextUtils.isEmpty(edBiologia.getText().toString()) || !TextUtils.isDigitsOnly(edBiologia.getText().toString())) {
            edBiologia.setError("Valores no validos");
            return false;
        }
        if (TextUtils.isEmpty(edFisica.getText().toString()) || !TextUtils.isDigitsOnly(edFisica.getText().toString())) {
            edFisica.setError("Valores no validos");
            return false;
        }
        if (TextUtils.isEmpty(edQuimica.getText().toString()) || !TextUtils.isDigitsOnly(edQuimica.getText().toString())) {
            edQuimica.setError("Valores no validos");
            return false;
        }
        if (TextUtils.isEmpty(edHistoria.getText().toString()) || !TextUtils.isDigitsOnly(edHistoria.getText().toString())) {
            edHistoria.setError("Valores no validos");
            return false;
        }
        if (TextUtils.isEmpty(edCivica.getText().toString()) || !TextUtils.isDigitsOnly(edCivica.getText().toString())) {
            edCivica.setError("Valores no validos");
            return false;
        }
        if (TextUtils.isEmpty(edEdFisica.getText().toString()) || !TextUtils.isDigitsOnly(edEdFisica.getText().toString())) {
            edEdFisica.setError("Valores no validos");
            return false;
        }
        return true;
    }

    private StudentGrades getStudent(){
        StudentGrades studentGrades = new StudentGrades();
        studentGrades.setNombre(student.getNombre());
        studentGrades.setMatematicas(edMatematicas.getText().toString().trim());
        studentGrades.setEspañol(edEspaniol.getText().toString().trim());
        studentGrades.setBiologia(edBiologia.getText().toString().trim());
        studentGrades.setFisica(edFisica.getText().toString().trim());
        studentGrades.setQuimica(edQuimica.getText().toString().trim());
        studentGrades.setHistoria(edHistoria.getText().toString().trim());
        studentGrades.setCivica(edCivica.getText().toString().trim());
        studentGrades.setEdfisica(edEdFisica.getText().toString().trim());
        return  studentGrades;
    }

    /** Regresa un dialog que usamos como loader **/
    public Loader getLoader(){
        if (loader==null)
            loader = Loader.newInstance();
        return loader;
    }

    /** Muestra u oculta el loader **/
    public void showLoader(boolean shouldShow){
        if (shouldShow){
            getLoader().show(this.getFragmentManager(), "Loader");
        }else{
            getLoader().dismiss();
        }
    }
}
