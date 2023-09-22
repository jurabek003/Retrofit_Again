package uz.turgunboyevjurabek.retrofitagain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.coroutines.coroutineScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.turgunboyevjurabek.retrofitagain.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.retrofitagain.madels.ApiGet
import uz.turgunboyevjurabek.retrofitagain.networking.ApiClient
import uz.turgunboyevjurabek.retrofitagain.networking.ApiServis

class MainActivity : AppCompatActivity() {
    private lateinit var apiServis: ApiServis
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        apiServis=ApiClient.getApiServis(this)


        apiServis.getAllItem().enqueue(object :Callback<List<ApiGet>>{
            override fun onResponse(
                call: Call<List<ApiGet>>,
                response: Response<List<ApiGet>>,
            ) {
                if (response.isSuccessful && response.body()!=null){
                    binding.text.text=response.body().toString()
                    Toast.makeText(this@MainActivity, "Successful buldi ", Toast.LENGTH_SHORT).show()
                    binding.gif.visibility=View.GONE
                }else{
                    Toast.makeText(this@MainActivity, "onFailure buldi else ni ichida ", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ApiGet>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "onFailure buldi ", Toast.LENGTH_SHORT).show()
            }
        })

    }
}