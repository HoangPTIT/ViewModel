package com.example.hdev.sharedata

import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hdev.sharedata.UserNameAdapter.UserNameViewHolder
import com.example.hdev.viewmodelsample.R
import kotlinx.android.synthetic.main.item_user_name.view.textUserNameItem

class UserNameAdapter(@NonNull private val usersName: List<String>, private val itemSelected: (userName: String) -> Unit) :
    RecyclerView.Adapter<UserNameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): UserNameViewHolder {
        return UserNameViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_name, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return usersName.size
    }

    override fun onBindViewHolder(holder: UserNameViewHolder, position: Int) {
        holder.bindView(usersName[position])
    }

    inner class UserNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(userName: String) {
            with(itemView) {
                textUserNameItem.text = userName
                setOnClickListener { itemSelected(userName) }
            }
        }
    }
}
