package com.example.animation

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.transition.TransitionInflater
import kotlinx.android.synthetic.main.fragment_b.*
import kotlinx.android.synthetic.main.fragment_b.textView
import kotlinx.android.synthetic.main.fragment_registration.*

class FragmentRegistration  : Fragment(R.layout.fragment_registration) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext()).inflateTransition(R.transition.shared_image)
        sharedElementReturnTransition = TransitionInflater.from(requireContext()).inflateTransition(R.transition.shared_image)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLoginSinUp.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.container, FragmentB())
                .addSharedElement(imageAnimaSignUp, imageAnimaSignUp.transitionName)
                .addSharedElement(textViewSignUp, textViewSignUp.transitionName)
                .addSharedElement(editTextUserNameRegristration, editTextUserNameRegristration.transitionName)
                .addSharedElement(edittextPassWordRegristration, edittextPassWordRegristration.transitionName)
                .addSharedElement(buttonGoRegristration, buttonGoRegristration.transitionName)
                .addSharedElement(buttonLoginSinUp, buttonLoginSinUp.transitionName)
            fragmentTransaction.commit()
            Log.d("aaa", "aaa")
        }
    }
}
