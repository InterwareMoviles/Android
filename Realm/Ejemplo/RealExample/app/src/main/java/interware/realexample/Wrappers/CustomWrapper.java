package interware.realexample.Wrappers;

import android.view.View;
import android.widget.TextView;

import interware.realexample.R;

/**
 * Created by chelixpreciado on 7/11/16.
 */
public class CustomWrapper {

    private View base;
    private TextView txtItemName;

    public CustomWrapper(View base) {
        this.base = base;
    }

    public TextView getTxtItemName() {
        if (txtItemName ==null)
            txtItemName = (TextView)base.findViewById(R.id.txt_item_name);
        return txtItemName;
    }
}
