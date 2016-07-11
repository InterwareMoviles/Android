package interware.realexample.Wrappers;

import android.view.View;
import android.widget.TextView;

import interware.realexample.R;

/**
 * Created by chelixpreciado on 7/11/16.
 */
public class CategoryWrapper {

    private View base;
    private TextView txtCategoryName;

    public CategoryWrapper(View base) {
        this.base = base;
    }

    public TextView getTxtCategoryName() {
        if (txtCategoryName==null)
            txtCategoryName = (TextView)base.findViewById(R.id.txt_category_name);
        return txtCategoryName;
    }
}
