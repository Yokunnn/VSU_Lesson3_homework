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
import ru.zakablukov.vsu_lesson3_homework.adapters.LaunchesAdapter
import ru.zakablukov.vsu_lesson3_homework.databinding.FragmentLaunchesBinding

class LaunchesFragment : Fragment() {

    private val binding by viewBinding(FragmentLaunchesBinding::bind)
    private lateinit var launchesAdapter: LaunchesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        launchesAdapter = LaunchesAdapter()
        return inflater.inflate(R.layout.fragment_launches, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = launchesAdapter
        launchesAdapter.upd(
            mutableListOf(
                RocketItem("Starlink 2", "CCAES SLC 40", "16-12-2014", R.drawable.falconsat01),
                RocketItem("DemoSat", "AAAES SLC 40", "06-07-2018", R.drawable.falcon9),
                RocketItem("Falcon 9 Test", "CCAES SEC 40", "18-03-2019", R.drawable.demosat02),
                RocketItem("CRS - 2", "CAAES SLC 40", "18-12-2019", R.drawable.crs),
                RocketItem("Falcon 9", "AAAES SEC 40", "20-06-2077", R.drawable.falcon09)
            )
        )

    }
}