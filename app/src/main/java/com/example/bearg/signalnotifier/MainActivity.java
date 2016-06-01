package com.example.bearg.signalnotifier;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.telephony.PhoneStateListener.LISTEN_DATA_CONNECTION_STATE;
import static android.telephony.PhoneStateListener.LISTEN_SIGNAL_STRENGTHS;
import static android.telephony.PhoneStateListener.LISTEN_SERVICE_STATE;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class MainActivity extends AppCompatActivity {

    private SignalChangeListener mSignalChangeListener;
    private TelephonyManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSignalChangeListener = new SignalChangeListener();
        mManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        if (mManager.getNetworkType() == TelephonyManager.NETWORK_TYPE_LTE) {

            mManager.listen(mSignalChangeListener, LISTEN_SIGNAL_STRENGTHS | LISTEN_SERVICE_STATE
                    | LISTEN_DATA_CONNECTION_STATE);
        }

        else {
            mManager.listen(mSignalChangeListener, LISTEN_SERVICE_STATE
                    | LISTEN_DATA_CONNECTION_STATE);
        }
    }
}
