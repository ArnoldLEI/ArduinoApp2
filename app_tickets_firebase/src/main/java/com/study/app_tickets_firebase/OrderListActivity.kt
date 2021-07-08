package com.study.app_tickets_firebase

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_order_list.*

class OrderListActivity : AppCompatActivity() {

    val database = Firebase.database
    val myRef = database.getReference("ticketsStock")
    lateinit var userName: String
    lateinit var context: Context
    lateinit var recyclerViewAdapter: recyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_list)
        context = this
        userName = "John"

        // 取得上一頁傳來的 userName 參數資料
        userName = intent.getStringExtra("userName").toString()
        //read from database
        myRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val children = snapshot.children
                val orderList = mutableListOf<String>(userName)
                children.forEach{
                    if(it.key.toString() == "orders"){
                        tv_info.setText(it.child(userName).toString())
                        it.child(userName).children.forEach{
                            orderList.add(it.toString())
                        }
                    }
                }
                //更新 recycler view 的資訊
                recyclerViewAdapter.setOrders(orderList)
                //通知UI畫面變更
                recyclerViewAdapter.notifyDataSetChanged()
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })

        //init recycler view
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            recyclerViewAdapter = recyclerViewAdapter()
            adapter = recyclerViewAdapter
            // 分隔線
            val divider = DividerItemDecoration(context, StaggeredGridLayoutManager.VERTICAL)
            addItemDecoration(divider)
        }
    }
}