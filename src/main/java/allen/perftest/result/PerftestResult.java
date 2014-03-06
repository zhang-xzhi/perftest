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
        sb.append("avg=" + avg + "\t");
        sb.append("name=" + name + "\t");
        sb.append("des=" + des + "\t");
        if (extraPara != null) {
            for (Object t : extraPara)
                sb.append("extraPara=" + t + "\t");
        }
        sb.append(control.getDes());
        return sb.toString();
    }

}
