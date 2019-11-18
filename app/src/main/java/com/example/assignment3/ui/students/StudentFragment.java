package com.example.assignment3.ui.students;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.assignment3.R;
import com.example.assignment3.models.Students;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentFragment extends Fragment {
    public static List<Students> studentsList = new ArrayList<>();

    EditText nametxt, agetxt, addresstxt;
    RadioGroup gendergrp;
    String name, age, gender, address;
    int img;
    Button addbtn;


    public StudentFragment() {
        // Required empty public constructor
    }

    View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_student, container, false);
        gender = "";

        nametxt = root.findViewById(R.id.fullname);
        agetxt = root.findViewById(R.id.age);
        gendergrp = root.findViewById(R.id.gender);
        addresstxt = root.findViewById(R.id.address);
        addbtn = root.findViewById(R.id.addbtn);

        gendergrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.male) {
                    gender = "Male";
                    img = R.drawable.male;
                }
                if (checkedId == R.id.female) {
                    gender = "Female";
                    img = R.drawable.female;
                }
                if (checkedId == R.id.others) {
                    gender = "Other";
                    img = R.drawable.other;
                }

            }
        });
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudents();

            }
        });
        return root;


    }

    public void addStudents() {
        name = nametxt.getText().toString();
        age = agetxt.getText().toString();
        address = addresstxt.getText().toString();

        if (validate()) {
            studentsList.add(new Students(name, age, gender, address, img));
            Toast.makeText(root.getContext(), "Student Added", Toast.LENGTH_LONG).show();

        }


    }

    public boolean validate() {
        if (TextUtils.isEmpty(name)) {
            nametxt.requestFocus();
            nametxt.setError("Name cannot be empty");
            return false;
        }
        if (TextUtils.isEmpty(age)) {
            agetxt.requestFocus();
            agetxt.setError("Age cannot be empty");
            return false;

        }
        if (TextUtils.isEmpty(address)) {
            addresstxt.requestFocus();
            addresstxt.setError("Address cannot be empty");
            return false;
        }

        if(gender.equals("")){
            Toast.makeText(root.getContext(), "Select Gender", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;


    }


}
