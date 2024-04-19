package ru.zakablukov.vsu_lesson3_homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.zakablukov.vsu_lesson3_homework.R
import ru.zakablukov.vsu_lesson3_homework.RocketItem
import ru.zakablukov.vsu_lesson3_homework.adapters.RocketsAdapter
import ru.zakablukov.vsu_lesson3_homework.databinding.FragmentRocketsBinding

class RocketsFragment : Fragment() {

    private val binding by viewBinding(FragmentRocketsBinding::bind)
    private lateinit var rocketsAdapter: RocketsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rocketsAdapter = RocketsAdapter()
        return inflater.inflate(R.layout.fragment_rockets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = rocketsAdapter
        rocketsAdapter.upd(
            mutableListOf(
                RocketItem("Falcon 1", "AAAES SEC 40", "20-06-2077", R.drawable.falconsat01),
                RocketItem("Falcon 9", "AAAES SEC 40", "20-06-2077", R.drawable.falcon09, true),
                RocketItem("Big Falcon Rocket", "AAAES SEC 40", "20-06-2077", R.drawable.demosat02),
                RocketItem("Starlink 2312321", "AAAES SEC 40", "20-06-2077", R.drawable.crs, true),
                RocketItem("DemoSat", "AAAES SEC 40", "20-06-2077", R.drawable.falconsat01, true),
            )
        )
    }
}