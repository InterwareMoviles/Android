package interware.realexample.Models;

import io.realm.RealmObject;

/**
 * Created by chelixpreciado on 7/8/16.
 */
public class Categoria extends RealmObject{

    private int categoryId;
    private String categoryName;

    public Categoria() {
    }

    public Categoria(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
