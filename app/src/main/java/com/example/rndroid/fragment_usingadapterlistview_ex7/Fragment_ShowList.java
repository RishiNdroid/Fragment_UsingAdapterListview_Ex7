package com.example.rndroid.fragment_usingadapterlistview_ex7;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_ShowList extends Fragment {

    ListView listView;
    ArrayList<Employee> employeeArrayList;
    MyAdapter myAdapter;
    Employee e;

    public  void catchData(String eNo, String eName, String eSal){
        //pass this data to arrayList
        e = new Employee();
        e.setEmpNo(eNo);
        e.setEmpName(eName);
        e.setEmpSal(eSal);
        employeeArrayList.add(e);
        //tell to adapter
        myAdapter.notifyDataSetChanged();
    }
    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return employeeArrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return employeeArrayList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Employee empObj = employeeArrayList.get(i);
            View v = getActivity().getLayoutInflater().inflate(R.layout.row,null);
            TextView tv1 = (TextView) v.findViewById(R.id.text_view_number);
            TextView tv2 = (TextView) v.findViewById(R.id.text_view_name);
            TextView tv3 = (TextView) v.findViewById(R.id.text_view_salary);
            CheckBox checkBox = (CheckBox) v.findViewById(R.id.check_box);

            tv1.setText(empObj.getEmpNo());
            tv2.setText(empObj.getEmpName());
            tv3.setText(empObj.getEmpSal());
            Toast.makeText(getActivity(), ""+empObj.getEmpNo(), Toast.LENGTH_SHORT).show();
            return v;
        }
    }
    public Fragment_ShowList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__show_list, container, false);
            listView = (ListView) view.findViewById(R.id.listView);
            employeeArrayList = new ArrayList<Employee>();
            myAdapter = new MyAdapter();
            listView.setAdapter(myAdapter);
            return view;
    }
}
