package com.example.proyectopatrones

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectopatrones.databinding.ActivityAdminBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class AdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración de la gráfica de barras
        setupBarChart(binding.barChart)

        // Configuración de la gráfica de pastel
        setupPieChart(binding.pieChart)
    }

    private fun setupBarChart(barChart: BarChart) {
        val entries = listOf(
            BarEntry(0f, 80f), // Agosto
            BarEntry(1f, 50f), // Septiembre
            BarEntry(2f, 90f)  // Octubre
        )

        val dataSet = BarDataSet(entries, "Eventos")
        dataSet.color = Color.parseColor("#40C4FF") // Color azul para eventos

        val alojamientoEntries = listOf(
            BarEntry(0f, 70f), // Agosto
            BarEntry(1f, 30f), // Septiembre
            BarEntry(2f, 85f)  // Octubre
        )

        val alojamientoDataSet = BarDataSet(alojamientoEntries, "Alojamientos")
        alojamientoDataSet.color = Color.parseColor("#8BC34A") // Color verde para alojamientos

        val barData = BarData(dataSet, alojamientoDataSet)
        barChart.data = barData

        barData.barWidth = 0.4f
        barChart.groupBars(0f, 0.2f, 0.05f)

        barChart.description = Description().apply { text = "" }
        barChart.axisLeft.axisMinimum = 0f
        barChart.xAxis.granularity = 1f
        barChart.animateY(1000)
        barChart.invalidate() // Actualiza la gráfica
    }

    private fun setupPieChart(pieChart: PieChart) {
        val pieEntries = listOf(
            PieEntry(60f, "Adentro"),
            PieEntry(30f, "Afuera"),
            PieEntry(10f, "Errores")
        )

        val dataSet = PieDataSet(pieEntries, "")
        dataSet.colors = listOf(
            Color.parseColor("#40C4FF"), // Azul para "Adentro"
            Color.parseColor("#8BC34A"), // Verde para "Afuera"
            Color.parseColor("#6200EA")  // Morado para "Errores"
        )
        dataSet.sliceSpace = 3f // Espacio entre secciones

        val pieData = PieData(dataSet)
        pieData.setValueTextSize(12f)
        pieData.setValueTextColor(Color.WHITE)

        pieChart.data = pieData
        pieChart.description = Description().apply { text = "" }
        pieChart.isDrawHoleEnabled = true
        pieChart.holeRadius = 40f
        pieChart.setEntryLabelColor(Color.BLACK)
        pieChart.animateY(1000)
        pieChart.invalidate() // Actualiza la gráfica
    }

}