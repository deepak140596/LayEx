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
import kotlinx.android.synthetic.main.activity_nested_scroll_example.*
import kotlinx.android.synthetic.main.coordinator_backdrop.*
import kotlinx.android.synthetic.main.user_profile.*

class NestedScrollExample : AppCompatActivity() {

    lateinit var adapterOne : UserProfileCompactAdapter
    lateinit var adapterTwo : UserProfileCompactAdapter
    lateinit var trendingAdapter : UserActivityAdapter

    val currentUser = Repository.createAPerson(1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_scroll_example)

        setupSocialData()
        setupUI()
        observeLiveData()
    }

    fun setupSocialData(){
        currentUser.followers = Repository.createNPerson(1,(Math.random()*500).toInt())
        currentUser.following = Repository.createNPerson(1,(Math.random()*500).toInt())
    }

    fun setupUI(){

        nestedScrollRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        coordinatorBackdropRVOne.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        coordinatorBackdropRVTwo.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        nestedScrollRecyclerView.setHasFixedSize(true)
        coordinatorBackdropRVOne.setHasFixedSize(true)
        coordinatorBackdropRVTwo.setHasFixedSize(true)

        adapterOne = UserProfileCompactAdapter(emptyList())
        adapterTwo = UserProfileCompactAdapter(emptyList())

        trendingAdapter = UserActivityAdapter(emptyList())

        nestedScrollRecyclerView.adapter = trendingAdapter
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
                adapterOne.updateList(it)
            }
        })
        liveDataTwo.observe(this, Observer { list ->
            list?.let {
                adapterTwo.updateList(it)
            }
        })

        liveDataThree.observe(this, Observer {list ->
            list?.let {
                trendingAdapter.updateList(it)
            }
        })
    }
}
