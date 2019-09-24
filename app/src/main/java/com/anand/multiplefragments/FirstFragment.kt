package com.anand.multiplefragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactEvent = ViewModelProviders.of(activity!!).get(ContactEvent::class.java)

        btnSubmit.setOnClickListener {

            val name = inputName.text.toString()
            val phone = inputPhone.text.toString()

            val contact = Contact(name, phone)

            contactEvent.contact.value = contact

        }

    }

    //1st frag -> activity -> 2nd fragment

    //viewmodel -> activity
    //

}
