package interware.retrofitexample.Models;

import java.util.ArrayList;

/**
 * Created by chelixpreciado on 8/5/16.
 */
public class GetStudentsResponse {

    private ArrayList<Student> lista;

    public GetStudentsResponse() {
    }

    public ArrayList<Student> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Student> lista) {
        this.lista = lista;
    }

}
