package com.example.jb.myapplication.model;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by jb on 02/12/2018.
 */

public class ConnectionDetector {
    Context context;

    public ConnectionDetector(Context context) {
        this.context = context;
    }
    public boolean isConnected(){
        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if(connectivityManager != null)
        {
            NetworkInfo info=connectivityManager.getActiveNetworkInfo();
            if (info!=null){
                if(info.getState()== NetworkInfo.State.CONNECTED)
                {return true;}
            }
        }return false;
    }
}
