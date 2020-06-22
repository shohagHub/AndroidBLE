package com.example.peripheral;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Intent;
import android.util.Log;

public class PeriPheral {

    private String TAG = "Peripheral";

    private BluetoothManager mBluetoothManager;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeAdvertiser mBluetoothLeAdvertiser;
    private BluetoothGattServer mGattServer;

//    public  void init() {
//
//
//        /*
//         * Check for advertising support. Not all devices are enabled to advertise
//         * Bluetooth LE data.
//         */
//        if (!mBluetoothAdapter.isMultipleAdvertisementSupported()) {
//            Toast.makeText(this, "No Advertising Support.", Toast.LENGTH_SHORT).show();
//            finish();
//            return;
//        }
//
//        mBluetoothLeAdvertiser = mBluetoothAdapter.getBluetoothLeAdvertiser();
//        mGattServer = mBluetoothManager.openGattServer(this, mGattServerCallback);
//
//        initServer();
//        startAdvertising();
//    }


}
