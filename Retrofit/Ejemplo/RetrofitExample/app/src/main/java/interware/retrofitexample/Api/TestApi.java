package interware.retrofitexample.Api;

import interware.retrofitexample.Models.GetClassRoomsResponse;
import interware.retrofitexample.Models.GetStudentsResponse;
import interware.retrofitexample.Models.StudentGrades;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by chelixpreciado on 7/4/16.
 */
public interface TestApi {

    /**Interface en la que se agregaran las peticiones a la API usando retrofit**/

    /**
     * Petición get para obtener salones con Rxandroid
     * **/
    @GET("/getClassrooms")
    public Observable<GetClassRoomsResponse> getRXClassRooms();

    /**
     * RXandroid
     * Petición get para obtener los alumnos de un salón, se envia como parametro el id de grupo
     * @param groupId id de grupo
     * **/
    @GET("/getStudents")
    public Observable<GetStudentsResponse> getRXStudents(@Query("grupoId") int groupId);

    /**
     * RXAndroid
     * Petición post para subir calificaciones de alumnos, se envia el nombre del alumno y la calificación por materia
     * **/
    @FormUrlEncoded
    @POST("/subircalificaciones")
    public Observable<StudentGrades> postRXScores(@Field("name") String name,
                                   @Field("matematicas") String calMatematicas,
                                   @Field("espaniol") String calEspaniol,
                                   @Field("biologia") String calBiologia,
                                   @Field("fisica") String calFisica,
                                   @Field("quimica") String calQuimica,
                                   @Field("historia") String calHistoria,
                                   @Field("civica") String calCivica,
                                   @Field("edfisica") String calEdFisica);

}
