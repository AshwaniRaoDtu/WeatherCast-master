package com.example.kush.weathercast;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private boolean checkPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return false;
        }
        return true;
    }

//    View.OnClickListener mOnClickListener;
    Connection_Detector cd;
Button b_check;
    RecyclerView hourlyRecyclerView;
    ArrayList<HourlyWF> data;
    HourlyWVRAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();

      //  b_check= (Button)findViewById(R.id.Button);
        cd=new Connection_Detector(this);
//        b_check.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(cd.isConnected()){
//                    Toast.makeText(MainActivity.this,"Showing Current Location Details",Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(MainActivity.this,"Showing Last Location Details",Toast.LENGTH_SHORT).show();
//
//                }
//
//            }
//            });


        final CoordinatorLayout coordinatorLayout= (CoordinatorLayout)findViewById(R.id.coordinatorLayout);
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "Check your internet connection", Snackbar.LENGTH_LONG)
                .setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(cd.isConnected()){
                            Toast.makeText(MainActivity.this,"Showing Current Location Details",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this,"Showing Last Location Details",Toast.LENGTH_SHORT).show();

                        }

                    }
                });
                snackbar.setActionTextColor(Color.RED);
                View snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(Color.DKGRAY);
        TextView textView= (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.CYAN);
        snackbar.show();





        hourlyRecyclerView = (RecyclerView) findViewById(R.id.hourly_recycler_view);
        data = new ArrayList<>();
        data.add(new HourlyWF("800 m", "80%", "30","20"));
        data.add(new HourlyWF("800 m", "80%", "30","20"));
        data.add(new HourlyWF("800 m", "80%", "30","20"));
        data.add(new HourlyWF("800 m", "80%", "30","20"));
        data.add(new HourlyWF("800 m", "80%", "30","20"));
        data.add(new HourlyWF("800 m", "80%", "30","20"));
        data.add(new HourlyWF("800 m", "80%", "30","20"));
        data.add(new HourlyWF("800 m", "80%", "30","20"));
        data.add(new HourlyWF("800 m", "80%", "30","20"));
        data.add(new HourlyWF("800 m", "80%", "30","20"));
        data.add(new HourlyWF("800 m", "80%", "30","20"));
        data.add(new HourlyWF("800 m", "80%", "30","20"));
        data.add(new HourlyWF("800 m", "80%", "30","20"));

        adapter = new HourlyWVRAdapter(data,this);
        hourlyRecyclerView.setAdapter(adapter);


        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        hourlyRecyclerView.setLayoutManager(lm);
//
//        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT)

    }
}

