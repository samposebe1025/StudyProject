package com.kapustini.studyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.kapustini.studyproject.R
import com.kapustini.studyproject.FragmentMoviesList
import com.kapustini.studyproject.FragmentMoviesDetails

class MainActivity : AppCompatActivity(), FragmentMoviesList.ClickListener,
    FragmentMoviesDetails.ClickListener {

    private val ACTIVE_FRAGMENT_LIST = 0x01
    private val ACTIVE_FRAGMENT_DETAILS = 0x02
    private val actFragment:String = "Fragment"
    private var activeFragment: Int = 0

    private val fragmentManager:FragmentManager? = supportFragmentManager


        private val listFragment = FragmentMoviesList()
        private val movieFragment = FragmentMoviesDetails()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            if(savedInstanceState == null){
                val fragmentTransaction = fragmentManager?.beginTransaction()
                fragmentTransaction?.apply {
                    add(R.id.fragment_movies_list_id, listFragment)
                    commit()
                }
                activeFragment = ACTIVE_FRAGMENT_LIST
            }
            else {
                activeFragment = savedInstanceState.getInt(actFragment)
                if(activeFragment == ACTIVE_FRAGMENT_DETAILS) {
                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    fragmentTransaction?.apply {
                        add(R.id.fragment_movies_list_id, listFragment)
                        addToBackStack(null)
                        add(R.id.fragment_movies_list_id, movieFragment)
                        commit()
                    }
                }
            }


        }

    override fun onSaveInstanceState (outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.putInt(actFragment,activeFragment)
    }

    override fun openMovieDetails(){
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.apply {
            addToBackStack(null)
            add(R.id.fragment_movies_list_id, movieFragment)
            commit()
        }
        activeFragment = ACTIVE_FRAGMENT_DETAILS
    }

    override fun closeMovieDetails(){
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.apply {
            remove(movieFragment)
            commit()
        }
        fragmentManager?.popBackStack()
        activeFragment = ACTIVE_FRAGMENT_LIST
    }

}
