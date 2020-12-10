package com.kapustini.studyproject.domain

import com.kapustini.studyproject.data.models.Actor
import com.kapustini.studyproject.data.models.Movie

class ActorsDataSource {

    private var actors = listOf(
    Actor(1, "Chris Evans",
    "https://upload.wikimedia.org/wikipedia/commons/a/a6/Chris_Evans_in_2019.jpg" ),
    Actor(2, "Actor 2",
    "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg" ),
    Actor(3, "Actor 3",
    "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg" ),
    Actor(4, "Actor 4",
    "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg" ),
    Actor(5, "Dale Van Sickel",
    "https://upload.wikimedia.org/wikipedia/commons/a/a2/Dale_Van_Sickle_%281930_Seminole%29.png" ),
    Actor(6, "Eddie Parker",
    "https://upload.wikimedia.org/wikipedia/commons/3/3b/Eddie_Parker.png" ),
    Actor(7, "Actor 7",
    "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg" ),
    )

    fun getActors(): List<Actor> {
        return actors
    }

    fun getActor(id: Int) : Actor{
        return actors.first{ it.actorID == id }
    }

    fun getActorsID(idS: List<Int>) : List<Actor>{
        var tmpList: MutableList<Actor> = mutableListOf()
        var tmpActor: Actor
        idS.forEach(){
            tmpActor = getActor(it)
            if(tmpActor!=null)
                tmpList.add(tmpActor)
        }
        return tmpList
    }
}

