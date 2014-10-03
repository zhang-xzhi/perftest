package allen.perftest.result;

import allen.perftest.Control;

public class PerftestResult {

    public String   name;
    public String   des;
    public Class<?> perfTestCaseClass;
    public Object[] extraPara;
    public Control  control;

    public double   avg;
    public double   standardDeviation;

    public double[] results;

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(toFixedLength("avg=" + String.format("%1$.0f", avg), 10));

        sb.append(toFixedLength(
                "sd=" + String.format("%1$.2f", standardDeviation), 15));

        sb.append(toFixedLength("name=" + name, 40));
        sb.append(toFixedLength(control.getDes(), 30));
        sb.append(toFixedLength("des=" + des, 50));

        if (extraPara != null) {
            for (Object t : extraPara)
                sb.append("extraPara=" + t + "\t");
        }

        sb.append(fullResult());

        return sb.toString();
    }

    private String toFixedLength(String s, int length) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        while (sb.length() < length) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String fullResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (double r : results) {
            sb.append(String.format("%1$.0f", r));
            sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

}
