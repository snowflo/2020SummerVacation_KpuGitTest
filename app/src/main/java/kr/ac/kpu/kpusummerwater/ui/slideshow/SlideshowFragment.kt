package kr.ac.kpu.kpusummerwater.ui.slideshow
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import kr.ac.kpu.kpusummerwater.R


//리스트 뷰 메인
class SlideshowFragment() : ListFragment() { //ListFragment x 아직은

    var detailList = arrayListOf<detail_info>(
        detail_info("맛","좋음"),
        detail_info("냄새","좋음"),
        detail_info("색도","좋음"),
        detail_info("ph","좋음"),
        detail_info("탁도","좋음"),
        detail_info("잔류염소","좋음")
    )

    lateinit var adapter:detail_adapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.fragment_slideshow, container, false)

    adapter = detail_adapter()
    setListAdapter(adapter)
        /*
        val detailAdapter = detail_adapter(this, detailList)
        detailListView.adapter = detailAdapter //리스트 뷰 아이디
        */
        return view
    }
}