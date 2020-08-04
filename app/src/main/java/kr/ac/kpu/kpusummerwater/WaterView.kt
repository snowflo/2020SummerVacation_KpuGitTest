package kr.ac.kpu.kpusummerwater

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kr.ac.kpu.kpusummerwater.ui.home.HomeFragment

class WaterView : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_view)
        //툴바
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        //플로팅액션버튼
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        //==========================================================================================
        if (intent.hasExtra("WaterData")) { //안 옴
            /*
            val bundle = intent.getBundleExtra("bundle") !!
            siText.text = bundle!!.getSerializable("Si") as? String
            dongText.text = bundle!!.getSerializable("Dong") as? String
            */
            var SiTest:String? = null
            var DongTest:String? = null

            //데이터 들어옴
            var data = intent.getParcelableExtra<data>("WaterData")
            if (data != null) { //debug
                SiTest = data.Si
                DongTest = data.Dong
                Toast.makeText(this, "시: ${SiTest}, 동: ${DongTest} ", Toast.LENGTH_SHORT).show()

                /*supportFragmentManager.beginTransaction().replace(
                    R.id.nav_host_fragment, HomeFragment().apply {
                        arguments = Bundle().apply {
                            putString("SiFrag",SiTest)
                            putString("DongFrag",DongTest)
                        }
                    }
                ).commit()*/
            }
            else{
                Toast.makeText(this, "전달된 내용이 없습니다", Toast.LENGTH_SHORT).show()
            }
        }
        else{ //이게 뜸
            Toast.makeText(this, "전달된 이름이 없습니다", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.water_view, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}