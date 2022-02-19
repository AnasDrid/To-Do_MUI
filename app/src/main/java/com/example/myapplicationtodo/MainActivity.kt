package com.example.myapplicationtodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val todoFragment=TodoFragment()
    private val doneFragment=DoneFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomnavigationview.background=null
        bottomnavigationview.menu.getItem(1).isEnabled=false
        replacefragment(todoFragment)
        bottomnavigationview.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Todo->replacefragment(todoFragment)
                R.id.Done->replacefragment(doneFragment)
            }
            true
        }

    }
    private fun replacefragment(fragment: Fragment){
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentcontainer,fragment)
        transaction.commit()
    }
}