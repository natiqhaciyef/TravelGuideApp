package com.natiqhaciyef.travelguideapp.ui.view.fragment.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.databinding.AlertSuccesfullRegistrationBinding
import com.natiqhaciyef.travelguideapp.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {
    private lateinit var binding: FragmentForgotPasswordBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth

        binding.forgotPasswordButton.setOnClickListener {
            val email = binding.emailInputTextForgotPassword.text.toString()
            resetPassword(email)
        }
    }

    private fun resetPassword(email: String){
        if (email.isNotEmpty()){
            auth.sendPasswordResetEmail(email).addOnSuccessListener {
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