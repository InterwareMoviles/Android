package interware.retrofitexample.WebServices.Requests;

import android.app.Activity;
import android.widget.Toast;

import interware.retrofitexample.Models.StudentGrades;
import interware.retrofitexample.WebServices.Listeners.PostScoresRequestListener;
import interware.retrofitexample.WebServices.TestRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chelixpreciado on 7/5/16.
 */
public class PostScoresRequest extends TestRequest {

    /** Interface que notificara a la vista cuando se han subido las calificaciones **/
    private PostScoresRequestListener listener;

    public PostScoresRequest(Activity activity, PostScoresRequestListener listener) {
        super(activity);
        this.listener = listener;
    }

    /** Metodo que envia las calificaciones de un alumno
     * @param grades Objeto que contiene el nombre del alumno y sus calificaciones.
     * **/
    public  void  postGrades(StudentGrades grades){
        showLoader(true);
        Call<StudentGrades> call = getTestApi().postScores(grades.getNombre(),
                grades.getMatematicas(), grades.getEspañol(), grades.getBiologia(), grades.getFisica(),
                grades.getQuimica(), grades.getHistoria(), grades.getCivica(), grades.getEdfisica());
        call.enqueue(new Callback<StudentGrades>() {
            @Override
            public void onResponse(Call<StudentGrades> call, Response<StudentGrades> response) {
                showLoader(false);
                if (response.body()!=null)
                    listener.onScoresUpdated(true);
                else
                    listener.onScoresUpdated(false);
            }

            @Override
            public void onFailure(Call<StudentGrades> call, Throwable t) {
                showLoader(false);
                listener.onError(t.getMessage());
            }
        });
    }

}
