package com.example.repondeur.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay

class CallReceiver(private val onMissedCall:(String)->Unit):BroadcastReceiver() {
    override fun onReceive(p0: Context?, intent: Intent) {

        if (intent.action == TelephonyManager.ACTION_PHONE_STATE_CHANGED){
            val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
            val incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)

            when(state){
                TelephonyManager.EXTRA_STATE_RINGING->{
                    incomingNumber?.let {
                        CoroutineScope(Dispatchers.IO).launch {
                            kotlinx.coroutines.delay(AUTO_REPONSE_DELAY)
                            if(isCallMissed()){
                              onMissedCall(it)
                            }
                        }
                    }
                }
                TelephonyManager.EXTRA_STATE_IDLE ->{/* reset call state */}
                TelephonyManager.EXTRA_STATE_OFFHOOK ->{/* In call */}
            }
        }

    }
    private  fun isCallMissed(): Boolean{
        // check if call is missed after delay
        return true
    }

    companion object{
        private const val AUTO_REPONSE_DELAY = 5000L

    }
}