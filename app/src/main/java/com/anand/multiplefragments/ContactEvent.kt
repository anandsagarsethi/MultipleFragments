package com.anand.multiplefragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactEvent: ViewModel() {

    val contact = MutableLiveData<Contact>()

}