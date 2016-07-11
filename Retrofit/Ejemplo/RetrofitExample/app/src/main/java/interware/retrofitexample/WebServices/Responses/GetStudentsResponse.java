package interware.retrofitexample.WebServices.Responses;

import java.util.ArrayList;

import interware.retrofitexample.Models.Student;

/**
 * Created by chelixpreciado on 7/5/16.
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
