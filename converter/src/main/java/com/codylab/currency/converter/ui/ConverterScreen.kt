package com.codylab.currency.converter.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.codylab.currency.converter.R
import com.codylab.currency.converter.design.CurrencyTheme
import com.codylab.currency.converter.ui.mock.MOCK_CONVERSION_LIST
import com.codylab.currency.converter.ui.mock.MOCK_CURRENCY_LIST
import com.codylab.currency.converter.ui.mock.MOCK_SELECTED_CURRENCY
import com.codylab.domain.Conversion
import com.codylab.domain.Currency

@Composable
fun ConverterScreen(
    currencyList: List<Currency>,
    selectedCurrency: Currency,
    conversionList: List<Conversion>,
    amount: Float,
    onSelectCurrency: (Currency) -> Unit,
    onAmountUpdate: (Float) -> Unit
) {
    Column(
        modifier = Modifier.padding(dimensionResource(R.dimen.margin_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.margin_small))
    ) {
        Text(
            text = stringResource(R.string.converter_title),
            style = MaterialTheme.typography.h4,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        TextField(
            value = amount.toString(),
            onValueChange = { value ->
                value.toFloatOrNull()?.let {
                    onAmountUpdate(it)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = MaterialTheme.typography.h6.copy(textAlign = TextAlign.End),
            maxLines = 1,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )
        CurrencyDropdown(currencyList, selectedCurrency, onSelectCurrency)
        ConversionList(conversionList)
    }
}

@Preview(showBackground = true)
@Composable
fun ConverterPreview() {
    CurrencyTheme(darkTheme = false) {
        val currencyList = MOCK_CURRENCY_LIST
        val selectedCurrency = MOCK_SELECTED_CURRENCY
        val conversionList = MOCK_CONVERSION_LIST
        val amount = 100.0f
        ConverterScreen(currencyList, selectedCurrency, conversionList, amount, {}, {})
    }
}
