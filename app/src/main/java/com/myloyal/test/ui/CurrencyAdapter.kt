package com.myloyal.test.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.myloyal.test.R
import com.myloyal.test.databinding.FragmentInfoBinding
import com.myloyal.test.databinding.InfoItemViewBinding
import com.myloyal.test.models.Currency

class CurrencyAdapter(private val items: List<Currency>, var onClick: (Currency) -> Unit):  ListAdapter<Currency, RecyclerView.ViewHolder>(REPO_COMPARATOR) {


//    var data= listOf<Currency>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CoinViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.info_item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }


    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Currency>() {
            override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean = oldItem == newItem

            override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean = oldItem.equals(newItem)
        }
    }


    internal inner class CoinViewHolder(private val binding: InfoItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Currency) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is CoinViewHolder){
//            for (i in items){
                holder.bind(items[position])
//            }
        }
    }

}