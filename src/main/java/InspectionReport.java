import java.util.List;

public class InspectionReport {
private String reportName;
private int shift;
    private String line;
    private String stationCode;
    private int area;
    private int reportStatus;
    List<InspectionItem> items;

    public List<InspectionItem> getItems() {
        return items;
    }

    public void setItems(List<InspectionItem> items) {
        this.items = items;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(int reportStatus) {
        this.reportStatus = reportStatus;
    }


}
