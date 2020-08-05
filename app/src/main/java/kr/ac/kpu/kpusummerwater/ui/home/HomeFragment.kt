package kr.ac.kpu.kpusummerwater.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.fragment_home.*
import kr.ac.kpu.kpusummerwater.R

class HomeFragment : Fragment() {

    // private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*var si = arguments?.getString("SiFrag")
        var dong = arguments?.getString("DongFrag")


        if (arguments != null) { //debug
            var si = arguments?.getString("SiFrag")
            var dong = arguments?.getString("DongFrag")
            Toast.makeText(activity, "시 = ${si}, 동 = ${dong} ", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(activity, "전달된 내용이 없습니다!!", Toast.LENGTH_SHORT).show()
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        */
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}