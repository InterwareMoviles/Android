package interware.retrofitexample.WebServices.Listeners;

import java.util.ArrayList;

import interware.retrofitexample.Models.ClassGroup;

/**
 * Created by chelixpreciado on 7/5/16.
 * Interface que actua como listener para comunicar a la vista que se han obtenido los grupos o ha habido un error en la petición
 */
public interface GetClassRoomsRequestListener {

    /** Metodo que comunica que se han obtenido los grupos
     * @Return ArrayList<ClassGroup> grupos**/
    public void onGroupsObtained(ArrayList<ClassGroup> groups);

    /** Metodo que comunica que ha habido un error en la petición
     * @Return ArrayList<ClassGroup> grupos**/
    public void onErrorOnWs(String errorMsg);

}
