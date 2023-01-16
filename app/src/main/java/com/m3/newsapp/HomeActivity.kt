package com.m3.newsapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.m3.islami2.base.BaseActivity
import com.m3.newsapp.api.ApiManger
import com.m3.newsapp.api.Constance
import com.m3.newsapp.api.model.SourceResponse
import com.m3.newsapp.api.model.SourcesItem
import com.m3.newsapp.databinding.ActivityHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : BaseActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSources()
    }

    private fun getSources() {
        ApiManger.getApis().getNewsSources(Constance.apiKey,"en","us")
            .enqueue(object : Callback<SourceResponse>{
            override fun onResponse(
                call: Call<SourceResponse>,
                response: Response<SourceResponse>
            ) {
                binding.progressBar.visibility= View.GONE

                if(response.isSuccessful){
                    showsourceintablayout(response.body()?.sources)

                }
                else{
                    showDialoge(message = response.body()?.message?:"",
                    posActionName = getString(R.string.ok)
                    , posAction = DialogInterface.OnClickListener { dialog, which ->
                      //  call.enqueue(this)
                            call.clone().enqueue(this)
                        dialog.dismiss()
                    })}
            }

            override fun onFailure(call: Call<SourceResponse>, t: Throwable) {

                showDialoge(message = t.localizedMessage as String,
                    posActionName = getString(R.string.retry)
                    , posAction = DialogInterface.OnClickListener { dialog, which ->
                        call.clone().enqueue(this)
                        dialog.dismiss()
                    })
            }

        })
    }

    private fun showsourceintablayout(sources: List<SourcesItem?>?) {

        sources?.forEach{item->
            val tab=binding.tablayot.newTab()
            tab.text = item?.name
            binding.tablayot.addTab(tab)
        }
    }
}