package com.example.facebookui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebookui.R
import com.example.facebookui.model.Feed
import com.example.facebookui.model.Story
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(private val context: Context, private val items: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val ITEM_HEADER: Int = 0
        private const val ITEM_STORY: Int = 1
        private const val ITEM_POST: Int = 2
    }

    override fun getItemViewType(position: Int): Int {
        val feed = items[position]

        return when {
            feed.isHeader -> {
                ITEM_HEADER
            }
            feed.stories.size > 0 -> {
                ITEM_STORY
            }
            else -> {
                ITEM_POST
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_HEADER -> {
                val layoutInflater =
                    LayoutInflater.from(context).inflate(R.layout.item_feed_head, parent, false)
                HeaderViewHolder(layoutInflater)
            }
            ITEM_STORY -> {
                val layoutInflater =
                    LayoutInflater.from(context).inflate(R.layout.item_feed_story, parent, false)
                StoryViewHolder(layoutInflater)
            }
            else -> {
                val layoutInflater =
                    LayoutInflater.from(context).inflate(R.layout.item_feed_post, parent, false)
                PostViewHolder(layoutInflater)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        when (holder) {
            is HeaderViewHolder -> {
                (holder as HeaderViewHolder)
            }
            is StoryViewHolder -> {
                val recyclerView = (holder as StoryViewHolder).recyclerView
                recyclerView.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                refreshAdapter(recyclerView, feed.stories)
            }
            else -> {
                (holder as PostViewHolder).imageViewPost.setImageResource(feed.post!!.photo)
                (holder as PostViewHolder).imageViewProfile.setImageResource(feed.post.photo)
                (holder as PostViewHolder).textViewFullName.text = feed.post.fullName
            }
        }
    }

    private fun refreshAdapter(recyclerView: RecyclerView, items: ArrayList<Story>) {
        val adapter = StoryAdapter(context, items)
        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private class PostViewHolder(myItemView: View) : RecyclerView.ViewHolder(myItemView) {
        val imageViewProfile: ShapeableImageView =
            myItemView.findViewById(R.id.image_view_profile_post)
        val imageViewPost: ImageView =
            myItemView.findViewById(R.id.image_view_photo_post_item)
        val textViewFullName: TextView = myItemView.findViewById(R.id.text_view_full_name_post_item)
    }

    private class StoryViewHolder(myItemView: View) : RecyclerView.ViewHolder(myItemView) {
        val recyclerView: RecyclerView = myItemView.findViewById(R.id.recycler_view_story)
    }

    private class HeaderViewHolder(myItemView: View) : RecyclerView.ViewHolder(myItemView) {
        val imageViewProfile: ShapeableImageView =
            myItemView.findViewById(R.id.image_profile_head_item)
    }
}
