package kr.ac.kpu.kpusummerwater.ui.Review

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kr.ac.kpu.kpusummerwater.R
import kr.ac.kpu.kpusummerwater.slideshow.detail_info

class NewsAdapter(val context: Context, val newsList:ArrayList<NewsInfo>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //뷰 생성
        val view: View = LayoutInflater.from(context).inflate(R.layout.news_detail, null)

        //생성된 뷰를 item.xml과 연결
        val newsImage =view.findViewById<ImageView>(R.id.newsImg)
        val newsTitle = view.findViewById<TextView>(R.id.newsTitle)
        val newsDate: TextView = view.findViewById<TextView>(R.id.newsDate)

        //데이터 옮기기
        val newss = newsList[position]
        //item.xml      //detail_info.class
        val resourceId = context.resources.getIdentifier(newss.img, "drawable", context.packageName)
        newsImage.setImageResource(resourceId)
        newsTitle.text = newss.title
        newsDate.text = newss.date
        return view
    }

    override fun getItem(position: Int): Any {
        return newsList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return newsList.size
    }
}