package com.example.rndroid.fragment_usingadapterlistview_ex7;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void passData(String empNo, String empName, String empSal){

        FragmentManager fm = getSupportFragmentManager();
        Fragment_ShowList fragment_showList = (Fragment_ShowList) fm.findFragmentByTag("FRAG_2_TAG");
        fragment_showList.catchData(empNo, empName, empSal);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment_Emp fragment_emp = new Fragment_Emp();
        Fragment_ShowList fragment_showList = new Fragment_ShowList();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container1,fragment_emp);
        ft.replace(R.id.container2,fragment_showList, "FRAG_2_TAG");// Last parameter id TAG,
        //Tag is used to re-retrieve a fragment at later fragment time
        ft.commit();
    }
}
