package com.example.rent_a_boat

import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.rent_a_boat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sendFakeNotification()
    }

    @TargetApi(Build.VERSION_CODES.ECLAIR)
    private fun sendFakeNotification() {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel("channel0", localClassName, importance)
        notificationManager.createNotificationChannel(channel)

        val args = BoatFragmentArgs.fromBundle(Bundle(3)).toBundle()
        val pendingIntent = NavDeepLinkBuilder(applicationContext)
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.boatFragment)
            .setArguments(args)
            .createPendingIntent()

        val notification = Notification.Builder(applicationContext, "Notification Reminder")
            .setContentText("Now on Sale!")
            .setAutoCancel(true)
            .setSmallIcon(R.drawable.speed_boat_blue)
            .setContentIntent(pendingIntent)

        notification.setChannelId("channel0")
        notificationManager.notify(0, notification.build())
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_ContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}