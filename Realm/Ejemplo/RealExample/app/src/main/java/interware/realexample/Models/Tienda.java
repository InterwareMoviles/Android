package interware.realexample.Models;

import io.realm.RealmObject;

/**
 * Created by chelixpreciado on 7/8/16.
 */
public class Tienda extends RealmObject {

    private int id;
    private String storeName;
    private String address;
    private String city;

    public Tienda() {
    }

    public Tienda(int id, String storeName, String address, String city) {
        this.id = id;
        this.storeName = storeName;
        this.address = address;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
