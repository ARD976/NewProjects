package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_name.view.*
import java.util.zip.Inflater

class StudentAdapter : RecyclerView.Adapter<StudentViewHolder>(){

    private var studentList : List<Student> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_name , parent , false))
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.name.text = student.name
        holder.roll.text = student.roll.toString()
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun addStudents(students : List<Student>){
        studentList = students
    }

}

class StudentViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val name : TextView = itemView.name
    val roll : TextView = itemView.roll
}