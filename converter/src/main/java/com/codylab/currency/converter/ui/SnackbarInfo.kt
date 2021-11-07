package com.codylab.currency.converter.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.codylab.currency.converter.R

@Composable
fun SnackbarInfo(
    modifier: Modifier = Modifier,
    message: String
) {
    Column {
        Snackbar(modifier = modifier.padding(dimensionResource(id = R.dimen.margin_small))) {
            Text(text = message)
        }
    }
}