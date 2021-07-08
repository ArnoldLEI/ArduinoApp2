package com.study.app_tickets_firebase

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import android.content.Intent
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import kotlinx.android.synthetic.main.activity_console.*


class ConsoleActivity : AppCompatActivity() {
    val database = Firebase.database
    val myRef = database.getReference("ticketsStock")
    lateinit var context: Context
    lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_console)

        context = this
        userName = intent.getStringExtra("userName").toString()
        // 修改 Title
        title = "購票後台"
        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val children = snapshot.children
                children.forEach{
                    Log.d("MainActivity",
                        it.key.toString() + ":" + it.value.toString())
                    when(it.key.toString()) {
                        "discount" -> TicketsStock.discount = it.value.toString().toDouble()
                        "price" -> TicketsStock.price = it.value.toString().toInt()
                        "totalAmount" -> TicketsStock.totalAmount = it.value.toString().toInt()
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }

    fun update(view: View){
        val tag = view.tag.toString()
        var value = 0.0
        when(tag) {
            "discount" -> value = et_discount.text.toString().toDouble()
            "price"    -> value = et_price.text.toString().toDouble()
            "totalAmount" -> value = et_total_amount.text.toString().toDouble()
        }
        myRef.child(tag).setValue(value)
        Toast.makeText(context, tag + " 修改成功", Toast.LENGTH_SHORT).show()
    }


}