package interware.realexample.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import interware.realexample.Models.Tienda;
import interware.realexample.R;
import interware.realexample.Wrappers.CustomWrapper;

/**
 * Created by chelixpreciado on 7/12/16.
 */
public class TiendasAdapter extends ArrayAdapter<Tienda> {

    public TiendasAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Tienda tTienda = getItem(position);
        CustomWrapper customWrapper;

        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_category, null);
            customWrapper = new CustomWrapper(convertView);
            convertView.setTag(customWrapper);
        }else{
            customWrapper = (CustomWrapper) convertView.getTag();
        }

        customWrapper.getTxtItemName().setText(tTienda.getStoreName() + '\n' + tTienda.getAddress());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        Tienda tTienda = getItem(position);
        CustomWrapper customWrapper;

        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dropdown_item, null);
            customWrapper = new CustomWrapper(convertView);
            convertView.setTag(customWrapper);
        }else{
            customWrapper = (CustomWrapper) convertView.getTag();
        }

        customWrapper.getTxtItemName().setText(tTienda.getStoreName() + ", " + tTienda.getAddress());
        return convertView;
    }
}
