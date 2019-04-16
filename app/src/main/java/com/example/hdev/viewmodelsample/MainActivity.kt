package com.example.hdev.viewmodelsample

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import kotlinx.android.synthetic.main.activity_main.buttonScoreTeamA
import kotlinx.android.synthetic.main.activity_main.buttonScoreTeamB
import kotlinx.android.synthetic.main.activity_main.textScoreTeamA
import kotlinx.android.synthetic.main.activity_main.textScoreTeamB

class MainActivity : AppCompatActivity(), OnClickListener {

    private val viewModel by lazy { ViewModelProviders.of(this).get(ScoreViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        displayScoreTeamA()
        displayScoreTeamB()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonScoreTeamA -> addOneForTeamA()
            R.id.buttonScoreTeamB -> addOneForTeamB()
        }
    }

    private fun initComponents(){
        buttonScoreTeamA.setOnClickListener(this)
        buttonScoreTeamB.setOnClickListener(this)
    }

    private fun addOneForTeamA() {
        viewModel.scoreTeamA = viewModel.scoreTeamA + 1
        displayScoreTeamA()
    }

    private fun addOneForTeamB() {
        viewModel.scoreTeamB = viewModel.scoreTeamB + 1
        displayScoreTeamB()
    }

    private fun displayScoreTeamA() {
        textScoreTeamA.text = viewModel.scoreTeamA.toString()
    }

    private fun displayScoreTeamB() {
        textScoreTeamB.text = viewModel.scoreTeamB.toString()
    }
}
