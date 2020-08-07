package kr.ac.kpu.kpusummerwater.ui.slideshow
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_slideshow.*
import kr.ac.kpu.kpusummerwater.R


//리스트 뷰 메인
class SlideshowFragment : AppCompatActivity() {

    var detailList = arrayListOf<detail_info>(
        detail_info("ic_baseline_home_24", "맛"),
        detail_info("ic_baseline_home_24", "냄새"),
        detail_info("ic_baseline_home_24", "색도"),
        detail_info("ic_baseline_home_24", "ph"),
        detail_info("ic_baseline_home_24", "탁도"),
        detail_info("ic_baseline_home_24", "잔류염소")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_slideshow)

        val details = detail_adapter(this, detailList)
        detailListView.adapter = details
    }

}