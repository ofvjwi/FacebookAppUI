package com.example.facebookui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.facebookui.R
import com.example.facebookui.model.Story
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(private val context: Context, private val items: ArrayList<Story>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater =
            LayoutInflater.from(context).inflate(R.layout.item_story_view, parent, false)
        return StoryViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = items[position]

        if (holder is StoryViewHolder) {
            (holder as StoryViewHolder).imageViewBackground.setImageResource(story.profile)
            (holder as StoryViewHolder).imageViewProfile.setImageResource(story.profile)
            (holder as StoryViewHolder).textViewFullName.text = story.fullName
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private class StoryViewHolder(myItemView: View) : RecyclerView.ViewHolder(myItemView) {
        val imageViewBackground: ShapeableImageView =
            myItemView.findViewById(R.id.image_view_background_story)
        val imageViewProfile: ShapeableImageView =
            myItemView.findViewById(R.id.image_view_profile_story)
        val textViewFullName: TextView = myItemView.findViewById(R.id.text_view_full_name_story)
    }
}
