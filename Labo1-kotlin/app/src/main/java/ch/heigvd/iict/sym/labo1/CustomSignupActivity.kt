package ch.heigvd.iict.sym.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ch.heigvd.iict.sym.labo1.form.SignupActivity

class CustomSignupActivity : SignupActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

    companion object {
        private const val TAG: String = "SignupActivity"
    }
}