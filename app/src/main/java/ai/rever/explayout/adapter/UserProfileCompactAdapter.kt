package ai.rever.explayout.adapter

import ai.rever.explayout.R
import ai.rever.explayout.model.PersonItem
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_profile_compact.view.*

class UserProfileCompactAdapter(var personList: List<PersonItem>) : RecyclerView.Adapter<UserProfileCompactAdapter.MyViewHolder>(){
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.e("COMPACT","SIZE: ${personList.size}")

        val person = personList[position]
        holder.bindItems(person)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_profile_compact,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personList.size
    }
    fun updateList(newList: List<PersonItem>){
        var diffResult = DiffUtil.calculateDiff(MyDiffUtilCallback(this.personList,newList))
        personList = newList
        diffResult.dispatchUpdatesTo(this)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(person: PersonItem){
            Picasso.get().load(person.photoUrl).into(itemView.userProfileCompactIv)
            itemView.userProfileCompactNameTv.text = person.name
        }
    }
}