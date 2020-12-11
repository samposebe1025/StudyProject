package com.kapustini.studyproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), FragmentMoviesList.TransactionsFragmentClicks, FragmentMoviesDetails.ClickListener {


    private val fragmentList = FragmentMoviesList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         setContentView(R.layout.activity_main)

         if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .apply {
                    add(R.id.fragment_movies_list_id, fragmentList)
                    commit()
                }
        }
}

    override fun closeMovieDetails(){
        supportFragmentManager.beginTransaction().apply {
            remove(FragmentMoviesDetails())
            commit()
        }
        supportFragmentManager.popBackStack()
    }

    override fun openMovieDetails(movieID: Int) {
        supportFragmentManager.beginTransaction().apply {
            addToBackStack(null)
            add(R.id.fragment_movies_list_id, FragmentMoviesDetails.newInstance(movieID))
            commit()
        }
        //val toast = Toast.makeText(applicationContext, movieID.toString(), Toast.LENGTH_SHORT).show()
    }

}
