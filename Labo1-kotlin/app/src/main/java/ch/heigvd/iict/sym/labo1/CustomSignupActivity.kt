package ch.heigvd.iict.sym.labo1

import android.os.Bundle
import ch.heigvd.iict.sym.labo1.form.SignupActivity

/**
 * Activité de connexion custom.
 * @author Berney Alec
 * @author Forestier Quentin
 * @author Herzig Melvyn
 */
class CustomSignupActivity : SignupActivity() {

    /**
     * Initialisation de la vue.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

    /**
     * Retourne le tag de l'activité
     */
    override fun getTag(): String {
        return "CustomSignupActivty"
    }
}