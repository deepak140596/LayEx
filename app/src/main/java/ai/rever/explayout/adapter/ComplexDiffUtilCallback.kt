package ai.rever.explayout.adapter

import ai.rever.explayout.model.DataModel
import androidx.recyclerview.widget.DiffUtil

class ComplexDiffUtilCallback(var oldPersons: List<DataModel>,
                         var newPersons: List<DataModel>) : DiffUtil.Callback(){

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldPersons[oldItemPosition].hashCode() == newPersons[newItemPosition].hashCode()
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