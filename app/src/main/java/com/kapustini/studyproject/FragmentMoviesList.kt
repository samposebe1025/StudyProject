package com.kapustini.studyproject

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.kapustini.studyproject.data.models.Movie
import com.kapustini.studyproject.domain.MoviesDataSource


class FragmentMoviesList: Fragment() {

    private lateinit var adapterMovie: MovieAdaptor
    private var recycler: RecyclerView? = null

    private var listener: TransactionsFragmentClicks? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       super.onViewCreated(view, savedInstanceState)
       recycler = view.findViewById(R.id.rv_movies)
       adapterMovie = MovieAdaptor(clickListener)
       recycler?.layoutManager = GridLayoutManager(requireContext(), 2)
       recycler?.adapter = adapterMovie

       recycler?.addItemDecoration( SpacesItemDecoration(12,6))
    }

    override fun onDetach() {
        super.onDetach()
        recycler=null
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    private fun updateData() {
        adapterMovie.bindMovies(MoviesDataSource().getMovies())
        adapterMovie.notifyDataSetChanged()
    }

    private fun doOnClick(movie: Movie) {
        listener?.openMovieDetails(movie.movieID)
    }

    private val clickListener = object : OnRecyclerItemClicked {
        override fun onClick(movie: Movie) {
            doOnClick(movie)
        }
    }


    fun setClickListener(l: TransactionsFragmentClicks) {
        listener = l
    }


    interface TransactionsFragmentClicks {
        fun openMovieDetails(movieID: Int)
    }



 companion object {
     fun newInstance() = FragmentMoviesList()
 }
}




class SpacesItemDecoration(
    private val spaceBottom: Int,
    private val spaceRight: Int
) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        //добавить переданное кол-во пикселей отступа снизу
        outRect.bottom = spaceBottom
        outRect.right = spaceRight
        outRect.left = spaceRight
    }
}