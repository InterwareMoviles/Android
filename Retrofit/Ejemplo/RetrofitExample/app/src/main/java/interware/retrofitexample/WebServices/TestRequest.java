package interware.retrofitexample.WebServices;

import android.app.Activity;

import interware.retrofitexample.Api.TestApi;
import interware.retrofitexample.DialogFragments.Loader;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chelixpreciado on 7/4/16.
 */
public class TestRequest {

    /**
     *  {@Link String} baseUrl es la base host de la api que vayamos a consumir
     *  retrofit es la una instancia de la clase Retrofit
     *  TestApi es la interface de los metodos de la API
     *  **/
    private static final String baseUrl = "http://54.200.40.169:8081";
    private Activity activity;
    private Retrofit retrofit;
    private TestApi mApi;
    private Loader loader;

    public TestRequest(Activity activity) {
        this.activity = activity;
    }

    /**
     * @Return Retrofit, regresa una instancia de retrofit, con la base url, y GsonConverterFactory libreria que parsea json de response en la peticiones
     * **/
    protected Retrofit getRetrofitInstance(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

    /** @Return regresa una instancia de retrofit. **/
    protected TestApi getTestApi(){
        if (mApi==null)
            mApi = getRetrofitInstance().create(TestApi.class);
        return mApi;
    }

    /** Regresa un dialog que usamos como loader **/
    protected Loader getLoader(){
        if (loader==null)
            loader = Loader.newInstance();
        return loader;
    }

    /** Muestra u oculta el loader **/
    protected void showLoader(boolean shouldShow){
        if (shouldShow){
            getLoader().show(activity.getFragmentManager(), "Loader");
        }else{
            getLoader().dismiss();
        }
    }
}
