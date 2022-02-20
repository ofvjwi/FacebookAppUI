package com.example.facebookui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebookui.R
import com.example.facebookui.adapter.FeedAdapter
import com.example.facebookui.model.Feed
import com.example.facebookui.model.Post
import com.example.facebookui.model.Story

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        context = this

        recyclerView = findViewById(R.id.recycler_view_main)
        recyclerView.layoutManager = GridLayoutManager(context, 1)

        refreshAdapter(prepareFeedList())
    }

    private fun refreshAdapter(items: ArrayList<Feed>) {
        val adapter = FeedAdapter(context, items)
        recyclerView.adapter = adapter
    }

    private fun prepareFeedList(): ArrayList<Feed> {
        val feeds = ArrayList<Feed>()
        feeds.add(Feed(true))

        val stories = ArrayList<Story>()
        for (i in 1..20) stories.add(Story(R.drawable.im_user_profile, "Khurshidbek Kurbanov"))

        feeds.add(Feed(stories = stories))

        for (i in 1..20) {
            feeds.add(
                Feed(
                    post = Post(
                        R.drawable.im_post_2,
                        "Khurshidbek Kurbanov",
                        R.drawable.im_post_2
                    )
                )
            )
            feeds.add(
                Feed(
                    post = Post(
                        R.drawable.im_post_3,
                        "Khurshidbek Kurbanov",
                        R.drawable.im_post_3
                    )
                )
            )

            feeds.add(
                Feed(
                    post = Post(
                        R.drawable.im_post_4,
                        "Khurshidbek Kurbanov",
                        R.drawable.im_post_4
                    )
                )
            )

            feeds.add(
                Feed(
                    post = Post(
                        R.drawable.im_post_5,
                        "Khurshidbek Kurbanov",
                        R.drawable.im_post_6
                    )
                )
            )
            feeds.add(
                Feed(
                    post = Post(
                        R.drawable.im_post_6,
                        "Khurshidbek Kurbanov",
                        R.drawable.im_post_6
                    )
                )
            )
        }
        return feeds
    }
}









