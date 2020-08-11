package kr.ac.kpu.kpusummerwater.sampledata.ui.review

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.content_review_list.*
import kotlinx.android.synthetic.main.fragment_slideshow.*
import kr.ac.kpu.kpusummerwater.R
import kr.ac.kpu.kpusummerwater.slideshow.detail_adapter

class ReviewList : AppCompatActivity() {

    lateinit var ref: DatabaseReference
    lateinit var ReviewList:MutableList<ReviewInfo>
    lateinit var listview: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_list)
        setSupportActionBar(findViewById(R.id.toolbar))

        /*
        val reviews = ReviewAdapter(this, Reviews)
        ReviewListView.adapter = reviews
        */

        ReviewList = mutableListOf()
        listview = findViewById(R.id.ReviewListView)
        ref = FirebaseDatabase.getInstance().getReference("ReviewInfo") //???

        ref.addValueEventListener(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {

            }

            override fun onDataChange(p0: DataSnapshot?) {
                if(p0!!.exists()){
                    ReviewList.clear()
                    for(e in p0.children){
                        val reviews = e.getValue(ReviewInfo::class.java)
                        ReviewList.add(reviews!!)
                    }
                    val adapter = ReviewAdapter(this@ReviewList,R.layout.review_detail, ReviewList as ArrayList<ReviewInfo>) //??? 6:39
                    listview.adapter = adapter
                }
            }

        })

        val intent = Intent(this,Review::class.java)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            
            startActivity(intent) //리뷰창으로
        }
    }
}