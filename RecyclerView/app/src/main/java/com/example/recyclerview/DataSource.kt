package com.example.recyclerview

class DataSource {

    companion object {

        fun getDataSource() : List<Student>{
            val list = ArrayList<Student>()
            list.add(Student("Aman" , 19110))
            list.add(Student("Mrigank" , 19157))
            list.add(Student("Ritik" , 19140))
            list.add(Student("Anshuli" , 19117))
            list.add(Student("Apoorv" , 19120))
            list.add(Student("Yash" , 19194))
            list.add(Student("Kartik" , 19141))
            list.add(Student("Chitven" , 19123))
            return list
        }

    }


}