package interware.retrofitexample.WebServices.Requests;

import android.app.Activity;
import interware.retrofitexample.WebServices.Listeners.GetClassRoomsRequestListener;
import interware.retrofitexample.WebServices.Responses.GetClassRoomsResponse;
import interware.retrofitexample.WebServices.TestRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chelixpreciado on 7/4/16.
 */
public class GetClassRoomsRequest extends TestRequest {

    /** Interface que notificara a la vista cuando se han obtenido los grupos o ha habido un error en la petición **/
    private GetClassRoomsRequestListener listener;

    public GetClassRoomsRequest(Activity activity, GetClassRoomsRequestListener listener) {
        super(activity);
        this.listener = listener;
    }

    /** Metodo que envia la petición al ws para obtener grupos **/
    public void getGroups(){
        showLoader(true);
        Call<GetClassRoomsResponse> call = getTestApi().getClassRooms();
        call.enqueue(new Callback<GetClassRoomsResponse>() {
            @Override
            public void onResponse(Call<GetClassRoomsResponse> call, Response<GetClassRoomsResponse> response) {
                showLoader(false);
                listener.onGroupsObtained(response.body().getGrupos());
            }

            @Override
            public void onFailure(Call<GetClassRoomsResponse> call, Throwable t) {
                showLoader(false);
                listener.onErrorOnWs(t.getMessage());
            }
        });
    }
}
