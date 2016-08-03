package interware.retrofitexample.Presenters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import interware.retrofitexample.Adapters.ClassRoomsAdapter;
import interware.retrofitexample.Api.TestApi;
import interware.retrofitexample.WebServices.Responses.GetClassRoomsResponse;
import interware.retrofitexample.WebServices.TestRequest;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by chelixpreciado on 8/2/16.
 */
public class ClassRoomsPresenter {

    private RecyclerView listado;
    private TestRequest testRequest;
    private ClassRoomsAdapter adapter;

    public ClassRoomsPresenter(Activity activity, RecyclerView listado) {
        testRequest = new TestRequest(activity);
        this.listado = listado;
    }

    public void loadClassrooms(){
        testRequest.getTestApi()
                .getRXClassRooms()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetClassRoomsResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GetClassRoomsResponse getClassRoomsResponse) {
                        adapter = new ClassRoomsAdapter(getClassRoomsResponse.getGrupos());
                        listado.setAdapter(adapter);
                    }
                });
    }
}