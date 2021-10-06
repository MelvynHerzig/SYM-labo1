package ch.heigvd.iict.sym.labo1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class LoggingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(getTag(), "l'acivité a été créée")
    }

    override fun onStart() {
        super.onStart()
        Log.d(getTag(), "l'activité est démarée")
    }

    override fun onResume() {
        super.onResume()
        Log.d(getTag(), "l'activité est en reprise")
    }

    override fun onPause() {
        super.onPause()
        Log.d(getTag(), "l'activité est mise en pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(getTag(), "l'activité est arrêtée")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(getTag(), "l'activité est détruite")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(getTag(), "l'activité est redémarrée")
    }

    protected abstract fun getTag() : String
}