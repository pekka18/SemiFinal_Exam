package com.dignos.semifinal_exam.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dignos.semifinal_exam.PostActivity
import com.dignos.semifinal_exam.constants.Constants
import com.dignos.semifinal_exam.databinding.ItemPostBinding
import com.dignos.semifinal_exam.models.Post

class PostAdapter(
    private val activity: Activity,
    private val postList: List<Post>,
): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(
        private val activity: Activity,
        private val binding: ItemPostBinding,
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.name.text = post.name
            binding.description.text = post.description
            binding.item.setOnClickListener {
                val intent = Intent(activity, PostActivity::class.java)
                intent.putExtra(Constants.PARAM_ID, post.id)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(
            inflater,
            parent,
            false,
        )
        return PostViewHolder(activity, binding)
    }

    override fun getItemCount() = postList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }
}