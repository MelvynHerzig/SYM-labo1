package ch.heigvd.iict.sym.labo1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * Activité abtraite servant à factorisé le logging du point 5.4 du laboratoire.
 * Effectue un log en fonction des 7 callbacks liés au cycle de vie des activité.
 * Toutes nos activités héritent de cette classe.
 * @author Berney Alec
 * @author Forestier Quentin
 * @author Herzig Melvyn
 */
abstract class LoggingActivity : AppCompatActivity() {

    /**
     * Log la création de l'activité.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(getTag(), "l'activité a été créée")
    }

    /**
     * Log le démarrage de l'activité.
     */
    override fun onStart() {
        super.onStart()
        Log.d(getTag(), "l'activité est démarée")
    }

    /**
     * Log la reprise de l'activité.
     */
    override fun onResume() {
        super.onResume()
        Log.d(getTag(), "l'activité est en reprise")
    }

    /**
     * Log la mise en pause de l'activité
     */
    override fun onPause() {
        super.onPause()
        Log.d(getTag(), "l'activité est mise en pause")
    }

    /**
     * Log l'arrêt de l'activité
     */
    override fun onStop() {
        super.onStop()
        Log.d(getTag(), "l'activité est arrêtée")
    }

    /**
     * Log la destruction de l'activité
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.d(getTag(), "l'activité est détruite")
    }

    /**
     * Log le redémarrage de l'activité
     */
    override fun onRestart() {
        super.onRestart()
        Log.d(getTag(), "l'activité est redémarrée")
    }

    /**
     * Permet de retrouver un tag pour identifier les activités qui effectuent les logs.
     */
    protected abstract fun getTag() : String
}