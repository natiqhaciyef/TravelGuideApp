package com.natiqhaciyef.travelguideapp.ui.view.fragment.register

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AlertDialogLayout
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.data.switchHtmlToXML
import com.natiqhaciyef.travelguideapp.databinding.AlertSuccesfullRegistrationBinding
import com.natiqhaciyef.travelguideapp.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var auth: FirebaseAuth
    private var visibility = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        binding.goToLogin.switchHtmlToXML(R.string.have_an_account_text, requireContext())
        binding.passwordVisibile.setOnClickListener {
            visibility = !visibility
            passwordVisibility(visibility)
        }

        binding.passwordVisibileOff.setOnClickListener {
            visibility = !visibility
            passwordVisibility(visibility)
        }

        binding.goToLogin.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.loginFragment)
        }

        binding.registerButton.setOnClickListener {
            val username = binding.userNameInputTextRegister.text.toString()
            val email = binding.emailInputTextRegister.text.toString()
            val password = binding.passwordInputTextRegister.text.toString()

            register(username, email, password)
        }
    }

    private fun passwordVisibility(visibility: Boolean) {
        if (visibility) {
            binding.passwordInputTextRegister.transformationMethod =
                PasswordTransformationMethod.getInstance()
            binding.passwordVisibile.visibility = View.GONE
            binding.passwordVisibileOff.visibility = View.VISIBLE
        } else {
            binding.passwordInputTextRegister.transformationMethod =
                HideReturnsTransformationMethod.getInstance()
            binding.passwordVisibile.visibility = View.VISIBLE
            binding.passwordVisibileOff.visibility = View.GONE
        }
    }

    private fun register(username: String, email: String, password: String) {
        if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
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