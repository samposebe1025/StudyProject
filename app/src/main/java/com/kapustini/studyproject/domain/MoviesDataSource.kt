package com.kapustini.studyproject.domain

import com.kapustini.studyproject.data.models.Movie

class MoviesDataSource {

    private var movies = listOf(
        Movie(1, "Captain America (serial)", 13,
            "https://upload.wikimedia.org/wikipedia/commons/e/e2/Captain-america_serial_poster.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/e/e2/Captain-america_serial_poster.jpg",
            4, 124,false,
            "A rash of suspicious suicides among scientists and businessmen, all found holding a small scarab, gets the attention of Mayor Randolph. He demands that Police Commissioner Dryden and District Attorney Grant Gardner get to the bottom of the case, while openly wishing that Captain America, a masked man who has helped defeat crime in the past, were around to solve the mystery. Gail Richards, Grant Gardner's secretary, investigates and realizes someone knows of the \"Purple Death\", a hypnotic chemical responsible for the suicides. However he then pulls out a gun and takes her into another room. He then orders an associate to tie her up. The D.A. realizes she is there and forces the man to take him to her. He finds her tied up and gagged. He frees her but it is threatened that the purple death will be dropped killing them all. But the D.A. shoots him then gets out of the room with Gail.",
            "serial","243  MIN",
            listOf(5,6)    ),
        Movie(2, "Movie 1", 14,
            "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg",
            "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg",
            4, 124,false,
            "adsfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdf",
            "asdfadsf","67 MIN",
            listOf(5,2,3,4,5,5)   ),
        Movie(3, "Movie 2", 15,
            "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg",
            "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg",
            4, 124,false,
            "adsfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdf",
            "asdfadsf","135 MIN",
            listOf(5,2,3,4,5,5)   ),
        Movie(4, "Captain America: The First Avenger", 16,
            "https://upload.wikimedia.org/wikipedia/ru/4/44/CaptainAmerica.jpg",
            "https://upload.wikimedia.org/wikipedia/ru/4/44/CaptainAmerica.jpg",
            4, 124,false,
            "In the present day, scientists in the Arctic uncover an old, frozen aircraft. In March 1942, Nazi lieutenant general Johann Schmidt and his men steal a mysterious relic called the Tesseract,[N 2] which possesses untold powers, from the town of Tønsberg in German-occupied Norway.",
            "Tags, tags", "124 MIN",
            listOf(1,1,1,1)   ),

        )
    fun getMovies(): List<Movie> {
        return movies
    }

    fun getMovie(id: Int) : Movie{
        return movies.first{ it.movieID == id }
    }

}

