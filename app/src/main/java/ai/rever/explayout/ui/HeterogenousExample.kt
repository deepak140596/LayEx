package ai.rever.explayout.ui

import ai.rever.explayout.R
import ai.rever.explayout.adapter.ComplexAdapter
import ai.rever.explayout.adapter.UserProfileCompactAdapter
import ai.rever.explayout.emulatedata.liveDataOne
import ai.rever.explayout.emulatedata.liveDataThree
import ai.rever.explayout.emulatedata.liveDataTwo
import ai.rever.explayout.model.DataModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_heterogenous_example.*

class HeterogenousExample : AppCompatActivity() {

    lateinit var complexAdapter: ComplexAdapter
    lateinit var adapterOne: UserProfileCompactAdapter
    lateinit var adapterTwo: UserProfileCompactAdapter
    lateinit var dataModel1 : DataModel
    lateinit var dataModel2: DataModel
    val list: MutableList<DataModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heterogenous_example)

        setupRecyclerView()
        observeLiveData()
    }

    fun setupRecyclerView(){

        heterogenous_rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapterOne = UserProfileCompactAdapter(liveDataOne.value!!)
        adapterTwo = UserProfileCompactAdapter(liveDataTwo.value!!)

        dataModel1 = DataModel(1,adapterOne,null)
        dataModel2 = DataModel(1,adapterTwo, null)
        list.add(dataModel1)
        list.add(dataModel2)
        complexAdapter = ComplexAdapter(this, list)
        heterogenous_rv.adapter = complexAdapter
    }

    fun observeLiveData(){
         liveDataOne.observe(this, androidx.lifecycle.Observer {
             adapterOne.updateList(it)
//             dataModel1 = DataModel(1,adapterOne,null)
//             list.add(dataModel1)
//             complexAdapter.list = list
//             complexAdapter.notifyDataSetChanged()
         })

        liveDataTwo.observe(this, androidx.lifecycle.Observer {
            adapterTwo.updateList(it)
//            dataModel2 = DataModel(1,adapterTwo, null)
//            list.add(dataModel2)
//            complexAdapter.list = list
//            complexAdapter.notifyDataSetChanged()
        })

        liveDataThree.observe(this, androidx.lifecycle.Observer {
            list.clear()
            list.add(dataModel1)
            list.add(dataModel2)
            for(item in it){
                list.add(DataModel(3,null,item))
            }
            complexAdapter.updateList(list)
        })
    }
}
