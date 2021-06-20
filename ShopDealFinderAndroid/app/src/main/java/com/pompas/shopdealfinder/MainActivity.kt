package com.pompas.shopdealfinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pompas.shopdealfinder.models.Product
import com.pompas.shopdealfinder.viewModels.ProductViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MyApp()
            }
        }
    }

    @Composable
    fun MyApp() {
        productViewModel = viewModel()
        val products = productViewModel.products.observeAsState()
        products.value?.let { it -> ProductsList(it) }
    }

    @Composable
    fun ProductsList(products : List<Product>) {
        LazyColumn {
            itemsIndexed(products) { index, product ->
                Text("$product")
            }
        }
    }
}