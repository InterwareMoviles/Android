package interware.retrofitexample.Api;

import java.util.ArrayList;

import interware.retrofitexample.Models.ClassGroup;
import interware.retrofitexample.Models.StudentGrades;
import interware.retrofitexample.WebServices.Responses.GetClassRoomsResponse;
import interware.retrofitexample.WebServices.Responses.GetStudentsResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by chelixpreciado on 7/4/16.
 */
public interface TestApi {

    /**Interface en la que se agregaran las peticiones a la API usando retrofit**/

    /**
     * Petición get para obtener los salones
     * **/
    @GET("/getClassrooms")
    Call<GetClassRoomsResponse> getClassRooms();

    /**
     * Petición get para obtener los alumnos de un salón, se envia como parametro el id de grupo
     * @param groupId id de grupo
     * **/
    @GET("/getStudents")
    Call<GetStudentsResponse> getStudents(@Query("grupoId") int groupId);

    /**
     * Petición post para subir calificaciones de alumnos, se envia el nombre del alumno y la calificación por materia
     * **/
    @FormUrlEncoded
    @POST("/subircalificaciones")
    Call<StudentGrades> postScores(@Field("name") String name,
                                   @Field("matematicas") String calMatematicas,
                                   @Field("espaniol") String calEspaniol,
                                   @Field("biologia") String calBiologia,
                                   @Field("fisica") String calFisica,
                                   @Field("quimica") String calQuimica,
                                   @Field("historia") String calHistoria,
                                   @Field("civica") String calCivica,
                                   @Field("edfisica") String calEdFisica);

}
