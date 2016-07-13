package interware.realexample.Wrappers;

import android.view.View;
import android.widget.TextView;

import interware.realexample.R;

/**
 * Created by chelixpreciado on 7/13/16.
 */
public class ProductWrapper {

    private View base;
    private TextView txtProductName, txtProductCost, txtProductCategory;

    public ProductWrapper(View base){
        this.base = base;
    }

    public TextView getTxtProductName() {
        if (txtProductName==null)
            txtProductName = (TextView)base.findViewById(R.id.txt_product_name);
        return txtProductName;
    }

    public TextView getTxtProductCost() {
        if (txtProductCost==null)
            txtProductCost = (TextView)base.findViewById(R.id.txt_product_cost);
        return txtProductCost;
    }

    public TextView getTxtProductCategory() {
        if (txtProductCategory==null)
            txtProductCategory = (TextView)base.findViewById(R.id.txt_product_category);
        return txtProductCategory;
    }
}
