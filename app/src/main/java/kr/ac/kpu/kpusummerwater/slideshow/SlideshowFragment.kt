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

    /*
    fun fetchJson(){
        var url = "https://www.kwater.or.kr/news/repoList.do?brdId=KO26&s_mid=36"
        var request = Request.Builder().url(url).build()
        var client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call?, response: Response?) {

                val doc = Jsoup.connect("https://www.kwater.or.kr/news/repoList.do?brdId=KO26&s_mid=36").get()
                val line = doc.select(".bodo_list")
                val tumbnail = line.select("img").get(3)  //get속의 인자를 하나씩 증가시키면서 모든 imageview에 접근 가능 10개까지 한페이지에 있으니까 10개가 넘을시 페이지를 1개 증가시키는 코드 구현
                val absoluteUrl = tumbnail.absUrl("src")

                val title = line.select("div[class=text]").get(3)
                val abTitle = title.select("p[class=title]").first()
                val abHide = title.select("p[class=txt hide]").first()
                val titlelist = abTitle.html().split("<br>").toTypedArray()
                val hidelist = abHide.html().split("<br>","&lt;사진&gt;","&nbsp;").toTypedArray()

                var result = ""
                var result2 = ""

                titlelist.forEach {
                    if(it == " ") return@forEach
                    result+=it+"\n"
                }
                hidelist.forEach {
                    if(it == " ") return@forEach
                    result2 += it+"\n"

                }
                runOnUiThread{

                    Picasso.get().load(absoluteUrl).into(imageView2)
                    textView2.text= result
                    textView3.text= result2
                }

            }



            override fun onFailure(call: Call, e: IOException) {
                println("리퀘스트 실패")
            }
        })
    }
    */
}