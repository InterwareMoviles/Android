package interware.retrofitexample.ViewHolders;

import android.view.View;
import android.widget.TextView;

import interware.retrofitexample.R;

/**
 * Created by chelixpreciado on 7/5/16.
 */
public class StudentViewHolder {

    private View base;
    private TextView txtNoList, txtStudentName;

    public StudentViewHolder(View base) {
        this.base = base;
    }

    public TextView getTxtNoList() {
        if (txtNoList==null)
            txtNoList = (TextView)base.findViewById(R.id.txt_nolist);
        return txtNoList;
    }

    public TextView getTxtStudentName() {
        if (txtStudentName==null)
            txtStudentName = (TextView)base.findViewById(R.id.txt_name);
        return txtStudentName;
    }
}
