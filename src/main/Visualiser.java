package main;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class Visualiser {
    public static void Visualise(List<Double> data){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue( data.get(0),"Рабочие места" ,"2012");
        dataset.setValue( data.get(1),"Рабочие места" ,"2013");
        dataset.setValue( data.get(2),"Рабочие места" ,"2014");
        dataset.setValue( data.get(3),"Рабочие места" ,"2015");
        dataset.setValue( data.get(4),"Рабочие места" ,"2016");
        JFreeChart chart = ChartFactory.createBarChart("Среднее количество рабочих мест","Год","Количество рабочих мест",dataset, PlotOrientation.VERTICAL,true,true,false);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);

        ChartFrame chartFrm = new ChartFrame("Среднее количество рабочих мест",chart,true);
        chartFrm.setVisible(true);
        chartFrm.setSize(800,800);
    }
    public static void PieVisualise(List<Double> data){
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue( "2012",data.get(0));
        dataset.setValue("2013", data.get(1));
        dataset.setValue( "2014",data.get(2));
        dataset.setValue( "2015",data.get(3));
        dataset.setValue( "2016",data.get(4));
        JFreeChart chart = ChartFactory.createPieChart("Среднее количество рабочих мест",dataset,true,true,false);
        PiePlot plot = (PiePlot) chart.getPlot();

        ChartFrame chartFrm = new ChartFrame("Среднее количество рабочих мест",chart,true);
        chartFrm.setVisible(true);
        chartFrm.setSize(800,800);
    }
}
