package ai.rever.explayout.adapter

import ai.rever.explayout.model.PersonItem
import androidx.recyclerview.widget.DiffUtil

class MyDiffUtilCallback(var oldPersons: List<PersonItem>,
                         var newPersons: List<PersonItem>) : DiffUtil.Callback(){

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldPersons[oldItemPosition].id == newPersons[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldPersons.size
    }

    override fun getNewListSize(): Int {
        return newPersons.size
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldPersons[oldItemPosition].equals(newPersons[newItemPosition])
    }
}