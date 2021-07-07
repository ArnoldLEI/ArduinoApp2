package com.example.arduinoapp2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        initUI()
        }

    //初始資料
    fun initUI() {
        // 配置剩餘張數
        tv_total_amount.setText(TicketsStock.totalAmount.toString())

        var result = resources.getString(R.string.tickets_result)
        result = String.format(result,0,0,0,0)
        tv_result.setText(result)
        tv_warning.setText("None...")

    }

    //清除欄位
    fun reset(view: View) {
        initUI()
        et_all_tickets.setText("0")
        et_round_trip.setText("0")
    }


    //驗證購票資訊
    fun confirmTicket(): Boolean{
        //不得為空值
        if (et_all_tickets.text == null || et_all_tickets.text.toString().equals("")){
            et_all_tickets.setText("0")
        }
        if (et_round_trip.text == null || et_all_tickets.text.toString().equals("")){
            et_round_trip.setText("0")
        }

        val allTickets = et_all_tickets.text.toString().toInt()
        val roundTrip = et_round_trip.text.toString().toInt()

        //不可小於0
        if(allTickets <=0){
            tv_warning.setText("購買票數必須 > 0")
            Toast.makeText(context, "購買票數必須 > 0", Toast.LENGTH_SHORT).show()
            return false
        }

        //剩餘票數是否足夠
        val totalAmount = tv_total_amount.text.toString().toInt()
        if (allTickets > totalAmount){
            tv_warning.setText("剩餘票數不足")
            Toast.makeText(context, "剩餘票數不足", Toast.LENGTH_SHORT).show()
            return false
        }
        if (roundTrip * 2 > allTickets){
            tv_warning.setText("來回組數過多")
            Toast.makeText(context, "來回組數過多", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
        //來回票組數是否正確

    }

    //購買流程
    fun buyTicket(view: View) {

        //檢驗票數資訊
        if (!confirmTicket()){
            return
        }

        val allTickets = et_all_tickets.text.toString().toInt()
        val roundTrip = et_round_trip.text.toString().toInt()



        val tickets = Tickets(allTickets, roundTrip)
        //  result = 總票數：%d\n來回票：%d\n單程票：%d\n總金額：$%,d
        var result = resources.getString(R.string.tickets_result)
        result = String.format(
            result,
            tickets.allTickets,
            tickets.roundTrip,
            tickets.oneWay,
            tickets.total())
        tv_result.setText(result)

        TicketsStock.subAmount(tickets.allTickets)
        tv_total_amount.setText(TicketsStock.totalAmount.toString())

        tv_warning.setText("購買成功")
        Toast.makeText(context, "購買成功", Toast.LENGTH_SHORT).show()
    }


}