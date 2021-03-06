package interware.realexample.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import interware.realexample.Models.Categoria;
import interware.realexample.Models.Tienda;
import interware.realexample.R;
import interware.realexample.Wrappers.CustomWrapper;

/**
 * Created by chelixpreciado on 7/11/16.
 */
public class CategoriesAdapter extends ArrayAdapter<Categoria> {

    public CategoriesAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Categoria tCategory = getItem(position);
        CustomWrapper wrapper;

        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_category, null);
            wrapper = new CustomWrapper(convertView);
            convertView.setTag(wrapper);
        }else{
            wrapper = (CustomWrapper)convertView.getTag();
        }

        wrapper.getTxtItemName().setText(tCategory.getCategoryName());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        Categoria tCategory = getItem(position);
        CustomWrapper wrapper;

        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dropdown_item, null);
            wrapper = new CustomWrapper(convertView);
            convertView.setTag(wrapper);
        }else{
            wrapper = (CustomWrapper)convertView.getTag();
        }

        wrapper.getTxtItemName().setText(tCategory.getCategoryName());

        return convertView;
    }
}
