package ch.heigvd.iict.sym.labo1.form

import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import ch.heigvd.iict.sym.labo1.LoggingActivity
import ch.heigvd.iict.sym.labo1.R

// Clé pour le passage de l'adresse mail
const val EXTRA_EMAIL = "email.MESSAGE"

abstract class FormActivity : LoggingActivity() {

    // le modifieur lateinit permet de définir des variables avec un type non-null
    // sans pour autant les initialiser immédiatement
    protected lateinit var email: EditText
    protected lateinit var password: EditText
    protected lateinit var cancelButton: Button
    protected lateinit var validateButton: Button


    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        createUIBehaviour()
    }


    open fun createUIBehaviour() {

        // on va maintenant lier le code avec les éléments graphiques (champs texts, boutons, etc.)
        // présents dans le layout (nous allons utiliser l'id défini dans le layout, le cast est
        // réalisé automatiquement)
        email = findViewById(R.id.form_email)
        password = findViewById(R.id.form_password)
        cancelButton = findViewById(R.id.form_cancel)
        validateButton = findViewById(R.id.form_validate)

        // Kotlin, au travers des Android Kotlin Extensions permet d'automatiser encore plus cette
        // étape en créant automatiquement les variables pour tous les éléments graphiques présents
        // dans le layout et disposant d'un id
        // cf. https://medium.com/@temidjoy/findviewbyid-vs-android-kotlin-extensions-7db3c6cc1d0a

        //mise en place des événements
        cancelButton.setOnClickListener {
            email.text?.clear()
            email.error = null
            password.text?.clear()
            password.error = null
        }

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

            validateButtonBehaviour()
        }
    }

    abstract fun validateButtonBehaviour()

    override fun getTag() : String{
        return "FormActivity";
    }
}
