package kr.ac.kpu.kpusummerwater.ui.Review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.fragment_slideshow.*
import kr.ac.kpu.kpusummerwater.R
import kr.ac.kpu.kpusummerwater.slideshow.detail_adapter
import kr.ac.kpu.kpusummerwater.slideshow.detail_info

class News : AppCompatActivity() {
    //임시 데이터
    var newss = arrayListOf<NewsInfo>(
        NewsInfo("ic_baseline_home_24", "로딩중","로딩중"),
        NewsInfo("ic_baseline_home_24", "로딩중","로딩중"),
        NewsInfo("ic_baseline_home_24", "로딩중","로딩중"),
        NewsInfo("ic_baseline_home_24", "로딩중","로딩중"),
        NewsInfo("ic_baseline_home_24", "로딩중","로딩중")
    )
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newss = NewsAdapter(this, newss)
        NewsListView.adapter = newss
    }
}