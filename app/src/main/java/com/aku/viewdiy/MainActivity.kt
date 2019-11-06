package com.aku.viewdiy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.aku.viewdiy.tree.TreeView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(TreeView(this))
    }
}
