package cubex.mahesh.locationtest_august7am

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     var lManager =    getSystemService(Context.LOCATION_SERVICE)
             as LocationManager
        lManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                1000,1.toFloat(), object : LocationListener {
            override fun onLocationChanged(p0: Location?) {
                        textView.text = p0!!.latitude.toString()
                        textView2.text = p0!!.longitude.toString()
                lManager.removeUpdates(this)
            }

            override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onProviderEnabled(p0: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onProviderDisabled(p0: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
        var count = 0
                    /// Notification Logic....
        button.setOnClickListener({
            var nManager = getSystemService(Context.NOTIFICATION_SERVICE)
                            as NotificationManager
            var nCompact = NotificationCompat.Builder(this@MainActivity,
                    "and7am_aug")
            nCompact.setTicker("Sample Notification for Demo ")
            nCompact.setSmallIcon(R.drawable.ic_beach_access_black_24dp)
            nCompact.setContentTitle("Sample Notification for Demo")
            nCompact.setContentText("This is a notification @ And - 7AM August")
            nCompact.setAutoCancel(true)
            var i = Intent(this@MainActivity,
                                                                MainActivity::class.java)
            var pIntent = PendingIntent.getActivity(
                    this@MainActivity,0,i,0)
            nCompact.setContentIntent(pIntent)
            nManager.notify(++count,nCompact.build())
        })





    }  // onCreate
}
