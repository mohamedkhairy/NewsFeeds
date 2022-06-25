package com.example.newsfeeds.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsfeeds.presentation.component.MainAppBar
import com.example.newsfeeds.presentation.component.menu.DrawerBody
import com.example.newsfeeds.presentation.component.menu.DrawerHeader
import com.example.newsfeeds.presentation.component.menu.MenuId
import com.example.newsfeeds.presentation.component.menu.MenuItem
import com.example.newsfeeds.presentation.ui.theme.NewsFeedsTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import com.example.newsfeeds.R


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    private val articlesViewModel: ArticlesViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsFeedsTheme {
                val context = LocalContext.current
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        MainAppBar(
                            onNavigationIconClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        )
                    } ,

                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = MenuId.Explore,
                                    title = "Explore",
                                    contentDescription = "Explore",
                                    icon = R.drawable.explore
                                ),
                                MenuItem(
                                    id = MenuId.LiveChat,
                                    title = "Live Chat",
                                    contentDescription = "Live Chat",
                                    icon = R.drawable.live,
                                ),
                                MenuItem(
                                    id = MenuId.Gallery,
                                    title = "Gallery",
                                    contentDescription = "Gallery",
                                    icon = R.drawable.gallery
                                ),
                                MenuItem(
                                    id = MenuId.WishList,
                                    title = "Wish List",
                                    contentDescription = "Wish List",
                                    icon = R.drawable.wishlist
                                ),
                                MenuItem(
                                    id = MenuId.Magazine,
                                    title = "E-Magazine",
                                    contentDescription = "E-Magazine",
                                    icon = R.drawable.magazine
                                ),
                            ),
                            onItemClick = {
                                Toast.makeText(context , it.title , Toast.LENGTH_SHORT).show()
                            }
                        )
                    }


                ) {

                    DestinationsNavHost(navGraph = NavGraphs.root)


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsFeedsTheme {
        Greeting("Android")
    }
}