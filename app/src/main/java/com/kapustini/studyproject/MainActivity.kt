package com.kapustini.studyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textv:TextView = findViewById(R.id.tv0)
        textv.setOnClickListener { onClick() }
    }
    public fun onClick() {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        startActivity(intent)
    }
}

/*
 <



      <ImageView
            android:id="@+id/imageBanner"
            android:layout_width="0dp"
            android:layout_height="298dp"
            android:scaleType="centerCrop"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:srcCompat="@drawable/orign"
            tools:ignore="ContentDescription" />

        <ImageView
            android:id="@+id/imageMask"
            android:layout_width="0dp"
            android:layout_height="0dp"
            android:scaleType="fitXY"
            app:layout_constraintBottom_toBottomOf="@+id/imageBanner"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            android:background="@drawable/mask"
            tools:ignore="ContentDescription" />

    <TextView
        android:id="@+id/textStorylineText"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="4dp"

        android:paddingTop="@dimen/text_size_12"
        android:paddingBottom="@dimen/text_size_12"
        android:text="@string/storyline_text"
        android:textColor="@color/white_0.75"
        android:textSize="@dimen/storyline_text_size"
        app:layout_constraintEnd_toStartOf="@+id/guideline2"
        app:layout_constraintStart_toStartOf="@+id/guideline1"
        app:layout_constraintTop_toBottomOf="@+id/textStorylineName"
        android:letterSpacing="0.05"
        android:lineHeight="20sp"/>

    <TextView
        android:id="@+id/textCastHeading"
        android:layout_width="0dp"
        android:layout_height="24dp"
        android:layout_marginTop="24dp"
        android:shadowColor="@color/shadow_gray"
        android:shadowDx="@dimen/shadow_x"
        android:shadowDy="@dimen/shadow_y"
        android:shadowRadius="@dimen/shadow_radius"
        android:text="@string/cast_name"
        android:textColor="@color/name_gray"
        android:textStyle="bold"
        app:layout_constraintEnd_toStartOf="@+id/guideline2"
        app:layout_constraintStart_toStartOf="@+id/guideline1"
        app:layout_constraintTop_toBottomOf="@+id/textStorylineText" />
 */