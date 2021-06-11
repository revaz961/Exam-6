package com.example.exam6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam6.databinding.ArticleLayoutBinding

class ArticleAdapter(val update:(Article)->Unit,val delete: (Article) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var articles = mutableListOf<Article>()
    fun setUsers(list: List<Article>) {
        articles.clear()
        articles.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(
            ArticleLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserViewHolder -> holder.bind()
        }
    }

    override fun getItemCount() = articles.size

    inner class UserViewHolder(val binding: ArticleLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.tvTitle.text = articles[adapterPosition].title
            binding.tvDescription.text = articles[adapterPosition].description

            binding.btnRemove.setOnClickListener {
                delete(articles[adapterPosition])
            }
            binding.btnEdit.setOnClickListener {
                update(articles[adapterPosition])
            }
        }
    }
}