package ai.rever.explayout.adapter

import ai.rever.explayout.R
import ai.rever.explayout.model.DataModel
import ai.rever.explayout.model.PersonItem
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.compact_layout.view.*
import kotlinx.android.synthetic.main.user_activity.view.*
import kotlinx.android.synthetic.main.user_profile_compact.view.*

class ComplexAdapter(var context: Context, var list: List<DataModel>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    val COMPACT_TYPE = 1
    val ROW_TYPE = 3


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var holder : RecyclerView.ViewHolder ?= null

        when(viewType){
            ROW_TYPE ->{
                holder= RowViewHolder(inflater.inflate(R.layout.user_activity,parent,false))
            }
            COMPACT_TYPE ->{
                 holder = CompactRecyclerViewHolder(inflater.inflate(R.layout.compact_layout,parent, false))
            }
        }
        return holder!!
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.e("COMPEX","SIZE: ${list.size}")
        if(list[position].type == ROW_TYPE){
            val person = list[position].personItem
            person?.let {
                (holder as RowViewHolder).bindItems(it)
            }

        } else if(list[position].type == COMPACT_TYPE){
            val adapter = list[position].adapter
            adapter?.let {
                (holder as CompactRecyclerViewHolder).bindItems(context,it)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type!!
    }

    fun updateList(newList: List<DataModel>){
        var diffResult = DiffUtil.calculateDiff(ComplexDiffUtilCallback(list,newList))
        list = newList
        diffResult.dispatchUpdatesTo(this)
    }

    class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(person: PersonItem){
            Picasso.get().load(person.photoUrl).into(itemView.user_activity_user_iv)
            val text = "${person.name} is meditating to XYASDFS"
            itemView.user_activity_tv.text = text
        }
    }

    class CompactRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(context: Context,adapter : UserProfileCompactAdapter){
            itemView.inner_recyclerView.layoutManager =
                LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            itemView.inner_recyclerView.adapter = adapter
        }
    }
}