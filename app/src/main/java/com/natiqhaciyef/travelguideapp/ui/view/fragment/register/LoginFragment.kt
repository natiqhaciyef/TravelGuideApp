package com.natiqhaciyef.travelguideapp.ui.view.fragment.register

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.data.switchHtmlToXML
import com.natiqhaciyef.travelguideapp.databinding.AlertSuccesfullRegistrationBinding
import com.natiqhaciyef.travelguideapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth
    private var visibility = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        binding.goToRegister.switchHtmlToXML(R.string.create_account_text,requireContext())

        binding.passwordVisibile.setOnClickListener {
            visibility = !visibility
            passwordVisibility(visibility)
        }

        binding.passwordVisibileOff.setOnClickListener {
            visibility = !visibility
            passwordVisibility(visibility)
        }

        binding.loginButton.setOnClickListener {
            val email = binding.emailInputTextLogin.text.toString()
            val password = binding.passwordInputTextLogin.text.toString()
            login(email, password)
        }

        binding.goToRegister.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.registerFragment)
        }

        binding.goToForgotPassword.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.forgotPasswordFragment)
        }
    }

    private fun passwordVisibility(visibility: Boolean) {
        if (visibility) {
            binding.passwordInputTextLogin.transformationMethod =
                PasswordTransformationMethod.getInstance()
            binding.passwordVisibile.visibility = View.GONE
            binding.passwordVisibileOff.visibility = View.VISIBLE
        } else {
            binding.passwordInputTextLogin.transformationMethod =
                HideReturnsTransformationMethod.getInstance()
            binding.passwordVisibile.visibility = View.VISIBLE
            binding.passwordVisibileOff.visibility = View.GONE
        }
    }

    private fun login(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                createAlertDialogSuccessMessage(true)
            }.addOnFailureListener {
                createAlertDialogSuccessMessage(false)
            }
        }
    }

    private fun createAlertDialogSuccessMessage(success: Boolean) {
        val view = AlertSuccesfullRegistrationBinding.inflate(layoutInflater)
        if (success)
            view.serviceAnswerAnimation.setAnimation(R.raw.successfull)
        else
            view.serviceAnswerAnimation.setAnimation(R.raw.failed)

        val customAlertDialog = AlertDialog.Builder(requireContext())
            .setView(view.root)
            .create()
        customAlertDialog.show()
    }
}