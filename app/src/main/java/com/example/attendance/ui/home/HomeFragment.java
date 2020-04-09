package com.example.attendance.ui.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendance.CalendarQuickstart;

import com.example.attendance.DataShop;
import com.example.attendance.R;
import com.example.attendance.ShopAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView listView;
    private CalendarView cld;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        final RecyclerView recyclerView = root.findViewById(R.id.listTB);
        final CalendarView cld = root.findViewById(R.id.Cld);
        // Bắt đầu đưa dữ liệu vào
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL,false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getActivity(),R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        cld.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Toast.makeText(getActivity(), ""+i2, Toast.LENGTH_SHORT).show();
                recyclerView.setAdapter(null);

                if(i2 == 15){
                    ArrayList<DataShop> arrayList = new ArrayList<>();
                    arrayList.add(new DataShop("sk ngày 15","sk ngày 15","sk ngày 15"));
                    arrayList.add(new DataShop("sk ngày 15 1","sk ngày 15 1","sk ngày 15 1"));
                    arrayList.add(new DataShop("sk ngày 15 2","sk ngày 15 2","sk ngày 15 2"));
                    arrayList.add(new DataShop("sk ngày 15 3","sk ngày 15 3","sk ngày 15 3"));
                    ShopAdapter shopAdapter = new ShopAdapter(arrayList,getActivity());
                    recyclerView.setAdapter(shopAdapter);
                }
                if(i2 == 13){
                    ArrayList<DataShop> arrayList = new ArrayList<>();
                    arrayList.add(new DataShop("sk ngày 13","sk ngày 13","sk ngày 13"));
                    ShopAdapter shopAdapter = new ShopAdapter(arrayList,getActivity());
                    recyclerView.setAdapter(shopAdapter);
                }
                if(i2 == 20){
                    ArrayList<DataShop> arrayList = new ArrayList<>();
                    arrayList.add(new DataShop("sk ngày 20","sk ngày 20","sk ngày 20"));
                    ShopAdapter shopAdapter = new ShopAdapter(arrayList,getActivity());
                    recyclerView.setAdapter(shopAdapter);
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