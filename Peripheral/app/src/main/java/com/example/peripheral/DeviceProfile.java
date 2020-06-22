package com.example.peripheral;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothProfile;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class DeviceProfile {
    public static UUID SERVICE_UUID = UUID.fromString("48B31700-7796-47A6-90B1-3D749FBD520A");
    //Read-only characteristic providing number of elapsed seconds since offset
    public static UUID CHARACTERISTIC_ELAPSED_UUID = UUID.fromString("355C6E21-51C5-46C3-B160-30A2598842EB"); //Elapsed
    //Read-write characteristic for current offset timestamp
    public static UUID CHARACTERISTIC_OFFSET_UUID = UUID.fromString("DF6F5A5F-A202-4289-B170-7122F85D8D4F");
    public static String getStateDescription(int state) {
        switch (state) {
            case BluetoothProfile.STATE_CONNECTED:
                return "Connected";
            case BluetoothProfile.STATE_CONNECTING:
                return "Connecting";
            case BluetoothProfile.STATE_DISCONNECTED:
                return "Disconnected";
            case BluetoothProfile.STATE_DISCONNECTING:
                return "Disconnecting";
            default:
                return "Unknown State "+state;
        }
    }

    public static String getStatusDescription(int status) {
        switch (status) {
            case BluetoothGatt.GATT_SUCCESS:
                return "SUCCESS";
            default:
                return "Unknown Status "+status;
        }
    }

    public static byte[] getShiftedTimeValue(int timeOffset) {
        int value = 100;
        return bytesFromInt(value);
    }

    public static int unsignedIntFromBytes(byte[] raw) {
        if (raw.length < 4) throw new IllegalArgumentException("Cannot convert raw data to int");

        return ((raw[0] & 0xFF)
                + ((raw[1] & 0xFF) << 8)
                + ((raw[2] & 0xFF) << 16)
                + ((raw[3] & 0xFF) << 24));
    }

    public static byte[] bytesFromInt(int value) {
        //Convert result into raw bytes. GATT APIs expect LE order
        return ByteBuffer.allocate(4)
                .order(ByteOrder.LITTLE_ENDIAN)
                .putInt(value)
                .array();
    }
}
