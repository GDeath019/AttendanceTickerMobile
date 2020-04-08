package com.example.attendance.ui.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.AndroidRuntimeException;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.example.attendance.CalendarQuickstart;

import com.example.attendance.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ListView listView;
    private CalendarView cld;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        final ListView listView1 = root.findViewById(R.id.listTB);
        final CalendarView cld = root.findViewById(R.id.Cld);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("new15");
        arrayList.add("new14");
        arrayList.add("new13");
        arrayList.add("new12");
        arrayList.add("new11");
        arrayList.add("new0");
        arrayList.add("new9");
        arrayList.add("new8");
        arrayList.add("new7");
        arrayList.add("new6");
        arrayList.add("new5");
        arrayList.add("new4");
        arrayList.add("new3");
        arrayList.add("new2");
        arrayList.add("new1");
        ArrayAdapter array = new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);

        listView1.setAdapter(array);

        cld.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Toast.makeText(getActivity(), ""+i2, Toast.LENGTH_SHORT).show();
                listView1.setAdapter(null);

                if(i2 == 15){
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add("sk ngày 15");
                    ArrayAdapter array = new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
                    listView1.setAdapter(array);
                }
                if(i2 == 13){
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add("sk ngày 13");
                    ArrayAdapter array = new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
                    listView1.setAdapter(array);
                }
                if(i2 == 20){
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add("sk ngày 20");
                    ArrayAdapter array = new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
                    CalendarQuickstart c= new CalendarQuickstart();
                    arrayList.add(c.tesst());
                    listView1.setAdapter(array);
                }
            }
        });




        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);

            }
        });
        return root;
    }
}