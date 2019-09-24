package com.anand.multiplefragments

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_layout.view.*

class ContactAdapter(val context: Context): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private val list = mutableListOf<Contact>()

    //add item to list and show to recyclerview
    fun addItem(contact: Contact?) {
        if (contact == null) {
            return
        }
        list.add(contact)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.contact_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contact = list[position]

        holder.txtName.text = contact.name
        holder.txtPhone.text = contact.phone

        holder.dltBtn.setOnClickListener {
            list.remove(contact)
            notifyDataSetChanged()
        }

        holder.itemView.setOnLongClickListener {

            val popupMenu = PopupMenu(context, it)
            popupMenu.menuInflater.inflate(R.menu.delete_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {

                if (it.itemId == R.id.action_delete) {
                    popupMenu.dismiss()
                    list.remove(contact)
                    notifyDataSetChanged()
                }

                true
            }
            popupMenu.show()

            true
        }

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val txtName = view.ctName
        val txtPhone = view.ctPhone
        val dltBtn = view.btItemDelete

    }

}