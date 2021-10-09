package ch.heigvd.iict.sym.labo1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import ch.heigvd.iict.sym.labo1.network.ImageDownloader

/**
 * Activité présenté lorsque l'utilisateur s'est authentifié correctement.
 * @author Berney Alec
 * @author Forestier Quentin
 * @author Herzig Melvyn
 */
class ConnectedActivity : LoggingActivity() {

    // Référence sur le champ email
    private lateinit var email: TextView

    // Référence sur le champ de l'image
    private lateinit var profilePicture: ImageView

    /**
     * Initialise la vue, récupération de l'extra et chargement de l'image.
     */
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

    /**
     * Retourne le tag de l'activité
     */
    override fun getTag(): String {
        return "ConnectedActivity"
    }
}