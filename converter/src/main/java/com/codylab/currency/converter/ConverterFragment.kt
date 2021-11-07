package com.codylab.currency.converter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.codylab.currency.converter.design.CurrencyTheme
import com.codylab.currency.converter.ui.ConverterScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ConverterFragment : Fragment() {
    private val viewModel: ConverterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel.onLoad()

        return ComposeView(requireContext()).apply {
            setContent {
                CurrencyTheme {
                    val amount by viewModel.amount.collectAsState()
                    val selectedCurrency by viewModel.selectedCurrency.collectAsState()
                    val currencyList by viewModel.currencyList.collectAsState()
                    val conversionList by viewModel.conversionList.collectAsState()
                    val message by viewModel.message.collectAsState()

                    ConverterScreen(
                        currencyList = currencyList,
                        selectedCurrency = selectedCurrency,
                        conversionList = conversionList,
                        amount = amount,
                        message = message,
                        onSelectCurrency = viewModel::onCurrencySelect,
                        onAmountUpdate = viewModel::onAmountUpdate
                    )
                }
            }
        }
    }
}
