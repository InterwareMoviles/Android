package interware.retrofitexample.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import interware.retrofitexample.R;

/**
 * Created by chelixpreciado on 7/5/16.
 */
public class ClassRoomViewHolder extends RecyclerView.ViewHolder{

    private ViewGroup vgRoot;
    private TextView txtGroupName;

    public ClassRoomViewHolder(View itemView) {
        super(itemView);
    }

    public ViewGroup getVgRoot() {
        if (vgRoot==null)
            vgRoot = (ViewGroup)itemView.findViewById(R.id.vg_root);
        return vgRoot;
    }

    public TextView getTxtGroupName() {
        if (txtGroupName==null)
            txtGroupName = (TextView)itemView.findViewById(R.id.txt_group_name);
        return txtGroupName;
    }
}
