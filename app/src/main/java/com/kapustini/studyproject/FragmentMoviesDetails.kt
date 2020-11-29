package com.kapustini.studyproject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kapustini.studyproject.R

class FragmentMoviesDetails: Fragment() {

    private var imageBack: ImageView? = null
    private var textBackButton: TextView? = null
    private var clickListener: ClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textBackButton = view.findViewById<TextView>(R.id.textTopButtonBack).apply {
            setOnClickListener { clickListener?.closeMovieDetails() }
        }
        imageBack = view.findViewById<ImageView>(R.id.imageView).apply {
            setOnClickListener { clickListener?.closeMovieDetails() }
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
        fun closeMovieDetails()
    }
}