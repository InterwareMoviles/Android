package interware.realexample.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import interware.realexample.Models.Producto;
import interware.realexample.R;
import interware.realexample.Wrappers.ProductWrapper;

/**
 * Created by chelixpreciado on 7/13/16.
 */
public class ProductsAdapter extends ArrayAdapter<Producto> {

    public ProductsAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Producto tProduct = getItem(position);
        ProductWrapper wrapper;

        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_product, null);
            wrapper = new ProductWrapper(convertView);
            convertView.setTag(wrapper);
        }else{
            wrapper = (ProductWrapper)convertView.getTag();
        }

        wrapper.getTxtProductName().setText(tProduct.getName());
        wrapper.getTxtProductCost().setText("$" + tProduct.getPrice());
        wrapper.getTxtProductCategory().setText(tProduct.getCategoria().getCategoryName());

        return convertView;
    }
}
