package allen.perftest.testcase.cache;

import allen.perftest.AbstractPerfTestCaseFactory;

//use core info
//Logical Processor to Cache Map:
//**--  Data Cache          0, Level 1,   32 KB, Assoc   8, LineSize  64
//**--  Instruction Cache   0, Level 1,   32 KB, Assoc   8, LineSize  64
//**--  Unified Cache       0, Level 2,  256 KB, Assoc   8, LineSize  64
//--**  Data Cache          1, Level 1,   32 KB, Assoc   8, LineSize  64
//--**  Instruction Cache   1, Level 1,   32 KB, Assoc   8, LineSize  64
//--**  Unified Cache       1, Level 2,  256 KB, Assoc   8, LineSize  64
//****  Unified Cache       2, Level 3,    3 MB, Assoc  12, LineSize  64
public class CacheFactory extends AbstractPerfTestCaseFactory {

    @Override
    public void fillPerfTestCase() {
        //        add(new CacheIntArrayOperation(1));
        //        add(new CacheIntArrayOperation(2));
        //        add(new CacheIntArrayOperation(4));
        //        add(new CacheIntArrayOperation(8));
        //        add(new CacheIntArrayOperation(16));
        //        add(new CacheIntArrayOperation(32));
        //        add(new CacheIntArrayOperation(64));
        //        add(new CacheIntArrayOperation(128));
        //        add(new CacheIntArrayOperation(256));
        //        for (int step = 1; step <= 64; step++) {
        //            add(new CacheIntArrayOperation(step));
        //        }

        for (int step = 8; step >= 1; step--) {
            add(new CacheIntArrayOperation(step));
        }
    }
}
