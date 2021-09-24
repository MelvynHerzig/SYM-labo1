package ch.heigvd.iict.sym.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ConnectedActivity : AppCompatActivity() {

    private lateinit var email: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connected)

        // Récupération de l'intention et récupération de la chaîne
        val emailInput = intent.getStringExtra(EXTRA_EMAIL)

        // Récupération du champ et mise à jour.
        email = findViewById(R.id.connected_email_greetings)
        email.setText(emailInput)
    }
}