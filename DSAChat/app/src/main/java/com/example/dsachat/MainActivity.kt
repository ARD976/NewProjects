package com.example.dsachat

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.update_dialogue.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: DSAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DSAdapter(this)
        recyclerView.adapter = adapter

        addButton.setOnClickListener {
            addDSAInList()
        }

    }

    private fun addDSAInList() {
        var list = ArrayList<DSA>()
        val type = dsaTitle.text.toString()
        val count = dsaCount.text.toString().toInt()
        val date = dsaDate.text.toString()
        val dsa = DSA(0 , type , count , date)
        val databaseHandler = DatabaseHandler(this)
        if(type.isNotEmpty() && date.isNotEmpty()){
            databaseHandler.addDSA(dsa)
            list = databaseHandler.viewDSA()
            adapter.updateList(list)}
    }

    fun addUpdateDialog(dsa : DSA) {
        val dialog = Dialog(this , R.style.Theme_Dialog)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.update_dialogue)
        dialog.etType.setText(dsa.type)
        dialog.etCount.setText(dsa.count)
        dialog.etDate.setText(dsa.date)
        dialog.update.setOnClickListener {
            val databaseHandler = DatabaseHandler(this)
            val type = dialog.etType.text.toString()
            val count = dialog.etType.text.toString().toInt()
            val date = dialog.etDate.text.toString()
            if(type.isNotEmpty() && date.isNotEmpty()){
                databaseHandler.updateDSA(DSA(dsa.id , type , count , date))
                adapter.updateList(databaseHandler.viewDSA())}
            dialog.dismiss()
        }
        dialog.cancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    fun addDeleteDialog(dsa : DSA) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Delete Dialog")
        dialog.setMessage("Are yo really want to delete ${dsa.type}")
        dialog.setPositiveButton("Yes") { dialogInterface , which ->
            val databaseHandler = DatabaseHandler(this)
            databaseHandler.deleteDSA(dsa)
            adapter.updateList(databaseHandler.viewDSA())
            dialogInterface.dismiss()
        }
        dialog.setNegativeButton("No") { dialogInterface , which ->
            dialogInterface.dismiss()
        }
        val alertDialog : AlertDialog = dialog.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

}