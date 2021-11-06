package com.codylab.currency.converter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.codylab.currency.converter.databinding.FragmentConverterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ConverterFragment : Fragment() {
    private val viewModel: ConverterViewModel by viewModels()
    private lateinit var binding: FragmentConverterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConverterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { uiState ->
                renderUIState(uiState)
            }

            viewModel.events.collect { event: Event ->
                renderEvent(event)
            }
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.onLoad()
    }

    private fun renderUIState(uiState: ConverterUIState) {
        binding.progressBar.visibility = if (uiState.isLoading) {
            View.VISIBLE
        } else {
            View.GONE
        }

    }

    private fun renderEvent(event: Event) {
        Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
    }
}