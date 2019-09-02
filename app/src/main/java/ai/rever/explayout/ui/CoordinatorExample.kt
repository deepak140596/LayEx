package ai.rever.explayout.ui

import ai.rever.explayout.R
import ai.rever.explayout.adapter.UserActivityAdapter
import ai.rever.explayout.adapter.UserProfileCompactAdapter
import ai.rever.explayout.emulatedata.Repository
import ai.rever.explayout.emulatedata.liveDataOne
import ai.rever.explayout.emulatedata.liveDataThree
import ai.rever.explayout.emulatedata.liveDataTwo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_coordinator_example.*
import kotlinx.android.synthetic.main.coordinator_backdrop.*
import kotlinx.android.synthetic.main.user_profile.*

class CoordinatorExample : AppCompatActivity() {

    lateinit var adapterOne : UserProfileCompactAdapter
    lateinit var adapterTwo : UserProfileCompactAdapter
    lateinit var trendingAdapter : UserActivityAdapter

    val currentUser = Repository.createAPerson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_example)

        setupSocialData()
        setupUI()
        observeLiveData()
        Repository.mockRealtimeOperations()
    }

    fun setupSocialData(){
        currentUser.followers = Repository.createNPerson((Math.random()*500).toInt())
        currentUser.following = Repository.createNPerson((Math.random()*500).toInt())
    }

    fun setupUI(){

        activityCoordinatorLayoutTrendingRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        coordinatorBackdropRVOne.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        coordinatorBackdropRVTwo.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
//
//        adapterOne = UserProfileCompactAdapter(Repository.createNPerson(20))
//        adapterTwo = UserProfileCompactAdapter(Repository.createNPerson(15))
//
//        trendingAdapter = UserActivityAdapter(Repository.createNPerson(100))


        adapterOne = UserProfileCompactAdapter(emptyList())
        adapterTwo = UserProfileCompactAdapter(emptyList())

        trendingAdapter = UserActivityAdapter(emptyList())

        activityCoordinatorLayoutTrendingRecyclerView.adapter = trendingAdapter
        coordinatorBackdropRVOne.adapter = adapterOne
        coordinatorBackdropRVTwo.adapter = adapterTwo

        profileBreathsTv.text = currentUser.breaths.toString() + " Breaths"
        profileMinutesTv.text = currentUser.minutes.toString() + " Minutes"
        profileFollowersCountTv.text = currentUser.followers.size.toString() + " Followers"
        profileFollowingCountTv.text = currentUser.following.size.toString() + " Following"

        Picasso.get().load(currentUser.photoUrl).into(profileImageView)
    }

    fun observeLiveData(){
        liveDataOne.observe(this, Observer {list ->
            list?.let {
                adapterOne.personList = it
                adapterOne.notifyDataSetChanged()
            }
        })
        liveDataTwo.observe(this, Observer { list ->
            list?.let {
                adapterTwo.personList = it
                adapterTwo.notifyDataSetChanged()
            }
        })

        liveDataThree.observe(this, Observer {list ->
            list?.let {
                trendingAdapter.personList = it
                trendingAdapter.notifyDataSetChanged()
            }
        })
    }
}
