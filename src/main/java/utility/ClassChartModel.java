package utility;

import Models.HoaDon;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Tien
 */
public class ClassChartModel extends ApplicationFrame {
  public ClassChartModel(String applicationTitle, String chartTitle, List<HoaDon> listHoaDon) {
    super(applicationTitle);
    JFreeChart lineChart = ChartFactory.createLineChart(
        chartTitle,
        "Tháng", "Tổng doanh thu trong tháng",
        createDataset(listHoaDon),
        PlotOrientation.VERTICAL,
        true, true, false);

    ChartPanel chartPanel = new ChartPanel(lineChart);
    chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
    setContentPane(chartPanel);
  }

    public ClassChartModel() {
        super(null);
    }
    
  
  public ChartPanel lineChart(String applicationTitle, String chartTitle, List<HoaDon> listHoaDon) {
      JFreeChart lineChart = ChartFactory.createLineChart(
        chartTitle,
        "Tháng", "Tổng doanh thu trong tháng",
        createDataset(listHoaDon),
        PlotOrientation.VERTICAL,
        true, true, false);

    ChartPanel chartPanel = new ChartPanel(lineChart);
    chartPanel.setPreferredSize(new java.awt.Dimension(1180, 350));
    return chartPanel;
  }

  private DefaultCategoryDataset createDataset(List<HoaDon> listHoaDon) {
    int[] preDoanhThu = new int[13];
    for(int i = 1; i <= 12; i++) {
        preDoanhThu[i] = 0;
    }
    for(int i = 0; i < listHoaDon.size(); i++) {
        preDoanhThu[getMonthFromInvoice(listHoaDon.get(i).getNgayRa())] += listHoaDon.get(i).getThanhTien();
    }
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    for(int i = 1; i <= 12; i++) {
        dataset.addValue(preDoanhThu[i], "VND", String.valueOf(i));
    }
    return dataset;
  }
  private int getMonthFromInvoice(String ngayRa) {
    String month = "";
    month += ngayRa.charAt(5); 
    month += ngayRa.charAt(6);
    return Integer.parseInt(month);
  }
}
