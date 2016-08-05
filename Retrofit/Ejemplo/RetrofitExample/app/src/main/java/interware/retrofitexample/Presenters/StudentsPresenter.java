package interware.retrofitexample.Presenters;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import interware.retrofitexample.Activities.UploadScoresActivity;
import interware.retrofitexample.Adapters.StudentsAdapter;
import interware.retrofitexample.Models.GetStudentsResponse;
import interware.retrofitexample.Models.Student;
import interware.retrofitexample.WebServices.TestRequest;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by chelixpreciado on 8/4/16.
 */
public class StudentsPresenter {

    private ListView lvStudents;
    private StudentsAdapter adapter;
    private TestRequest testRequest;
    private Activity activity;

    public StudentsPresenter (Activity activity, ListView lvStudents){
        this.activity = activity;
        this.lvStudents = lvStudents;
        testRequest = new TestRequest(activity);
    }

    public void loadStudents(int idClassRoom){
        testRequest.showLoader(true);
        testRequest.getTestApi().getRXStudents(idClassRoom)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetStudentsResponse>() {
                    @Override
                    public void onCompleted() {
                        testRequest.showLoader(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GetStudentsResponse getStudentsResponse) {
                        adapter = new StudentsAdapter(activity.getApplicationContext());
                        adapter.addAll(getStudentsResponse.getLista());
                        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Student student = (Student)adapter.getItem(i);
                                Intent intent = new Intent(activity, UploadScoresActivity.class);
                                intent.putExtra("student", student);
                                activity.startActivity(intent);
                            }
                        });
                        lvStudents.setAdapter(adapter);
                    }
                });
    }

}
