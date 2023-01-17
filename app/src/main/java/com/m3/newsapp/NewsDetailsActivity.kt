package com.m3.newsapp

import android.R
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.m3.newsapp.api.Constance
import com.m3.newsapp.api.model.ArticlesItem
import com.m3.newsapp.databinding.ActivityNewsDetailsBinding


class NewsDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item=intent.getSerializableExtra(Constance.ITEM_EXTRA)  as ArticlesItem?
        binding.title.text=item?.title
        binding.auther.text=item?.author
        binding.date.text=item?.publishedAt
        binding.content.text=item?.content



        val url=item?.url
        val textView =binding.url
        textView.isClickable = true
        textView.movementMethod = LinkMovementMethod.getInstance()
        val text = "<a href='$url'> ${item?.source?.name} </a>"
        textView.text = Html.fromHtml(text)


        if (item?.urlToImage!=null) {
            binding.progressImg.visibility = View.GONE
            Glide.with(this).load(item.urlToImage).into(binding.image)

        }


    }
}