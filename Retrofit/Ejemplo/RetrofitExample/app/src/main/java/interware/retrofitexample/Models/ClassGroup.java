package interware.retrofitexample.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chelixpreciado on 7/4/16.
 */
public class ClassGroup implements Parcelable{

    private int grupo;
    private String nombre;

    public ClassGroup() {
    }

    public ClassGroup(int grupo, String nombre) {
        this.grupo = grupo;
        this.nombre = nombre;
    }

    protected ClassGroup(Parcel in) {
        grupo = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<ClassGroup> CREATOR = new Creator<ClassGroup>() {
        @Override
        public ClassGroup createFromParcel(Parcel in) {
            return new ClassGroup(in);
        }

        @Override
        public ClassGroup[] newArray(int size) {
            return new ClassGroup[size];
        }
    };

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(grupo);
        parcel.writeString(nombre);
    }
}
