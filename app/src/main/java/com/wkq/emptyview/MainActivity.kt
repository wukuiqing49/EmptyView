package com.wkq.emptyview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.wkq.empty.EmptyView
import com.wkq.emptyview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding= DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.btEmpty.setOnClickListener {
            binding.empty.showEmpty()
        }

        binding.btErr.setOnClickListener {
            binding.empty.showErr("服务器数据异常",R.mipmap.iv_empty_err,object : EmptyView.EmptyViewRetryListener{
                override fun onRetry() {
                    Toast.makeText(this@MainActivity,"重连", Toast.LENGTH_SHORT).show()
                }
            })
        }
        binding.btNet.setOnClickListener {
            binding.empty.showNetErr("网络异常", R.mipmap.iv_empty_net,object : EmptyView.EmptyViewRetryListener{
                override fun onRetry() {
                    Toast.makeText(this@MainActivity,"重连", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}