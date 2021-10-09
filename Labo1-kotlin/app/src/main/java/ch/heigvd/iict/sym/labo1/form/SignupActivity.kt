package ch.heigvd.iict.sym.labo1.form

import android.content.Intent

// Clé pour le passage de l'adresse mail
const val EXTRA_USERNAME = "signup.EMAIL"

// Clé pour le passage du mot de passe
const val EXTRA_PASSWORD = "signup.PASSWORD"

/**
 * Activité de base pour les activités de création de compte.
 * @author Berney Alec
 * @author Forestier Quentin
 * @author Herzig Melvyn
 */
abstract class SignupActivity : FormActivity() {

    /**
     * Extension du comportement du bouton de validation.
     */
    override fun validateButtonBehaviour() {

        //on récupère le contenu de deux champs dans des variables de type String
        val emailInput = email.text?.toString()
        val passwordInput = password.text?.toString()

        val data = Intent()

        data.putExtra(EXTRA_USERNAME, emailInput)
        data.putExtra(EXTRA_PASSWORD, passwordInput)

        setResult(RESULT_OK, data)
        finish()
    }

    /**
     * Retourne le tag de la classe.
     */
    override fun getTag() : String {
        return "SignupActivity";
    }
}
