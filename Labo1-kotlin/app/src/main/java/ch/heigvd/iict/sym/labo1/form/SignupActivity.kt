package ch.heigvd.iict.sym.labo1.form

import android.os.Bundle
import android.util.Log
import ch.heigvd.iict.sym.labo1.R

open class SignupActivity : FormActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // on définit le layout à utiliser pour l'affichage
        setContentView(R.layout.activity_signup)

        Log.d(TAG, "l'activité est en créée")
    }

    override fun validateButtonBehaviour() {

        //on récupère le contenu de deux champs dans des variables de type String
        val emailInput = email.text?.toString()
        val passwordInput = password.text?.toString()



    }

    companion object {
        private const val TAG: String = "SignupActivity"
    }
}
