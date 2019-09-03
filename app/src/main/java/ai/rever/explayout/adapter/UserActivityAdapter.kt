package ai.rever.explayout.adapter

import ai.rever.explayout.R
import ai.rever.explayout.model.PersonItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_activity.view.*

class UserActivityAdapter(var personList: List<PersonItem>) : RecyclerView.Adapter<UserActivityAdapter.MyViewHolder>(){
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val person = personList[position]
        holder.bindItems(person)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_activity,parent,false)
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
            Picasso.get().load(person.photoUrl).into(itemView.user_activity_user_iv)
            val text = "${person.name} is meditating to XYASDFS"
            itemView.user_activity_tv.text = text
        }
    }
}