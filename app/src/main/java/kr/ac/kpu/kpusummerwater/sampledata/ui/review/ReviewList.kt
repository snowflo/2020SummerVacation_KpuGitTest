package kr.ac.kpu.kpusummerwater.sampledata.ui.review

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_review_list.*
import kotlinx.android.synthetic.main.fragment_slideshow.*
import kr.ac.kpu.kpusummerwater.R
import kr.ac.kpu.kpusummerwater.slideshow.detail_adapter

class ReviewList : AppCompatActivity() {

    //임시 데이터
    var Reviews = arrayListOf<ReviewInfo>(
        ReviewInfo("지역", "제목","나","20200809"),
        ReviewInfo("지역", "제목","나","20200809"),
        ReviewInfo("지역", "제목","나","20200809"),
        ReviewInfo("지역", "제목","나","20200809"),
        ReviewInfo("지역", "제목","나","20200809"),
        ReviewInfo("지역", "제목","나","20200809"),
        ReviewInfo("지역", "제목","나","20200809"),
        ReviewInfo("지역", "제목","나","20200809")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_list)
        setSupportActionBar(findViewById(R.id.toolbar))

        val reviews = ReviewAdapter(this, Reviews)
        ReviewListView.adapter = reviews

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}