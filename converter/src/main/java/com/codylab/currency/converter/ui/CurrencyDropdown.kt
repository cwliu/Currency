package com.codylab.currency.converter.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import com.codylab.currency.converter.R
import com.codylab.domain.Currency


// Reference: https://foso.github.io/Jetpack-Compose-Playground/material/dropdownmenu/
@Composable
fun CurrencyDropdown(
    currencies: List<Currency>,
    selectedCurrency: Currency,
    onCurrencySelect: (Currency) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val items = currencies.map { "${it.code} ${it.name}" }
    val index = if (currencies.indexOf(selectedCurrency) != -1) {
        currencies.indexOf(selectedCurrency)
    } else {
        0
    }
    var selectedIndex by remember {
        mutableStateOf(index)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopStart)
            .padding(dimensionResource(id = R.dimen.margin_small))
    ) {
        Text(
            text = items.getOrNull(selectedIndex) ?: "",
            textAlign = TextAlign.Right,
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true })
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                    onCurrencySelect(currencies[index])
                }) {
                    Text(text = s)
                }
            }
        }
    }
}