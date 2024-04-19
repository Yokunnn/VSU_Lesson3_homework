package ru.zakablukov.vsu_lesson3_homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.zakablukov.vsu_lesson3_homework.R
import ru.zakablukov.vsu_lesson3_homework.RocketItem
import ru.zakablukov.vsu_lesson3_homework.databinding.FragmentUpcomingBinding

class UpcomingFragment : Fragment() {

    private val binding by viewBinding(FragmentUpcomingBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_upcoming, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRocketCard()
    }

    private fun initRocketCard() {
        val rocket = RocketItem("Starlink 2", "CCAES SLC 40", "16-10-2016", R.drawable.crs)
        with(binding.rocketCard) {
            nameTv.text = rocket.name
            launchSiteTv.text = rocket.launchSite
            launchDateTv.text = rocket.launchDate
            rocketIv.setImageResource(rocket.drawableId)
        }
    }
}