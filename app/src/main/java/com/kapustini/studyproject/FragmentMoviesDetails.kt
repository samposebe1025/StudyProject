package com.kapustini.studyproject

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kapustini.studyproject.R
import com.kapustini.studyproject.data.models.Actor
import com.kapustini.studyproject.data.models.Movie
import com.kapustini.studyproject.domain.ActorsDataSource
import com.kapustini.studyproject.domain.MoviesDataSource

class FragmentMoviesDetails: Fragment() {

    private lateinit var adapterActor: ActorAdaptor
    private var recyclerActors: RecyclerView? = null

    private var imageBack: ImageView? = null
    private var textBackButton: TextView? = null
    private var clickListener: ClickListener? = null

    private var movieBanner: ImageView? = null
    private var movieRating: TextView? = null
    private var moviePG: TextView? = null
    private var movieName: TextView? = null
    private var movieTag: TextView? = null
    private var movieReviews: TextView? = null
    private var storyline: TextView? = null


    private var movieID: Int = 0
    private var movie: Movie? = null
    private var actors: List<Actor> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieID = it.getInt(MOVIE_ID)
        }
    }


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

        movie = MoviesDataSource().getMovie(movieID)

        movieBanner = view.findViewById<ImageView>(R.id.imageBanner)
        Glide.with(context)
            .load(movie?.banner)
            .apply(imageOption)
            .into(movieBanner)

        moviePG = view.findViewById<TextView>(R.id.textPG)
        moviePG?.text = movie!!.levelPG.toString()+"+"

        movieTag = view.findViewById<TextView>(R.id.textTag)
        movieTag?.text = movie!!.tag

        movieName = view.findViewById<TextView>(R.id.textName)
        movieName?.text = movie!!.name

        movieReviews = view.findViewById<TextView>(R.id.textReviews)
        movieReviews?.text = movie!!.reviews.toString()+" REVIEWS"

        storyline = view.findViewById<TextView>(R.id.textStorylineText)
        storyline?.text = movie!!.storyLine

        recyclerActors = view.findViewById(R.id.rv_actors)
        adapterActor = ActorAdaptor()
        recyclerActors?.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        recyclerActors?.adapter = adapterActor
        recyclerActors?.addItemDecoration( SpacesItemDecorationActors(12))
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
        recyclerActors=null
    }

    interface ClickListener {
        fun closeMovieDetails()
    }


    override fun onStart() {
        super.onStart()
        actors =  ActorsDataSource().getActorsID(movie!!.actorsID)
        updateData()
    }

    private fun updateData() {
        adapterActor.bindActors(actors)
        adapterActor.notifyDataSetChanged()
    }




    companion object {
        private val imageOption = RequestOptions()
            .placeholder(R.drawable.ic_rifle)
            .fallback(R.drawable.ic_rifle)

        private const val MOVIE_ID = "movie_id"

        fun newInstance(
            movieID: Int
        ): FragmentMoviesDetails {
            val fragment = FragmentMoviesDetails()
            val args = Bundle()
            args.putInt(MOVIE_ID, movieID)
            fragment.arguments = args
            return fragment
        }
    }
}

class SpacesItemDecorationActors(
    private val spaceRight: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        //добавить переданное кол-во пикселей отступа снизу
        outRect.right = spaceRight
        outRect.left = spaceRight
    }
}