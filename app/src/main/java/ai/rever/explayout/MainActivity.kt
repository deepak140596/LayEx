package ai.rever.explayout

import ai.rever.explayout.emulatedata.Repository
import ai.rever.explayout.emulatedata.liveDataOne
import ai.rever.explayout.emulatedata.liveDataThree
import ai.rever.explayout.emulatedata.liveDataTwo
import ai.rever.explayout.ui.CoordinatorExample
import ai.rever.explayout.ui.HeterogenousExample
import ai.rever.explayout.ui.NestedScrollExample
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_heterogenous_example.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityStartCoordinatorExampleBtn.setOnClickListener {
            startActivity(Intent(this,CoordinatorExample::class.java))
        }

        mainActivityStartScrollingExampleBtn.setOnClickListener {
            startActivity(Intent(this,NestedScrollExample::class.java))
        }
        mainActivityHetRvBtn.setOnClickListener {
            startActivity(Intent(this,HeterogenousExample::class.java))
        }
        setupData()

    }

    fun setupData(){
        liveDataOne.value = Repository.createNPerson(1,160)
        liveDataTwo.value = Repository.createNPerson(1,240)
        liveDataThree.value = Repository.createNPerson(3,1500)

        Repository.mockRealtimeOperations()
    }
}
