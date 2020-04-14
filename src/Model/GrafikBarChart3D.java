package Model;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class GrafikBarChart3D extends ImageIcon{

    public GrafikBarChart3D(Dimension d,Object[][] valores) {
        final CategoryDataset dataset = createDataset(valores);
        final JFreeChart chart = createChart(dataset);
        BufferedImage bufferedImage = chart.createBufferedImage(d.width, d.height);
        this.setImage(bufferedImage);
    }

    /**
     * Creates a sample dataset.
     * @return a sample dataset.
     */
    private CategoryDataset createDataset(Object[][] valores) {
        final double[][] data = new double[][]{
        {Double.valueOf(valores[5][1].toString()), Double.valueOf(valores[6][1].toString()), Double.valueOf(valores[7][1].toString())},
        {Double.valueOf(valores[5][2].toString()), Double.valueOf(valores[6][2].toString()), Double.valueOf(valores[7][2].toString())},
        {Double.valueOf(valores[5][3].toString()), Double.valueOf(valores[6][3].toString()), Double.valueOf(valores[7][3].toString())}}; 
        String[] labels = {"За 2016 г.", "За 2017 г.", "За 2018 г."};
        String[] labels2 = {"Рентабельность продаж", "Чистая рентабельность", "Рентабельность продук."};              
        return DatasetUtilities.createCategoryDataset(labels, labels2, data);
    }

    /**
     * Creates a chart.
     *
     * @param dataset the dataset.
     *
     * @return The chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createBarChart3D(
                "Динамика показателей рентабельности", // chart title
                "ГОДЫ", // domain axis label
                "Значения", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
        );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
        );
        final BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        return chart;
    }
}
