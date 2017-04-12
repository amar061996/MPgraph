package com.example.amar.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    BarChart barChart,barChart2,barChart3,barChart4;
    ArrayList<String>Dates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        barChart=(BarChart)findViewById(R.id.bargraph);
        barChart2=(BarChart)findViewById(R.id.bargraph2);
        barChart3=(BarChart)findViewById(R.id.bargraph3);
        barChart4=(BarChart)findViewById(R.id.bargraph4);

        ArrayList<BarEntry> barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(0,44f));
        barEntries.add(new BarEntry(1,42f));
        barEntries.add(new BarEntry(2,34f));
        barEntries.add(new BarEntry(3,14f));
        barEntries.add(new BarEntry(4,54f));


        BarDataSet barDataSet=new BarDataSet(barEntries,"Dates");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        ArrayList<IBarDataSet> dataSets=new ArrayList<>();
        dataSets.add((IBarDataSet)barDataSet);
        BarData data=new BarData(dataSets);

        Dates=new ArrayList<>();
        Dates.add("Jan");
        Dates.add("Feb");
        Dates.add("Mar");
        Dates.add("April");
        Dates.add("May");

        IAxisValueFormatter formatter=new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                Log.e("value:",""+value);
                return Dates.get((int)value);
            }


        };
        XAxis xAxis=barChart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(formatter);

        XAxis xAxis2=barChart2.getXAxis();
        xAxis2.setGranularity(1f);
        xAxis2.setValueFormatter(formatter);

        XAxis xAxis3=barChart3.getXAxis();
        xAxis3.setGranularity(1f);
        xAxis3.setValueFormatter(formatter);

        XAxis xAxis4=barChart4.getXAxis();
        xAxis4.setGranularity(1f);
        xAxis4.setValueFormatter(formatter);


        barChart.setData(data);
        barChart.animateXY(2000,2000);

        barChart2.setData(data);
        barChart2.animateXY(2000,2000);

        barChart3.setData(data);
        barChart3.animateXY(2000,2000);

        barChart4.setData(data);
        barChart4.animateXY(2000,2000);
    }

}
