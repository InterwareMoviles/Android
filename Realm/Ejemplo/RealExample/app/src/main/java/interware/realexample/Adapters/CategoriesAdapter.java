package interware.realexample.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import interware.realexample.Models.Categoria;
import interware.realexample.R;
import interware.realexample.Wrappers.CategoryWrapper;

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
        CategoryWrapper wrapper;

        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_category, null);
            wrapper = new CategoryWrapper(convertView);
            convertView.setTag(wrapper);
        }else{
            wrapper = (CategoryWrapper)convertView.getTag();
        }

        wrapper.getTxtCategoryName().setText(tCategory.getCategoryName());

        return convertView;
    }
}
