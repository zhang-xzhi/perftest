java                                             ^
-server                                          ^
-XX:+PrintCompilation                            ^
-Xms1024m                                        ^
-Xmx1024m                                        ^
-Xmn680m                                         ^
-XX:SurvivorRatio=8                              ^
-XX:PermSize=240m                                ^
-XX:MaxPermSize=240m                             ^
-XX:+UseConcMarkSweepGC                          ^
-XX:+UseParNewGC                                 ^
-XX:CMSInitiatingOccupancyFraction=70            ^
-XX:+UseCMSInitiatingOccupancyOnly               ^
-XX:CMSFullGCsBeforeCompaction=0                 ^
-XX:+UseCMSCompactAtFullCollection               ^
-XX:+CMSClassUnloadingEnabled                    ^
-XX:+PrintGCDetails                              ^
-XX:+PrintGCDateStamps                           ^
-cp .\\target\\classes;./lib/commons-math3-3.3.jar allen.perftest.main.PerfTestHarness 
pause

# ���԰�GC��־/������־��ֹ������������ӡ�Ľ�����ɾ���



