package com.example.wishlist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var items: ArrayList<Item> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val nameEdit = findViewById<EditText>(R.id.item_name)
        val priceEdit = findViewById<EditText>(R.id.price)
        val urlEdit = findViewById<EditText>(R.id.URL)
        // Lookup the recyclerview in activity layout
        val rvItems = findViewById<RecyclerView>(R.id.RV)

        val adapter = ItemAdapter(items)
        rvItems.adapter = adapter
        // Set layout manager to position the items
        rvItems.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            it.hideKeyboard()
            // Attach the adapter to the recyclerview to populate items
            val name = nameEdit.text.toString()
            val price = priceEdit.text.toString()
            val url = urlEdit.text.toString()


            items.add(Item(name, url, price))

            nameEdit.text.clear()
            priceEdit.text.clear()
            urlEdit.text.clear()
            adapter.notifyDataSetChanged()
            // That's all!

        }
    }
    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}