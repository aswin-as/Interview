package com.example.interviewround.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.interviewround.model.UserViewModel


@Composable
fun UserList(
    userViewModel: UserViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val comments = userViewModel.users.collectAsState()

    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(comments.value) { comment ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Text(text = comment.user.username)
                Text(text = comment.body)
            }
        }
    }
}




// The problem caused
/* Actually the dependency i added in the gradle is wrong, i didn't noticed,. */

// The findings

/*
*  u
* */

@Preview
@Composable
fun UserListPreview(modifier: Modifier = Modifier) {
    UserList()
}

