package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToProduct.setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
        }

        buttonFilterInexpensive.setOnClickListener {
            showInexpensive()
        }

        buttonFilterByName.setOnClickListener {
            showCipp()
        }

    }

    private fun showInexpensive() {
        val products = ProductsData().allProducts().filter { it.cost < 200 }
        showProducts(products)
    }

    private fun showCipp() {
        val products =
            ProductsData().allProducts().filter { it.owner.contains(AppConfig.filterByName, true) }
        showProducts(products)
    }

    private fun showProducts(products: List<Product>) {

        productsTextView.text = ""

        var totalCost = 0.0
        products.forEach {
            productsTextView.append("${it.name} - ${it.owner} - ${it.yearPurchased} - $ ${it.cost} \n\n")
            totalCost += it.cost

        }

        totalCostTextView.text = "$ $totalCost"
    }

}
