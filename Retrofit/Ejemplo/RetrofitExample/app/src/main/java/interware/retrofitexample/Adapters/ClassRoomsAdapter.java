package interware.retrofitexample.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import interware.retrofitexample.Models.ClassGroup;
import interware.retrofitexample.R;
import interware.retrofitexample.ViewHolders.ClassRoomViewHolder;

/**
 * Created by chelixpreciado on 7/5/16.
 */
public class ClassRoomsAdapter extends RecyclerView.Adapter<ClassRoomViewHolder> {

    private ArrayList<ClassGroup> grupos;
    private ClassRoomsAdapterListener listener;

    public ClassRoomsAdapter(ArrayList<ClassGroup> grupos){
        this.grupos = grupos;
    }

    @Override
    public ClassRoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listelement_classroom, parent, false);
        return new ClassRoomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ClassRoomViewHolder holder, int position) {
        final ClassGroup tGroup = grupos.get(position);
        holder.getTxtGroupName().setText(tGroup.getNombre());
        holder.getVgRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null)
                    listener.onGroupSelected(tGroup);
            }
        });
    }

    @Override
    public int getItemCount() {
        return grupos.size();
    }

    public void setListener(ClassRoomsAdapterListener listener) {
        this.listener = listener;
    }

    public interface ClassRoomsAdapterListener{
        public void onGroupSelected(ClassGroup group);
    }
}
