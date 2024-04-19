package ru.zakablukov.vsu_lesson3_homework.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.zakablukov.vsu_lesson3_homework.RocketItem
import ru.zakablukov.vsu_lesson3_homework.databinding.RocketCardViewBinding

class LaunchesAdapter : RecyclerView.Adapter<LaunchesAdapter.LaunchesViewHolder>() {

    private var items: MutableList<RocketItem> = emptyList<RocketItem>().toMutableList()

    inner class LaunchesViewHolder(
        binding: RocketCardViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        val nameTv = binding.nameTv
        val launchSiteTv = binding.launchSiteTv
        val launchDateTv = binding.launchDateTv
        val rocketIv = binding.rocketIv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchesViewHolder {
        val binding = RocketCardViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LaunchesViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: LaunchesViewHolder, position: Int) {
        val data = items[position]

        holder.nameTv.text = data.name
        holder.launchSiteTv.text = data.launchSite
        holder.launchDateTv.text = data.launchDate
        holder.rocketIv.setImageResource(data.drawableId)
    }

    fun upd(data: MutableList<RocketItem>) {
        items.addAll(data)
        notifyItemRangeInserted(items.size - 1, data.size)
    }
}