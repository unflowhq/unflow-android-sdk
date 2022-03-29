package com.unflow.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unflow.androidsdk.UnflowSdk
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // See layout for how to add an OpenerView
        setContentView(R.layout.activity_main)

        // We can customise the layout of the openers completely – here we
        // take just the first three and put them in a vertical list
        val customOpenerAdapter = CustomOpenerAdapter()
        findViewById<RecyclerView>(R.id.customOpenerLayout).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = customOpenerAdapter
        }
        lifecycleScope.launch {
            UnflowSdk.client().openers()
                .collectLatest {
                    customOpenerAdapter.setItems(it.take(3))
                }
        }
    }
}