package ch.heigvd.iict.sym.labo1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import ch.heigvd.iict.sym.labo1.form.EXTRA_PASSWORD
import ch.heigvd.iict.sym.labo1.form.EXTRA_USERNAME
import ch.heigvd.iict.sym.labo1.form.LoginActivity

// Clé pour le passage de l'adresse mail
const val EXTRA_EMAIL = "email.MESSAGE"

/**
 * Activité exécutée au démarrage de l'application.
 * Permet à l'utilisateur de se connecter avec deux utilisateur
 * prédéfinis dans la classe.
 * @author Berney Alec
 * @author Forestier Quentin
 * @author Herzig Melvyn
 */
class MainActivity : LoginActivity() {

    // Lien clickable pour accéder à la page d'enregistrement.
    private lateinit var signupLink: TextView

    // Utilisateurs prédéfinis. Non réaliste dans une vrai application.
    private val credentials = mutableListOf(
        Pair("user1@heig-vd.ch", "1234"),
        Pair("user2@heig-vd.ch", "abcd")
    )

    // Inscription pour le callback lors que l'activité a un résultat.
    // La fonction lambda passée en paramètre effectuera le traitement de la réponse reçue
    // de l'activité.
    private val getCredentials =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data

                val creds: Pair<String, String> = Pair(
                    data?.getStringExtra(EXTRA_USERNAME).toString(),
                    data?.getStringExtra(EXTRA_PASSWORD).toString()
                )

                credentials.add(creds)
            }
        }

    // Initialise le layout à utiliser lors de la création de l'activité.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Étend le comportement de l'UI en ajoutant un effet au lien pour accéder à la
    // page d'inscription.
    override fun createUIBehaviour() {
        super.createUIBehaviour()

        signupLink = findViewById(R.id.main_new_account)

        signupLink.setOnClickListener {
            val intent = Intent(this, CustomSignupActivity::class.java)
            getCredentials.launch(intent)
        }
    }

    /**
     * Vérifie le couple email et mot de passe dans les credentials.
     */
    override fun isValidLogin(email: String, password: String): Boolean {
        return credentials.contains(Pair(email, password))
    }

    /**
     * Définition de l'action en cas de login validé. Ouverture de connectedActivity.
     */
    override fun onValidLogin() {
        val intent = Intent(this, ConnectedActivity::class.java).apply {
            putExtra(ch.heigvd.iict.sym.labo1.form.EXTRA_EMAIL, email.text?.toString())
        }
        startActivity(intent)
    }

    /**
     * Retourne le tag de l'activité.
     */
    override fun getTag(): String {
        return "MainActivty"
    }
}
