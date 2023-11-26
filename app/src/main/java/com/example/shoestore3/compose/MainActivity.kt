package com.example.shoestore3.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Database
import androidx.room.Room
import com.example.shoestore3.compose.theme.ShoeStore3Theme
import com.example.shoestore3.db.ShoeStoreDB
import com.example.shoestore3.db.ShoeStoreTable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var database: ShoeStoreDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ShoeStore3Theme {
//                // A surface container using the 'background' color from the theme Surface(
//                 modifier = Modifier.fillMaxSize(),
//                   color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
//                }
//            }
            //   }
            database = Room.databaseBuilder(
                applicationContext,
                ShoeStoreDB::class.java,
                "ShoeStoreDb"
            ).build()

            GlobalScope.launch {
                database.shoestoreDao().insertShoeStore(
                    ShoeStoreTable(
                        "white shoe",
                        "nike",
                        "39",
                        "This shoe is very comfortable"
                    )
                )
            }

            database.shoestoreDao().getAllShoeStore().observe(this) {
                Log.d("ROOMDB", "onCreate: $it")
            }
        }
//    @Composable
//    fun Greeting(name: String, modifier: Modifier = Modifier) {
//        Text(
//            text = "Hello $name!",
//            modifier = modifier
//        )}

//    @Preview(showBackground = true)
//    @Composable
//    fun GreetingPreview() {
//        ShoeStore3Theme {
//            Greeting("Android")
//        }
//    }
}}

