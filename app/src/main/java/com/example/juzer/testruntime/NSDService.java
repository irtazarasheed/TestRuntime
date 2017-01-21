package com.example.juzer.testruntime;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Juzer on 1/21/2017.
 */

public class NSDService {
    NsdManager.RegistrationListener mRegistrationListener = null;
    NsdManager mNsdManager;

    public void registerService(Context context,int port){
        NsdServiceInfo serviceInfo=new NsdServiceInfo();
        serviceInfo.setServiceName("SMP");
        serviceInfo.setServiceType("_http._tcp.");
        serviceInfo.setPort(port);

        mNsdManager = (NsdManager) context.getSystemService(Context.NSD_SERVICE);
        mNsdManager.registerService(serviceInfo,NsdManager.PROTOCOL_DNS_SD,mRegistrationListener);

    }

}
