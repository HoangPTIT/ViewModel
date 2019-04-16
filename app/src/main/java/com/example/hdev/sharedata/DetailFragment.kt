package com.example.hdev.sharedata

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hdev.viewmodelsample.R
import kotlinx.android.synthetic.main.fragment_detail.textUserNameDetail

class DetailFragment : Fragment() {

    private val sharedViewModel by lazy {
        activity?.let {
            ViewModelProviders.of(it).get(SharedViewModel::class.java)
        } ?: throw Exception("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        displayUserDetail()
    }

    private fun displayUserDetail() {
        textUserNameDetail.text = sharedViewModel.selectedUserName
    }
}
