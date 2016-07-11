package interware.retrofitexample.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chelixpreciado on 7/5/16.
 */
public class Student implements Parcelable{

    int nolista;
    String nombre;
    String apellido;

    public Student(){}

    protected Student(Parcel in) {
        nolista = in.readInt();
        nombre = in.readString();
        apellido = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public int getNolista() {
        return nolista;
    }

    public void setNolista(int nolista) {
        this.nolista = nolista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(nolista);
        parcel.writeString(nombre);
        parcel.writeString(apellido);
    }
}
