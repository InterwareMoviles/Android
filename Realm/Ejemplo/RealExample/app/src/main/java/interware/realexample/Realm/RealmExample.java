package interware.realexample.Realm;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by chelixpreciado on 7/8/16.
 */
public class RealmExample {

    private Context context;
    private Realm realm;

    public RealmExample(Context context){
        this.context = context;
    }

    private RealmConfiguration getConfiguration(Context context){
        return new RealmConfiguration.Builder(context)
                .name("test.realm")
                .build();
    }

    protected Realm getRealm(){
        if (realm==null)
            realm = Realm.getInstance(getConfiguration(context));
        return realm;
    }

}
