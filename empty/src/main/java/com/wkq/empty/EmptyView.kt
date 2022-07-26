package com.wkq.empty

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import com.wkq.empty.databinding.WuLayoutEmptyViewBinding


/**
 * @author wkq
 *
 * @date 2022年07月26日 15:12
 *
 *@des
 *
 */

class EmptyView @JvmOverloads constructor(
    mContext: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(mContext, attrs, defStyleAttr) {
    init {
        init(mContext)
    }

    var binding: WuLayoutEmptyViewBinding? = null

    private fun init(context: Context) {
        binding = DataBindingUtil.inflate<WuLayoutEmptyViewBinding>(
            LayoutInflater.from(context),
            R.layout.wu_layout_empty_view,
            null,
            false
        )
        addView(
            binding!!.root,
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }


    /**
     * 设置空布局
     */

    fun showEmpty(message: String = "暂无内容") {
        binding!!.tvErr.text = message
    }

    fun showEmpty(message: String, iconRes: Int) {
        binding!!.tvErr.text = message
        binding!!.ivContent.setImageResource(iconRes)
    }

    fun showEmpty(message: String, listener: EmptyViewRetryListener) {
        binding!!.tvErr.text = message
        binding!!.tvRetry.visibility = View.VISIBLE
        binding!!.tvRetry.setOnClickListener {
            if (listener != null) {
                listener.onRetry()
            }
        }
    }

    fun showEmpty(message: String, iconRes: Int, listener: EmptyViewRetryListener) {
        binding!!.tvErr.text = message
        if (iconRes > 0) binding!!.ivContent.setImageResource(iconRes)
        binding!!.tvRetry.visibility = View.VISIBLE
        binding!!.tvRetry.setOnClickListener {
            if (listener != null) {
                listener.onRetry()
            }
        }
    }

    /**
     * 设置错误布局
     */
    fun showErr(message: String = "数据异常") {
        binding!!.tvRetry.visibility = View.GONE
    }

    fun showErr(message: String, iconRes: Int) {
        if (iconRes > 0) binding!!.ivContent.setImageResource(iconRes)
        binding!!.tvRetry.visibility = View.GONE
    }

    fun showErr(message: String, listener: EmptyViewRetryListener) {
        binding!!.tvErr.text = message
        binding!!.tvRetry.visibility = View.VISIBLE
        binding!!.tvRetry.setOnClickListener {
            if (listener != null) {
                listener.onRetry()
            }
        }
    }

    fun showErr(message: String, iconRes: Int, listener: EmptyViewRetryListener) {
        if (iconRes > 0) binding!!.ivContent.setImageResource(iconRes)
        binding!!.tvErr.text = message
        binding!!.tvRetry.visibility = View.VISIBLE
        binding!!.tvRetry.setOnClickListener {
            if (listener != null) {
                listener.onRetry()
            }
        }
    }


    /**
     * 设置网络异常布局
     */

    fun showNetErr(message: String = "数据异常") {
        binding!!.tvErr.text = message
        binding!!.tvRetry.visibility = View.VISIBLE
    }

    fun showNetErr(message: String, iconRes: Int) {
        if (iconRes > 0) binding!!.ivContent.setImageResource(iconRes)
        binding!!.tvErr.text = message
        binding!!.tvRetry.visibility = View.GONE
    }


    fun showNetErr(message: String, iconRes: Int, listener: EmptyViewRetryListener) {

        binding!!.ivContent.setImageResource(iconRes)
        binding!!.tvErr.text = message
        binding!!.tvRetry.visibility = View.VISIBLE
        binding!!.tvRetry.setOnClickListener {
            if (listener != null) {
                listener.onRetry()
            }
        }
    }

    fun showNetErr(message: String, listener: EmptyViewRetryListener) {
        binding!!.tvErr.text = message
        binding!!.tvRetry.visibility = View.VISIBLE
        binding!!.tvRetry.setOnClickListener {
            if (listener != null) {
                listener.onRetry()
            }
        }
    }


    /**
     * 重连点击事件
     */
    interface EmptyViewRetryListener {
        fun onRetry()
    }


}