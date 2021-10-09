package ch.heigvd.iict.sym.labo1.form

import android.app.AlertDialog
import android.content.DialogInterface

import ch.heigvd.iict.sym.labo1.R

/**
 * Classe de base aux activités de connexion.
 * @author Berney Alec
 * @author Forestier Quentin
 * @author Herzig Melvyn
 */
abstract class LoginActivity : FormActivity() {

    /**
     * Extension du comportement du bouton de validation.
     */
    override fun validateButtonBehaviour() {

        //on récupère le contenu de deux champs dans des variables de type String
        val emailInput = email.text?.toString()
        val passwordInput = password.text?.toString()

        // Vérification couple email / mot de passe
        if (isValidLogin(emailInput!!, passwordInput!!)) {

            onValidLogin()

        } else {
            // Affichage fenêtre de dialogue.
            val builder = AlertDialog.Builder(this)
            builder.setMessage(getString(R.string.main_error_email_pass))
                .setPositiveButton(getString(R.string.main_ok_button),
                    DialogInterface.OnClickListener { _, _ ->
                        cancelButton.callOnClick()
                    })
            builder.create()
            builder.show()
        }
    }

    /**
     * Vérification du login.
     */
    abstract fun isValidLogin(email: String, password: String): Boolean

    /**
     * Action lorsque le login est validé.
     */
    abstract fun onValidLogin()

    /**
     * Retourne le tag
     */
    override fun getTag() : String {
        return "LoginActivity";
    }
}
