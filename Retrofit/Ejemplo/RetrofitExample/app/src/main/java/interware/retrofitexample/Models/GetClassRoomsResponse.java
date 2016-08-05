package interware.retrofitexample.Models;

import java.util.ArrayList;

/**
 * Created by chelixpreciado on 8/5/16.
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
