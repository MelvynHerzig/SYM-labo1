package ch.heigvd.iict.sym.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import ch.heigvd.iict.sym.labo1.form.SignupActivity

class CustomSignupActivity : SignupActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

    override fun getTag(): String {
        return "CustomSignupActivty"
    }




}