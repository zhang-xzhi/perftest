package allen.perftest.result;

public class PerftestResult {

    public String   name;
    public int      loop;
    public long     avg;
    public String   des;
    public Class<?> perfTestCaseClass;
    public Object[] extraPara;

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("avg=" + avg + "\t");
        sb.append("loop=" + loop + "\t");
        sb.append("name=" + name + "\t");
        sb.append("des=" + des + "\t");
        if (extraPara != null) {
            for (Object t : extraPara)
                sb.append("extraPara=" + t + "\t");
        }
        return sb.toString();
    }

}