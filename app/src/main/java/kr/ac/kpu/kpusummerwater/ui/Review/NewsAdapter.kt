package kr.ac.kpu.kpusummerwater.ui.Review

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kr.ac.kpu.kpusummerwater.R


class NewsAdapter(val context: Context, val newsList:ArrayList<NewsInfo>) : BaseAdapter() { //context, arraylist
    
    //생성자
    //var img:String, var title:String, var date:String, var link:String
    private class ViewHolder { //뷰 재활용
        // var newsimg : ImageView? = null
        var newstitle: TextView? = null
        // var newsdate: TextView? = null
        var newslink : TextView? = null
    } 
    
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //뷰 생성
        var view: View = LayoutInflater.from(context).inflate(R.layout.news_detail, null)
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.news_detail, null)
            holder = ViewHolder()
           // holder.newsimg = view.findViewById(R.id.newsImg)
            holder.newstitle = view.findViewById(R.id.newsTitle)
           // holder.newsdate = view.findViewById(R.id.newsDate)

            view.tag = holder
            /* convertView가 null, 즉 최초로 화면을 실행할 때에
            ViewHolder에 각각의 TextView와 ImageView를 findVidwById로 설정.
            마지막에 태그를 holder로 설정한다. */
        }else{
            holder = convertView.tag as ViewHolder
            view = convertView
        }

        val newsData = newsList[position]

        // val resourceId = context.resources.getIdentifier(newsData.img, "drawable", context.packageName)
        // holder.newsimg?.setImageResource(resourceId)
        holder.newstitle?.text = newsData.title
        // holder.newsdate?.text = newsData.date

        /*
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
         */
        return view
    }

    override fun getItem(position: Int): Any {
        return newsList[position]
    }

    override fun getItemId(position: Int): Long {
        return position as Long
    }

    override fun getCount(): Int { //o
        return newsList.size
    }
}