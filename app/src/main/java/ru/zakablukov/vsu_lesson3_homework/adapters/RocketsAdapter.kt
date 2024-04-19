package ru.zakablukov.vsu_lesson3_homework.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.zakablukov.vsu_lesson3_homework.RocketItem
import ru.zakablukov.vsu_lesson3_homework.databinding.RocketCardViewActiveBinding

class RocketsAdapter : RecyclerView.Adapter<RocketsAdapter.RocketsViewHolder>() {

    private var items: MutableList<RocketItem> = emptyList<RocketItem>().toMutableList()

    inner class RocketsViewHolder(
        binding: RocketCardViewActiveBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        val nameTv = binding.nameTv
        val isActiveCardView = binding.isActiveCardView
        val isActiveTv = binding.isActiveTv
        val rocketIv = binding.rocketIv
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RocketsViewHolder {
        val binding = RocketCardViewActiveBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RocketsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RocketsViewHolder, position: Int) {
        val data = items[position]

        holder.nameTv.text = data.name
        holder.rocketIv.setImageResource(data.drawableId)
        val isActiveText: String = if (data.isActive) {
            //Да, я просто захардкодил цвет
            holder.isActiveCardView.setCardBackgroundColor(Color.parseColor("#FF00D215"))
            "Active"
        } else {
            "Inactive"
        }
        holder.isActiveTv.text = isActiveText
    }

    override fun getItemCount(): Int = items.size

    fun upd(data: MutableList<RocketItem>) {
        items.addAll(data)
        notifyItemRangeInserted(items.size - 1, data.size)
    }
}