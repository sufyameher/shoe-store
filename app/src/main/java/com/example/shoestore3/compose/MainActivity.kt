package com.example.shoestore3.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.example.shoestore3.db.ShoeStoreDatabase
import com.example.shoestore3.db.ShoeStoreEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var database: ShoeStoreDatabase
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
                ShoeStoreDatabase::class.java,
                "ShoeStoreDb"
            ).build()

            GlobalScope.launch {
                database.shoestoreDao().insertShoeStore(
                    ShoeStoreEntity(
                        "0",
                        "white shoe",
                        "nike",
                        "39",
                        "This shoe is very comfortable")
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

