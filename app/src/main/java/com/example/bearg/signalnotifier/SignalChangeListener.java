package com.example.bearg.signalnotifier;

import android.content.Context;
import android.telephony.CellSignalStrengthLte;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by bearg on 5/31/2016.
 */
public class SignalChangeListener extends PhoneStateListener {

    private static final String TAG = "SignalChangeListener";

    // used only when connected to an LTE network
    @Override
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {

        super.onSignalStrengthsChanged(signalStrength);

    }

    @Override
    public void onServiceStateChanged(ServiceState serviceState) {

        final int state = serviceState.getState();

        super.onServiceStateChanged(serviceState);
        if (state == ServiceState.STATE_IN_SERVICE) {
            Log.w(TAG, "Voice is now available");
        }

        else if (state == ServiceState.STATE_OUT_OF_SERVICE) {
            Log.w(TAG, "Warning: Voice is no longer available.");
        }

        else if (state == ServiceState.STATE_EMERGENCY_ONLY) {
            Log.w(TAG, "Emergency calls only");
        }

    }

    @Override
    public void onDataConnectionStateChanged(int state) {
        super.onDataConnectionStateChanged(state);

        if (state == TelephonyManager.DATA_CONNECTED) {
            Log.w(TAG, "Data is now available");
        }

        else if (state == TelephonyManager.DATA_DISCONNECTED) {
            Log.w(TAG, "Warning: Data is no longer available");
        }
    }
}
