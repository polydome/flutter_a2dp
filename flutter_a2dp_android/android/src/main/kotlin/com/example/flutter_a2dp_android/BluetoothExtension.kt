package com.example.flutter_a2dp_android

import android.bluetooth.BluetoothDevice
import kotlin.collections.HashMap

fun BluetoothDevice.toMap(): HashMap<String, Any>{
    return hashMapOf(
        "address" to address,
        "name" to name,
        "isConnected" to isConnected,
        "uuids" to uuids.map { it.uuid.toString() }
    )
}

val BluetoothDevice.isConnected: Boolean
    get() = try {
        val method = javaClass.getMethod("isConnected")
        method.invoke(this) as Boolean
    } catch (e: Exception) {
        false
    }
