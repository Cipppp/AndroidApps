package com.example.apptimer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.apptimer.util.NotificationUtil
import com.example.apptimer.util.PrefUtil

class TimerNotificationActionReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
       when (intent.action) {
           AppConstants.ACTION_STOP -> {
               MainActivity.removeAlarm(context)
               PrefUtil.setTimerState(MainActivity.TimerState.Stopped, context)
               NotificationUtil.hideTimerNotifaction(context)
           }

           AppConstants.ACTION_PAUSE -> {
               var secondsRemaining = PrefUtil.getSecondsReamining(context)
               val alarmSetTime = PrefUtil.getAlarmSetTime(context)
               val nowSeconds = MainActivity.nowSeconds

               secondsRemaining -= nowSeconds - alarmSetTime
               PrefUtil.setSecondsRemaining(secondsRemaining, context)

               MainActivity.removeAlarm(context)
               PrefUtil.setTimerState(MainActivity.TimerState.Paused, context)
               NotificationUtil.showTimerPaused(context)
           }

           AppConstants.ACTION_RESUME -> {
               val secondsRemaining = PrefUtil.getSecondsReamining(context)
               val wakeUpTime = MainActivity.setAlarm(context, MainActivity.nowSeconds, secondsRemaining)
               PrefUtil.setTimerState(MainActivity.TimerState.Running, context)
               NotificationUtil.showTimerRunning(context, wakeUpTime)
           }

           AppConstants.ACTION_START -> {
               val minutesRemaining = PrefUtil.getTimerLength(context)
               val secondsRemaining = minutesRemaining * 60L
               val wakeUpTime = MainActivity.setAlarm(context, MainActivity.nowSeconds, secondsRemaining)
               PrefUtil.setTimerState(MainActivity.TimerState.Running, context)
               PrefUtil.setSecondsRemaining(secondsRemaining, context)
               NotificationUtil.showTimerRunning(context, wakeUpTime)
           }
       }
    }
}
