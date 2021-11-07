package com.codylab.currency.converter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.codylab.currency.converter.mock.MOCK_CONVERSION_LIST
import com.codylab.currency.converter.mock.MOCK_CURRENCY_LIST
import com.codylab.currency.converter.mock.MOCK_SELECTED_CURRENCY
import com.codylab.currency.converter.ui.ConversionList
import com.codylab.currency.converter.ui.CurrencyDropdown
import com.codylab.currency.ui.theme.CurrencyTheme
import com.codylab.domain.Conversion
import com.codylab.domain.Currency
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConverterFragment : Fragment() {
    private val viewModel: ConverterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                CurrencyTheme {
                    ConverterScreen(
                        currencyList = MOCK_CURRENCY_LIST,
                        selectedCurrency = MOCK_SELECTED_CURRENCY,
                        conversionList = MOCK_CONVERSION_LIST,
                        onSelectCurrency = viewModel::onCurrencySelect,
                        onAmountUpdate = viewModel::onAmountUpdate
                    )
                }
            }
        }
    }
}

@Composable
fun ConverterScreen(
    currencyList: List<Currency>,
    selectedCurrency: Currency,
    conversionList: List<Conversion>,
    onSelectCurrency: (Currency) -> Unit,
    onAmountUpdate: (Float) -> Unit
) {
    var amount by remember { mutableStateOf("0") }

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
            value = amount,
            onValueChange = { value ->
                value.toFloatOrNull()?.let {
                    amount = value.removePrefix("0")
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
        ConverterScreen(currencyList, selectedCurrency, conversionList, {}, {})
    }
}
