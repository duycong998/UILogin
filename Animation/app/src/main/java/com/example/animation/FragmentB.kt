package com.example.animation
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.transition.TransitionInflater
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_b.*

@Suppress("UNREACHABLE_CODE")
class FragmentB : Fragment(R.layout.fragment_b){
    var check = true
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext()).inflateTransition(R.transition.shared_image)
        sharedElementReturnTransition = TransitionInflater.from(requireContext()).inflateTransition(R.transition.shared_image)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSignUp.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.container, FragmentRegistration())
                .addSharedElement(imageAnime, imageAnime.transitionName)
                .addSharedElement(textView, textView.transitionName)
                .addSharedElement(edittextUserName, edittextUserName.transitionName)
                .addSharedElement(edittextPassWord, edittextPassWord.transitionName)
                .addSharedElement(buttonGo, buttonGo.transitionName)
                .addSharedElement(buttonSignUp, buttonSignUp.transitionName)
            fragmentTransaction.commit()
        }
    }
}
