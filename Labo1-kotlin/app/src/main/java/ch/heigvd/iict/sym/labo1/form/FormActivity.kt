package ch.heigvd.iict.sym.labo1.form

import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import ch.heigvd.iict.sym.labo1.LoggingActivity
import ch.heigvd.iict.sym.labo1.R

// Clé pour le passage de l'adresse mail
const val EXTRA_EMAIL = "email.MESSAGE"

/**
 * Activité abstraite lié à l'inscription / connexion.
 * @author Berney Alec
 * @author Forestier Quentin
 * @author Herzig Melvyn
 */
abstract class FormActivity : LoggingActivity() {

    // Référence sur le champ email.
    protected lateinit var email: EditText

    // Référence sur le champ password.
    protected lateinit var password: EditText

    // Référence sur le bouton d'annulation.
    protected lateinit var cancelButton: Button

    // Référence sur le bouton valider.
    protected lateinit var validateButton: Button


    // Initialise la vue et ajoute le comportement de l'IU.
    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        createUIBehaviour()
    }

    /**
     * Liaison des éléments graphiques et création des listener.
     */
    open fun createUIBehaviour() {

        // Liaison des éléments graphiques
        email = findViewById(R.id.log_email)
        password = findViewById(R.id.log_password)
        cancelButton = findViewById(R.id.log_cancel)
        validateButton = findViewById(R.id.log_validate)

        // Mise en place des événements

        // Bouton d'annulation, vide les champs.
        cancelButton.setOnClickListener {
            email.text?.clear()
            email.error = null
            password.text?.clear()
            password.error = null
        }

        // Bouton validation
        validateButton.setOnClickListener {
            //on réinitialise les messages d'erreur
            email.error = null
            password.error = null

            //on récupère le contenu de deux champs dans des variables de type String
            val emailInput = email.text?.toString()
            val passwordInput = password.text?.toString()

            if (emailInput.isNullOrEmpty() or passwordInput.isNullOrEmpty()) {
                // on affiche un message dans les logs de l'application
                Log.d(getTag(), "Au moins un des deux champs est vide")
                // on affiche un message d'erreur sur les champs qui n'ont pas été renseignés
                // la méthode getString permet de charger un String depuis les ressources de
                // l'application à partir de son id
                if (emailInput.isNullOrEmpty())
                    email.error = getString(R.string.main_mandatory_field)
                if (passwordInput.isNullOrEmpty())
                    password.error = getString(R.string.main_mandatory_field)
                // Pour les fonctions lambda, on doit préciser à quelle fonction l'appel à return
                // doit être appliqué
                return@setOnClickListener
            }

            // Vérification de la validité de l'email
            if (!emailInput!!.contains('@')) {
                val toast = Toast.makeText(
                    applicationContext,
                    getString(R.string.main_invalid_email_format),
                    Toast.LENGTH_SHORT
                )
                toast.show()
                return@setOnClickListener
            }

            // Extension du comportement du bouton de validation.
            validateButtonBehaviour()
        }
    }

    /**
     * Permet l'extension du comportement du bouton valider.
     */
    abstract fun validateButtonBehaviour()

    /**
     * Retourne le tag de l'activité
     */
    override fun getTag() : String{
        return "FormActivity";
    }
}
