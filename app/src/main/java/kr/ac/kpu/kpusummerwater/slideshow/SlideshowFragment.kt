package kr.ac.kpu.kpusummerwater.slideshow
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_slideshow.*
import kr.ac.kpu.kpusummerwater.R


//리스트 뷰 메인
class SlideshowFragment : AppCompatActivity() {

    val baseUrl = "http://english.kwater.or.kr/news/repoList.do?brdId=KO26&s_mid=36&pageNo="
    var pages: Int = 1
    var maxPages :Int =3

    //임시 데이터
    var detailList = arrayListOf<detail_info>(
        detail_info("ic_baseline_home_24", "맛","20200808"),
        detail_info("ic_baseline_home_24", "냄새","20200808"),
        detail_info("ic_baseline_home_24", "색도","20200808"),
        detail_info("ic_baseline_home_24", "ph","20200808"),
        detail_info("ic_baseline_home_24", "탁도","20200808"),
        detail_info("ic_baseline_home_24", "잔류염소","20200808")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        //fetchJson()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_slideshow)

        val details = detail_adapter(this, detailList)
        detailListView.adapter = details
    }
}