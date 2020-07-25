package com.example.apptimer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.apptimer.util.NotificationUtil
import com.example.apptimer.util.PrefUtil

class TimerExpiredReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        NotificationUtil.showTimerExpired(context)

        PrefUtil.setTimerState(MainActivity.TimerState.Stopped, context)
        PrefUtil.setAlarmSetTime(0, context)
    }
}
