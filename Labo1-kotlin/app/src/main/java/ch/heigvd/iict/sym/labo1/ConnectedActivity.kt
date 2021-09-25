package ch.heigvd.iict.sym.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import ch.heigvd.iict.sym.labo1.network.ImageDownloader

class ConnectedActivity : AppCompatActivity() {

    private lateinit var email: TextView
    private lateinit var profilePicture: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connected)

        // Récupération de l'intention et récupération de la chaîne
        val emailInput = intent.getStringExtra(EXTRA_EMAIL)

        // Récupération du champ TextView et mise à jour.
        email = findViewById(R.id.connected_email_greetings)
        email.setText(emailInput)

        // Récupération de l'image ImageView et mise à jour.
        profilePicture = findViewById(R.id.connected_logo)
        ImageDownloader(profilePicture, "https://thispersondoesnotexist.com/image").show()
    }
}