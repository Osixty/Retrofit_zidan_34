package com.example.retrofit_zidan_34

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.retrofit_zidan_34.activity.ProvinceActivity
import com.example.retrofit_zidan_34.api.RetrofitClient
import com.example.retrofit_zidan_34.model.IndonesiaResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showIndonesia()

        val buton: Button=findViewById(R.id.btnProvince)

        buton.setOnClickListener{
            Intent(this, ProvinceActivity::class.java).also {
                startActivity(it)
            }
        }


    }

    private fun showIndonesia() {
        RetrofitClient.instance.getIndonesia().enqueue(object :
            Callback<ArrayList<IndonesiaResponse>>{
            override fun onResponse(
                call: Call<ArrayList<IndonesiaResponse>>,
                response: Response<ArrayList<IndonesiaResponse>>
            ) {
                val indonesia = response.body()?.get(0)
                val positive = indonesia?.positif
                val dirawat = indonesia?.dirawat
                val sembuh = indonesia?.sembuh
                val death = indonesia?.meninggal

                tvPositive.text=positive
                tvHospitalized.text=dirawat
                tvRecover.text=sembuh
                tvDeath.text=death

            }

            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}


