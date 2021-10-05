package ch.heigvd.iict.sym.labo1

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import ch.heigvd.iict.sym.labo1.form.LoginActivity

// Clé pour le passage de l'adresse mail
const val EXTRA_EMAIL = "email.MESSAGE"

class MainActivity : LoginActivity() {


    // on définit une liste de couples e-mail / mot de passe
    // ceci est fait juste pour simplifier ce premier laboratoire,
    // mais il est évident que de hardcoder ceux-ci est une pratique à éviter à tout prix...
    // /!\ listOf() retourne une List<T> qui est immuable
    private val credentials = listOf(
        Pair("user1@heig-vd.ch", "1234"),
        Pair("user2@heig-vd.ch", "abcd")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        private const val TAG: String = "MainActivity"
    }

}
