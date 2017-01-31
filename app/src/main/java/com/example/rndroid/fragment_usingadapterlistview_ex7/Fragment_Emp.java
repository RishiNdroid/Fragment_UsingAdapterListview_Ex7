package com.example.rndroid.fragment_usingadapterlistview_ex7;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Emp extends Fragment {

EditText editTextEmpNo, editTextEmpName, editTextEmpSal;
    Button buttonAdd;

    public Fragment_Emp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__emp,container,false);
        editTextEmpNo = (EditText) view.findViewById(R.id.empNo);
        editTextEmpName = (EditText) view.findViewById(R.id.empName);
        editTextEmpSal = (EditText) view.findViewById(R.id.empSal);

        buttonAdd = (Button) view.findViewById(R.id.btAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity m = (MainActivity) getActivity();
                m.passData(editTextEmpNo.getText().toString(),editTextEmpName.getText().toString(),editTextEmpSal.getText().toString());
            }
        });
        return view;
    }

}
