package ch.heigvd.iict.sym.labo1.form

import android.os.Bundle
import ch.heigvd.iict.sym.labo1.R

abstract  class SignupActivity : FormActivity() {

    override fun validateButtonBehaviour() {

        //on récupère le contenu de deux champs dans des variables de type String
        val emailInput = email.text?.toString()
        val passwordInput = password.text?.toString()


    }
}
