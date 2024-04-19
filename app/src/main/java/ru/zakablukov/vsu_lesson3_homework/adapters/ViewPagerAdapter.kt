package ru.zakablukov.vsu_lesson3_homework.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.zakablukov.vsu_lesson3_homework.fragments.LaunchesFragment
import ru.zakablukov.vsu_lesson3_homework.fragments.RocketsFragment
import ru.zakablukov.vsu_lesson3_homework.fragments.UpcomingFragment

class ViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> UpcomingFragment()
            1 -> LaunchesFragment()
            else -> RocketsFragment()
        }
    }
}