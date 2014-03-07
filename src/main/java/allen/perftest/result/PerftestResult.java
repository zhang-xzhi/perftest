package allen.perftest.result;

import allen.perftest.Control;

public class PerftestResult {

    public String   name;
    public long     avg;
    public String   des;
    public Class<?> perfTestCaseClass;
    public Object[] extraPara;
    public Control  control;

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(toFixedLength("avg=" + avg, 15));
        sb.append(toFixedLength("name=" + name, 40));
        sb.append(toFixedLength(control.getDes(), 30));
        sb.append(toFixedLength("des=" + des, 50));

        if (extraPara != null) {
            for (Object t : extraPara)
                sb.append("extraPara=" + t + "\t");
        }

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

}
