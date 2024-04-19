package ru.zakablukov.vsu_lesson3_homework

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import ru.zakablukov.vsu_lesson3_homework.adapters.ViewPagerAdapter
import ru.zakablukov.vsu_lesson3_homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind, R.id.main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewPagerAdapter = ViewPagerAdapter(this)
        with(binding){
            viewpager.adapter = viewPagerAdapter
            TabLayoutMediator(tab, viewpager) { tab, position ->
                val tabNames = listOf("Upcoming", "Launches", "Rockets")
                tab.text = tabNames[position]
            }.attach()
        }
    }
}