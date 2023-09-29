package com.example.test_app.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.test_app.ui.search.components.ResultCard
import com.example.test_app.ui.search.components.ResultContent
import com.example.test_app.ui.search.components.SearchBar

val resultContentList = listOf(
    ResultContent(0, "Title One", 9.0, true),
    ResultContent(1, "Title One", 9.0, false),
    ResultContent(2, "Title One", 9.0, false),
    ResultContent(3, "Title One", 9.0, false),
    ResultContent(0, "Title One", 9.0, true),
    ResultContent(1, "Title One", 9.0, false),
    ResultContent(2, "Title One", 9.0, false),
    ResultContent(3, "Title One", 9.0, false),
    ResultContent(0, "Title One", 9.0, true),
    ResultContent(1, "Title One", 9.0, false),
    ResultContent(2, "Title One", 9.0, false),
    ResultContent(3, "Title One", 9.0, false),
    ResultContent(0, "Title One", 9.0, true),
    ResultContent(1, "Title One", 9.0, false),
    ResultContent(2, "Title One", 9.0, false),
    ResultContent(3, "Title One", 9.0, false),
)

@Composable
fun SearchScreen(
    navController: NavController
) {
    Scaffold(
        backgroundColor = Color.Black,
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .statusBarsPadding()
            ) {
                SearchBar(
                    text = "",
                    readOnly = false,
                    onValueChange = {
//                event(SearchEvent.UpdateSearchQuery(it))
                    },
                    onSearch = {
//                event(SearchEvent.SearchNews)
                    }
                )
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier
                        .padding(padding)
                        .padding(vertical = 20.dp)
                ) {
                    items(resultContentList) { content ->
                        ResultCard(
                            resultContent = content
                        )
                    }
                }
            }
        }
    )
//    Column(
//        modifier = Modifier
//            .padding(8.dp)
//            .statusBarsPadding()
//    ) {
//        SearchBar(
//            text = "",
//            readOnly = false,
//            onValueChange = {
////                event(SearchEvent.UpdateSearchQuery(it))
//                            },
//            onSearch = {
////                event(SearchEvent.SearchNews)
//            }
//        )

}