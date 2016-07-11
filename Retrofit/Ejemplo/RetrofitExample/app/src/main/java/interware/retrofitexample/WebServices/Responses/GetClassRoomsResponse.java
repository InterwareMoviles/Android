package interware.retrofitexample.WebServices.Responses;

import java.util.ArrayList;

import interware.retrofitexample.Models.ClassGroup;

/**
 * Created by chelixpreciado on 7/5/16.
 */
public class GetClassRoomsResponse {

    private ArrayList<ClassGroup> grupos;

    public GetClassRoomsResponse() {}

    public ArrayList<ClassGroup> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<ClassGroup> grupos) {
        this.grupos = grupos;
    }
}
