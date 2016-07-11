package interware.retrofitexample.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import interware.retrofitexample.Models.Student;
import interware.retrofitexample.R;
import interware.retrofitexample.ViewHolders.StudentViewHolder;

/**
 * Created by chelixpreciado on 7/5/16.
 */
public class StudentsAdapter extends ArrayAdapter<Student> {

    public StudentsAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student tStudent = getItem(position);
        StudentViewHolder holder;

        if (convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listelement_student, null);
            holder = new StudentViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (StudentViewHolder)convertView.getTag();
        }

        holder.getTxtNoList().setText(String.valueOf(tStudent.getNolista()));
        holder.getTxtStudentName().setText(tStudent.getNombre() + " " + tStudent.getApellido());

        return convertView;
    }
}
