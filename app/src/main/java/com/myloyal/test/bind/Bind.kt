package com.myloyal.test.bind

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.myloyal.test.R
import com.myloyal.test.models.Currency
import com.myloyal.test.ui.CurrencyAdapter

object Bind {

    @BindingAdapter(value = ["currencies", "onClick"], requireAll = true)
    @JvmStatic
    fun setEvents(list: RecyclerView, currencies: List<Currency>?, onClick: (Currency) -> Unit) {
        currencies?.let {
            list.adapter?.notifyDataSetChanged() ?: run {
                list.adapter = CurrencyAdapter(it, onClick)
            }
        }
    }

    @BindingAdapter("setChange")
    @JvmStatic
    fun setChange(textView: TextView, value: Double){
        if (value>0){
            textView.setTextColor(Color.rgb(0,130,0))
            textView.text = "+" + value.toString() + " %"
        }else{
            textView.text = value.toString() + " %"
            textView.setTextColor(Color.RED)
        }

    }

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            Glide.with(imgView.context)
                .load(imgUrl)
                .into(imgView)

        }
    }

}
