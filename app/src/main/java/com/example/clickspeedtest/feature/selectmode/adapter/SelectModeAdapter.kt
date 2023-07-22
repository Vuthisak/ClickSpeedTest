package com.example.clickspeedtest.feature.selectmode.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clickspeedtest.databinding.ViewItemSelectModeBinding
import com.example.network.model.SelectMode

class SelectModeAdapter(
    private val items: MutableList<SelectMode>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<SelectModeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        return ViewHolder(
            ViewItemSelectModeBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val selectMode = items[position]
        with(holder.binding) {
            txtMode.text = selectMode.text
            root.setOnClickListener { listener.onItemClicked(selectMode) }
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val binding: ViewItemSelectModeBinding) : RecyclerView.ViewHolder(binding.root)

    fun interface OnItemClickListener {
        fun onItemClicked(selectMode: SelectMode)
    }

}
