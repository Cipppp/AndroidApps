package com.example.myapplication

class ProductsData {
    fun allProducts(): List<Product> {
        val products = listOf(
            Product("iPod", "Cipp", 2006, 214.12),
            Product("Car", "Dan", 2006, 534.12),
            Product("Laptop", "Cipps", 2006, 144.31),
            Product("Phone", "Bill", 2006, 973.86),
            Product("House", "Bob", 2006, 5216.78)
        )

        return products
    }
}