package kr.ac.kpu.kpusummerwater

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_signup.*
import kotlin.math.sign

class SignupActivity : AppCompatActivity() {
//    private lateinit var auth: FirebaseAuth
//    private val RC_SIGN_IN = 9001
//    private var firebaseAuth: FirebaseAuth? = null
    var googleSignInClient : GoogleSignInClient? = null
    var RC_SIGN_IN = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        signup_button.setOnClickListener{
            createEmailId()
        }
        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this,gso)
        google_login_button.setOnClickListener{
            var signInIntent = googleSignInClient?.signInIntent
            startActivityForResult(signInIntent,RC_SIGN_IN)
        }


    }
    fun createEmailId() {
        var email = email_text.text.toString()
        var password = password_text.text.toString()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    println("가입 성공")
                }
            }
    }
    fun firebaseAuthWithGoogle(acct : GoogleSignInAccount?){
        var credential = GoogleAuthProvider.getCredential(acct?.idToken,null)
        FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener { task ->
            if(task.isSuccessful){
                println("구글 로그인 성공")
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == RC_SIGN_IN){
            var task = GoogleSignIn.getSignedInAccountFromIntent(data)
            var account = task.getResult(ApiException::class.java)
            firebaseAuthWithGoogle(account)
        }
    }
}