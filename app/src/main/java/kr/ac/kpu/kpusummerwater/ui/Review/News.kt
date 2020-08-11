package kr.ac.kpu.kpusummerwater.ui.Review

import android.os.AsyncTask
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_news.*
import kr.ac.kpu.kpusummerwater.R
import org.jsoup.Jsoup
import java.io.IOException
import java.util.*


class News : AppCompatActivity() {

    private var arrayList: ArrayList<NewsInfo>? = null
    private var adapter: NewsAdapter? = null //newsData
    private var listView: ListView? = null

    var news_title: java.lang.StringBuilder? = null
    var news_link: java.lang.StringBuilder? = null

    //임시 데이터
    /*
    var newss = arrayListOf<NewsInfo>(
        NewsInfo("ic_baseline_home_24", "로딩중","로딩중"),
        NewsInfo("ic_baseline_home_24", "로딩중","로딩중"),
        NewsInfo("ic_baseline_home_24", "로딩중","로딩중"),
        NewsInfo("ic_baseline_home_24", "로딩중","로딩중"),
        NewsInfo("ic_baseline_home_24", "로딩중","로딩중")
    )
    */
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        //??? 자동변환
        news_title = java.lang.StringBuilder()
        news_link = java.lang.StringBuilder()

        /*
        listView = findViewById<ListView>(R.id.NewsListView)
        arrayList = ArrayList<NewsInfo>()
        adapter = NewsAdapter(this, R.layout.news_detail, arrayList!!)

        listView.setAdapter(adapter)
        */

        adapter = arrayList?.let { NewsAdapter(this, it) }

        val newsData = arrayList?.let { NewsAdapter(this, it) } //위에 newss
        NewsListView.adapter = newsData
    }
/*
    private class NewsAsyncTask : AsyncTask<Void?, Void?, Void?>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        protected override fun doInBackground(vararg p0: Void?): Void? {
            try {
                val doc =
                    Jsoup.connect("http://news.naver.com/main/hotissue/sectionList.nhn?mid=hot&sid1=101&cid=1074429")
                        .get()
                val hotNews = doc.select("div.lnb_today")[0]
                val news = hotNews.select("li")
                for (e in news) {
                    news_title.append(e.text().trim { it <= ' ' }).append("\n")
                    news_link.append(e.getElementsByAttribute("href").attr("href")).append("\n")
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return null
        }

        override fun onPostExecute(result: Void?) {
            val title = StringTokenizer(news_title.toString(), "\n") //뉴스 제목
            val link = StringTokenizer(news_link.toString(), "\n") //뉴스 링크
            arrayList.clear() // 리스트 초기화
            while (title.hasMoreTokens()) //\n 제거
            {
                val n_title: String = title.nextToken()
                val n_link: String = link.nextToken()
                arrayList.add(NewsInfo(n_title, n_link))
            }
            adapter.notifyDataSetChanged()
        }
    }
 */
}