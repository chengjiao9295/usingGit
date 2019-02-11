public class InspectionItem {
    private String item;
    private String method;
    private String mode;
    private String standardValue;
    private String deviationValue;
    private int frequency;

    public void setStandardValue(String standardValue) {
        this.standardValue = standardValue;
    }

    public void setDeviationValue(String deviationValue) {
        this.deviationValue = deviationValue;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }


}
