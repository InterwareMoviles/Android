package interware.retrofitexample.Presenters;

import android.app.Activity;

import interware.retrofitexample.Models.StudentGrades;
import interware.retrofitexample.WebServices.TestRequest;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by chelixpreciado on 8/4/16.
 */
public class UploadScoresPresenter {

    private TestRequest testRequest;
    private Activity activity;

    public UploadScoresPresenter(Activity activity) {
        this.activity = activity;
        testRequest = new TestRequest(activity);
    }

    public void uploadScore(StudentGrades grades){
        testRequest.getTestApi().postRXScores(grades.getNombre(),
                grades.getMatematicas(), grades.getEspañol(), grades.getBiologia(), grades.getFisica(),
                grades.getQuimica(), grades.getHistoria(), grades.getCivica(), grades.getEdfisica())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Observer<? super StudentGrades>) activity);
    }
}
