package com.codylab.currency.converter.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.codylab.currency.converter.R
import com.codylab.currency.converter.mock.MOCK_CONVERSION_LIST
import com.codylab.currency.ui.theme.CurrencyTheme
import com.codylab.domain.Conversion

@Composable
fun ConversionList(conversions: List<Conversion>) {
    val smallPadding = dimensionResource(id = R.dimen.margin_small)
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        itemsIndexed(conversions) { _, conversion ->
            Row(
                modifier = Modifier.padding(
                    start = smallPadding,
                    top = smallPadding,
                    end = smallPadding
                )
            ) {
                Text(
                    style = MaterialTheme.typography.h6,
                    text = conversion.rate.to.code
                )
                Text(
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Right,
                    text = conversion.amount.toString()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CurrencyTheme(darkTheme = false) {
        ConversionList(MOCK_CONVERSION_LIST)
    }
}
