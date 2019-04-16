package com.example.hdev.sharedata

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hdev.viewmodelsample.R
import kotlinx.android.synthetic.main.fragment_master.recyclerUsers

class MasterFragment : Fragment() {
    private lateinit var adapter: UserNameAdapter
    private lateinit var usersName: List<String>
    private val sharedViewModel by lazy {
        activity?.let {
            ViewModelProviders.of(it).get(SharedViewModel::class.java)
        } ?: throw Exception("")
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_master, container, false)
    }

    override fun onViewCreated(@NonNull view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
    }

    private fun initComponents() {
        try {
            usersName = resources.getStringArray(R.array.users_name).toList()
            adapter = UserNameAdapter(usersName) { userName -> itemSelected(userName) }
            recyclerUsers.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recyclerUsers.adapter = adapter
        } catch (e: Exception) {
            // Not found users name
        }
    }

    private fun itemSelected(userName: String) {
        sharedViewModel.selectedUserName = userName
    }
}
