package com.kapustini.studyproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kapustini.studyproject.data.models.Movie

class MovieAdaptor(
    private val listner: (movie: Movie) -> Unit
) : RecyclerView.Adapter<MovieViewHolder>() {

    private var movies: List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_movie, parent, false)
        return MovieViewHolder(view, listner)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(movies[position])
//        holder.itemView.setOnClickListener {
////            clickListener.onClick(movies[position])
//            listner.invoke()
//        }
    }

    override fun getItemCount(): Int = movies.size

    fun bindMovies(newMovies: List<Movie>) {
        movies = newMovies
    }
}

class MovieViewHolder(itemView: View,  private val listner: (movie: Movie) -> Unit) : RecyclerView.ViewHolder(itemView) {

    companion object {
        private val imageOption = RequestOptions()
            .placeholder(R.drawable.ic_rifle)
            .fallback(R.drawable.ic_rifle)
    }


    private val root: FrameLayout = itemView.findViewById(R.id.frame0)
    private val bannerPreview: ImageView = itemView.findViewById(R.id.imageBanner)
    private val name: TextView = itemView.findViewById(R.id.textName)
    private val levelPG: TextView = itemView.findViewById(R.id.textPG)

    private val duration: TextView = itemView.findViewById(R.id.textDuration)
    private val tag: TextView = itemView.findViewById(R.id.textTag)
    private val reviews: TextView = itemView.findViewById(R.id.textReviews)

    fun onBind(movie: Movie) {
        root.setOnClickListener { listner(movie) }
        Glide.with(context)
            .load(movie.bannerPreview)
            .apply(imageOption)
            .into(bannerPreview)

        name.text = movie.name
        levelPG.text = movie.levelPG.toString() + "+"
        duration.text = movie.movieDuration
        tag.text = movie.tag
        reviews.text = movie.reviews.toString() + "+"

    }

}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context

interface OnRecyclerItemClicked {
    fun onClick(movie: Movie)
}
