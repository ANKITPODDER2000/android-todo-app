package com.example.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TopAppBarViewModel @Inject constructor() : ViewModel() {
    private val _isSearchBarVisible = MutableStateFlow(false)
    val isSearchBarVisible: StateFlow<Boolean>
        get() = _isSearchBarVisible.asStateFlow()

    fun toggleSearchAppBar() {
        _isSearchBarVisible.update { !_isSearchBarVisible.value }
    }

    private val _searchedText = MutableStateFlow("")
    val searchedText: StateFlow<String>
        get() = _searchedText.asStateFlow()

    fun handleSearchedTextChange(searchedText: String) {
        _searchedText.update { searchedText }
    }


}