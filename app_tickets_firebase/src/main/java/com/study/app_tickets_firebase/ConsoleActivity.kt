package com.study.app_tickets_firebase

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import android.content.Intent
import android.provider.ContactsContract
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        context = this
        userName = intent.getStringExtra("userName").toString()
        // 修改 Title
        title = "購票後台"
        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val children = snapshot.children
                var sumTotal = 0
                var sumAllTickets = 0
                var sumOneWay = 0
                var sumRoundTrip = 0
                children.forEach{
                    Log.d("MainActivity",
                        it.key.toString() + ":" + it.value.toString())
                    when(it.key.toString()) {
                        "discount" -> TicketsStock.discount = it.value.toString().toDouble()
                        "price" -> TicketsStock.price = it.value.toString().toInt()
                        "totalAmount" -> TicketsStock.totalAmount = it.value.toString().toInt()

                        //訂單明細
                        "orders" ->{
                            it.children.forEach { //訂購人
                                it.children.forEach { //訂購日期
                                    it.children.forEach { //訂票內容
                                        when(it.key.toString()){
                                            "allTickets" -> sumAllTickets += it.value.toString().toInt()
                                            "oneWay" -> sumOneWay += it.value.toString().toInt()
                                            "roundTrip" -> sumRoundTrip += it.value.toString().toInt()
                                            "total" -> sumTotal += it.value.toString().toInt()
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //顯示統計資料

                tv_stat.text = "總賣票數：${String.format("%,d", sumAllTickets)} 張\n" +
                               "總單程票：${String.format("%,d", sumOneWay)} 張\n" +
                               "總來回票：${String.format("%,d", sumRoundTrip * 2)} 張 (${String.format("%,d", sumRoundTrip)} 張)\n" +
                               "總銷售金額：$${String.format("%,d", sumTotal)} 元"
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(1, 1, 30,"訂單細目")?.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1 -> { // "訂單細目"
                val intent = Intent(context, OrderListActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}