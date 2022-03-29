package com.unflow.sample

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.unflow.androidsdk.UnflowSdk
import com.unflow.androidsdk.ui.opener.OpenerData

class CustomOpenerAdapter : RecyclerView.Adapter<CustomOpenerAdapter.ViewHolder>() {

    private val items = mutableListOf<OpenerData>()

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.customOpenerItemImage)
        val textView: TextView = view.findViewById(R.id.customOpenerItemText)
        var screenId: Long? = null

        init {
            // Ensure we handle clicks – open an Unflow screen
            view.setOnClickListener {
                screenId?.let {
                    UnflowSdk.client().openScreen(it)
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Inflate a custom opener item view
        val view = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.item_custom_opener, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val opener = items[position]
        viewHolder.image.load(opener.imageUrl)
        viewHolder.textView.text = opener.title
        viewHolder.screenId = opener.screenId
    }

    override fun getItemCount() = items.size

    // Naive implementation for sample purposes only – you should do something smarter.
    // e.g. Using ListAdapter with item diffing.
    @SuppressLint("NotifyDataSetChanged")
    fun setItems(openers: List<OpenerData>) {
        items.clear()
        items.addAll(openers)
        notifyDataSetChanged()
    }
}