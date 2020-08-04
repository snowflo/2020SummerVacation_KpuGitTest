package kr.ac.kpu.kpusummerwater

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_region_select.*

class RegionSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_region_select)

        val RegionIntent = Intent(this, WaterView::class.java)
        regionEnter.setOnClickListener(){
            startActivity(RegionIntent)
        }
    }
}