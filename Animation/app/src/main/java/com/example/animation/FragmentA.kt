package com.example.animation

import android.app.ActivityOptions
import android.os.Build
import android.os.Bundle
import android.util.Pair as UtilPair
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.transition.TransitionInflater
import kotlinx.android.synthetic.main.fragment_a.*


@Suppress("DEPRECATION")
class FragmentA : Fragment(R.layout.fragment_a) {
    var topAnime: Animation? = null
    var botAnime: Animation? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(requireContext()).inflateTransition(R.transition.shared_image)
        sharedElementReturnTransition =
            TransitionInflater.from(requireContext()).inflateTransition(R.transition.shared_image)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        topAnime = AnimationUtils.loadAnimation(requireContext(), R.anim.top_anim)
        botAnime = AnimationUtils.loadAnimation(requireContext(), R.anim.bottom_anim)

        imageButtonAnime.animation = topAnime
        textAnime.animation = botAnime

        val handler = Handler()
        handler.postDelayed({
            val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
                fragmentTransaction.replace(R.id.container, FragmentB())
                    .addSharedElement(imageButtonAnime, imageButtonAnime.transitionName)
                    .addSharedElement(textAnime, textAnime.transitionName)
                fragmentTransaction.commit()

        }, 3000)
    }
}
