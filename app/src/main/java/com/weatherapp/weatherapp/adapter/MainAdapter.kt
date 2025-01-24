package com.weatherapp.weatherapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.weatherapp.weatherapp.databinding.ListItemMainBinding
import com.weatherapp.weatherapp.R
import com.weatherapp.weatherapp.model.ModelMain
import java.util.Locale
import kotlin.random.Random

class MainAdapter(private val items: List<ModelMain>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]

        // Generate a random color using Random
        val randomColor = Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        holder.binding.cvListWeather.setCardBackgroundColor(randomColor)

        holder.binding.tvNameDay.text = data.timeNow
        holder.binding.tvTemp.text = String.format(Locale.getDefault(), "%.0f°C", data.currentTemp)
        holder.binding.tvTempMin.text = String.format(Locale.getDefault(), "%.0f°C", data.tempMin)
        holder.binding.tvTempMax.text = String.format(Locale.getDefault(), "%.0f°C", data.tempMax)

        // Set animation based on weather description
        val animationRes = when (data.descWeather) {
            "broken clouds" -> R.raw.broken_clouds
            "light rain" -> R.raw.light_rain
            "overcast clouds" -> R.raw.overcast_clouds
            "moderate rain" -> R.raw.moderate_rain
            "few clouds" -> R.raw.few_clouds
            "heavy intensity rain" -> R.raw.heavy_intensity
            "clear sky" -> R.raw.clear_sky
            "scattered clouds" -> R.raw.scattered_clouds
            else -> R.raw.unknown
        }
        holder.binding.iconTemp.setAnimation(animationRes)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val binding: ListItemMainBinding) : RecyclerView.ViewHolder(binding.root)
}
