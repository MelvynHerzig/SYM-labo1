package ch.heigvd.iict.sym.labo1.form

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import ch.heigvd.iict.sym.labo1.R

const val EXTRA_CREDENTIALS = "signup.CREDENTIAL"

abstract  class SignupActivity : FormActivity() {

    override fun validateButtonBehaviour() {

        //on récupère le contenu de deux champs dans des variables de type String
        val emailInput = email.text?.toString()
        val passwordInput = password.text?.toString()

        val data = Intent()

        data.putExtra(EXTRA_CREDENTIALS, Pair(emailInput, passwordInput))

        setResult(RESULT_OK, data)
        finish()
    }
}
