package com.example.kush.weathercast;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Ashwani Rao on 26-07-2016.
 */
public class Connection_Detector {
    Context context;
    public Connection_Detector(Context context) {

        this.context= context;
    }
    public boolean isConnected()
    {
        ConnectivityManager connectivity= (ConnectivityManager)context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if(connectivity!= null)
        {
            NetworkInfo info= connectivity.getActiveNetworkInfo();
            if(info!=null)
            {
                if (info.getState()== NetworkInfo.State.CONNECTED){
                    return true;
                }
            }

        }
        return false;
    }
}
