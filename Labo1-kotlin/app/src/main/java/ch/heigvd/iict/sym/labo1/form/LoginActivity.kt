package ch.heigvd.iict.sym.labo1.form

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import ch.heigvd.iict.sym.labo1.ConnectedActivity
import ch.heigvd.iict.sym.labo1.R

open class LoginActivity : FormActivity() {
    private lateinit var signupLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // on définit le layout à utiliser pour l'affichage


        signupLink = findViewById(R.id.main_new_account)

        signupLink.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    override fun validateButtonBehaviour() {

        //on récupère le contenu de deux champs dans des variables de type String
        val emailInput = email.text?.toString()
        val passwordInput = password.text?.toString()

        // Vérification couple email / mot de passe
        if (true) {

            // Valide, ouverture nouvelle activité.
            val intent = Intent(this, ConnectedActivity::class.java).apply {
                putExtra(EXTRA_EMAIL, emailInput)
            }
            startActivity(intent)

        } else {
            // Inexistant, affichage fenêtre de dialogue.
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
}
