package interware.retrofitexample.WebServices.Listeners;

/**
 * Created by chelixpreciado on 7/5/16.
 *
 *  Interface que notificara a la vista cuando se han posteado las calificaciones de un alumno
 */
public interface PostScoresRequestListener {

    /** Metodo que notifica si se subieron las calificaciones exitosamente o no
     * @param haveUpdated boolean, true si la subida fue exitosa
     * **/
    public void onScoresUpdated(boolean haveUpdated);

    /** Envia un mensaje de error si la petición no fue exitosa
     * @param errorMsg String mensaje de error
     * **/
    public void onError(String errorMsg);

}
