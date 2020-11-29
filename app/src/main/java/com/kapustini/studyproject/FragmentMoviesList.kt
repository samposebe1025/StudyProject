package com.kapustini.studyproject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.kapustini.studyproject.R

class FragmentMoviesList: Fragment() {

    private var imageMaskBunner: ImageView? = null
    private var clickListener: ClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageMaskBunner = view.findViewById<ImageView>(R.id.imageMask).apply {
            setOnClickListener { clickListener?.openMovieDetails() }
        }
    }

    override fun onAttach(context: Context){
        super.onAttach(context)
        if(context is ClickListener) {
            clickListener=context
        }
    }

    override fun onDetach() {
        super.onDetach()
        clickListener=null
    }


    interface ClickListener {
        fun openMovieDetails()
    }
}