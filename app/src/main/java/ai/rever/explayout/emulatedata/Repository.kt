package ai.rever.explayout.emulatedata

import ai.rever.explayout.model.PersonItem
import android.os.Handler
import android.util.Log

class Repository {



    companion object{
        val ranIndex = 40
        val ranIndexTwo = 10

        fun createAPerson(): PersonItem{
            val index = (Math.random()*100).toInt()
            val person = PersonItem(randomNameList[index])
            return person
        }

        fun createNPerson(n: Int): MutableList<PersonItem>{
            val personList: MutableList<PersonItem> = mutableListOf()
            for(i in 1..n){
                personList.add(createAPerson())
            }
            return personList
        }

        fun addRandomData(){
            val datOne = liveDataOne.value
            datOne?.let {
                val index = (Math.random()* ranIndexTwo).toInt()
                for(i in 1..index){
                    val randomIndex = (Math.random()*it.size).toInt()
                    it.add(randomIndex,createAPerson())
                }
                liveDataOne.postValue(it)
            }

            val dataThree = liveDataThree.value
            dataThree?.let {
                val index = (Math.random()* ranIndex).toInt()
                for(i in 1..index){
                    val randomIndex = (Math.random()*it.size).toInt()
                    it.add(randomIndex,createAPerson())
                }
                liveDataThree.postValue(it)
            }

            val dataTwo = liveDataTwo.value
            dataTwo?.let {
                val index = (Math.random()* ranIndexTwo).toInt()
                for(i in 1..index){
                    val randomIndex = (Math.random()*it.size).toInt()
                    it.add(randomIndex,createAPerson())
                }
                liveDataTwo.postValue(it)
            }
        }

        fun deleteRandomData(){
            val datOne = liveDataOne.value
            datOne?.let {
                val index = (Math.random()* ranIndexTwo).toInt()
                for(i in 1..index){
                    val randomIndex = (Math.random()*it.size).toInt()
                    it.removeAt(randomIndex)
                }
                liveDataOne.postValue(it)
            }

            val dataThree = liveDataThree.value
            dataThree?.let {
                val index = (Math.random()*ranIndex).toInt()
                for(i in 1..index){
                    val randomIndex = (Math.random()*it.size).toInt()
                    it.removeAt(randomIndex)
                }
                liveDataThree.postValue(it)
            }

            val dataTwo = liveDataTwo.value
            dataTwo?.let {
                val index = (Math.random()* ranIndexTwo).toInt()
                for(i in 1..index){
                    val randomIndex = (Math.random()*it.size).toInt()
                    it.removeAt(randomIndex)
                }
                liveDataTwo.postValue(it)
            }
        }

        fun updateRandomData(){
            val dataOne = liveDataOne.value
            dataOne?.let {
                val size = (Math.random()* ranIndexTwo).toInt()
                for(i in 1..size){
                    val randomIndex = (Math.random()*it.size).toInt()
                    it[randomIndex].minutes = (Math.random()*15000).toInt()
                }

                liveDataOne.postValue(it)
            }

            val dataTwo = liveDataTwo.value
            dataTwo?.let {
                val size = (Math.random()* ranIndexTwo).toInt()
                for(i in 1..size){
                    val randomIndex = (Math.random()*it.size).toInt()
                    it[randomIndex].minutes = (Math.random()*15000).toInt()
                }

                liveDataTwo.postValue(it)
            }

            val dataThree = liveDataThree.value
            dataThree?.let {
                val size = (Math.random()*ranIndex).toInt()
                for(i in 1..size){
                    val randomIndex = (Math.random()*it.size).toInt()
                    it[randomIndex].minutes = (Math.random()*15000).toInt()
                }
                liveDataThree.postValue(it)
            }
        }

        fun moveDataRandomly(){
            val dataOne = liveDataOne.value
            dataOne?.let {
                val size = (Math.random()* ranIndexTwo).toInt()
                for(i in 1..size){
                    val randomIndex1 = (Math.random()*it.size).toInt()
                    val randomIndex2 = (Math.random()*it.size).toInt()
                    val p1 = it[randomIndex1]
                    it[randomIndex1] = it[randomIndex2]
                    it[randomIndex2] = p1
                }

                liveDataOne.postValue(it)
            }

            val dataTwo = liveDataTwo.value
            dataTwo?.let {
                val size = (Math.random()* ranIndexTwo).toInt()
                for(i in 1..size){
                    val randomIndex1 = (Math.random()*it.size).toInt()
                    val randomIndex2 = (Math.random()*it.size).toInt()
                    val p1 = it[randomIndex1]
                    it[randomIndex1] = it[randomIndex2]
                    it[randomIndex2] = p1
                }

                liveDataTwo.postValue(it)
            }

            val dataThree = liveDataThree.value
            dataThree?.let {
                val size = (Math.random()*ranIndex).toInt()
                for(i in 1..size){
                    val randomIndex1 = (Math.random()*it.size).toInt()
                    val randomIndex2 = (Math.random()*it.size).toInt()
                    val p1 = it[randomIndex1]
                    it[randomIndex1] = it[randomIndex2]
                    it[randomIndex2] = p1
                }
                liveDataThree.postValue(it)
            }
        }

        fun mockRealtimeOperations(){
            val handler = Handler()
            handler.postDelayed( object: Runnable {
                override fun run() {
                    operateOnData((Math.random()*5).toInt())
                    handler.postDelayed(this,5000)                }
            },1000)
            handler
        }

        fun operateOnData(action: Int){
            val TAG = "REPOSITORY"
            Log.d(TAG,"ACTION: $action")
            when(action){
                1 -> addRandomData()
                2 -> deleteRandomData()
                3 -> updateRandomData()
                4 -> moveDataRandomly()
            }
        }

    }
}