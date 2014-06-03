java  -server -Xms1024m -Xmx1024m -Xmn680m -XX:SurvivorRatio=16 -Xss256k -XX:PermSize=240m -XX:MaxPermSize=240m -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:CMSInitiatingOccupancyFraction=70 -XX:CMSFullGCsBeforeCompaction=0 -XX:+UseCMSCompactAtFullCollection -XX:+CMSClassUnloadingEnabled -cp .\\target\\classes allen.perftest.main.PerfTestHarness
pause

 