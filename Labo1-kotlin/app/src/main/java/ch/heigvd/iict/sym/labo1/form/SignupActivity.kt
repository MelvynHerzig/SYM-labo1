package ch.heigvd.iict.sym.labo1.form

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import ch.heigvd.iict.sym.labo1.R

const val EXTRA_USERNAME = "signup.EMAIL"
const val EXTRA_PASSWORD = "signup.PASSWORD"

abstract class SignupActivity : FormActivity() {


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

    companion object {
        private const val TAG: String = "SignupActivity"
    }
}
