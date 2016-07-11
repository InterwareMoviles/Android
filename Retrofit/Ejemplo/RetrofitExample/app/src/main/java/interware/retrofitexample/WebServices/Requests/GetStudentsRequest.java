package interware.retrofitexample.WebServices.Requests;

import android.app.Activity;

import java.util.ArrayList;

import interware.retrofitexample.Models.Student;
import interware.retrofitexample.WebServices.Responses.GetStudentsResponse;
import interware.retrofitexample.WebServices.TestRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chelixpreciado on 7/5/16.
 */
public class GetStudentsRequest extends TestRequest {

    /** Interface que notificara a la vista cuando se han obtenido los alumnos de un grupo **/
    public GetStudentsRequestListener listener;

    public GetStudentsRequest(Activity activity, GetStudentsRequestListener listener) {
        super(activity);
        this.listener = listener;
    }

    /** Metodo que envia la petición al ws para obtener los alumnos de un grupo
     * @param groupId el id del grupo del cual queremos obtener la lista de alumnos
     * **/
    public void getStudents(int groupId){
        showLoader(true);
        Call<GetStudentsResponse> call = getTestApi().getStudents(groupId);
        call.enqueue(new Callback<GetStudentsResponse>() {
            @Override
            public void onResponse(Call<GetStudentsResponse> call, Response<GetStudentsResponse> response) {
                showLoader(false);
                listener.onStudentsObtained(response.body().getLista());
            }

            @Override
            public void onFailure(Call<GetStudentsResponse> call, Throwable t) {
                showLoader(false);
                listener.onError(t.getMessage());
            }
        });
    }

    /** Interface que notificara a la vista cuando se han obtenido los alumnos de un grupo **/
    public interface GetStudentsRequestListener{
        public void onStudentsObtained(ArrayList<Student> students);

        public void onError(String errorMsg);
    }
}
