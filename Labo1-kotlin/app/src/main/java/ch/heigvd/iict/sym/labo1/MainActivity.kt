package ch.heigvd.iict.sym.labo1

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import ch.heigvd.iict.sym.labo1.form.EXTRA_CREDENTIALS
import ch.heigvd.iict.sym.labo1.form.LoginActivity

// Clé pour le passage de l'adresse mail
const val EXTRA_EMAIL = "email.MESSAGE"

class MainActivity : LoginActivity() {

    private lateinit var signupLink: TextView


    private val credentials = mutableListOf(
        Pair("user1@heig-vd.ch", "1234"),
        Pair("user2@heig-vd.ch", "abcd")
    )

    private val getCredentials =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val creds: Pair<String, String> =
                    data?.getSerializableExtra(EXTRA_CREDENTIALS) as Pair<String, String>
                credentials.add(creds)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun createUIBehaviour() {
        super.createUIBehaviour()

        signupLink = findViewById(R.id.main_new_account)

        signupLink.setOnClickListener {
            val intent = Intent(this, CustomSignupActivity::class.java)
            getCredentials.launch(intent)
        }
    }

    override fun isValidLogin(email: String, password: String): Boolean {
        return credentials.contains(Pair(email, password))
    }

    override fun onValidLogin() {
        val intent = Intent(this, ConnectedActivity::class.java).apply {
            putExtra(ch.heigvd.iict.sym.labo1.form.EXTRA_EMAIL, email.text?.toString())
        }
        startActivity(intent)
    }
    override fun getTag(): String {
        return "MainActivty"
    }



}
