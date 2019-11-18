package com.example.assignment3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment3.R;
import com.example.assignment3.models.Students;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.StudentsHolder> {
    Context context;
    List<Students> studentsList;

    public RecyclerAdapter( Context context, List<Students> studentsList){
        this.context = context;
        this.studentsList = studentsList;
    }



    @NonNull
    @Override
    public RecyclerAdapter.StudentsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.studentslist, parent, false);
        StudentsHolder holder = new StudentsHolder(view);
        return holder;


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.StudentsHolder holder, final int position) {
        final Students students = studentsList.get(position);

        holder.profileimg.setImageResource(students.getImg());
        holder.nametxt.setText(students.getName());
        holder.agetxt.setText(students.getAge());
        holder.addresstxt.setText(students.getAddress());
        holder.gendertxt.setText(students.getGender());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentsList.remove(students);
                notifyItemRemoved(position);
            }
        });




    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class StudentsHolder extends RecyclerView.ViewHolder {
        ImageView profileimg, delete;
        TextView nametxt, agetxt, gendertxt, addresstxt;



        public StudentsHolder(@NonNull View itemView) {
            super(itemView);

            profileimg = itemView.findViewById(R.id.profileimg);
            delete = itemView.findViewById(R.id.delete);
            nametxt = itemView.findViewById(R.id.nameview);
            agetxt = itemView.findViewById(R.id.ageview);
            gendertxt = itemView.findViewById(R.id.genderview);
            addresstxt = itemView.findViewById(R.id.addressview);

        }
    }
}

