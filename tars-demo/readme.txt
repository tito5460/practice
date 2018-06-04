参考文章：
https://wenku.baidu.com/view/77bfc3ffb04e852458fb770bf78a6529647d35c8.html

# 生成tars脚本	
mvn tars:build -Dapp=CoolChattingApp -Dserver=CoolChattingServer -DjvmParams="-Xms256m -Xmx256m -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Xdebug -Xrunjdwp:transport=dt_socket,address=9000,server=y,suspend=n"

# Eclipse启动tars服务
1.0.3	-Xms256m -Xmx256m -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Xdebug -Xrunjdwp:transport=dt_socket,address=9000,server=y,suspend=n -classpath \D:\Project\Practice\idea\tars-demo\CoolChattingServer\target\tars\bin\lib\tars-server-1.0.3.jar;\D:\Project\Practice\idea\tars-demo\CoolChattingServer\target\tars\bin\lib\tars-client-1.0.3.jar;\D:\Project\Practice\idea\tars-demo\CoolChattingServer\target\tars\bin\lib\tars-context-1.0.3.jar;\D:\Project\Practice\idea\tars-demo\CoolChattingServer\target\tars\bin\lib\tars-net-1.0.3.jar;\D:\Project\Practice\idea\tars-demo\CoolChattingServer\target\tars\bin\lib\javax.servlet-api-3.0.1.jar -Dconfig=D:\Project\Practice\idea\tars-demo\CoolChattingServer\target\tars\conf\CoolChattingApp.CoolChattingServer.config.conf
1.0.2	-Xms256m -Xmx256m -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -classpath \D:\Project\Practice\idea\tars-demo\CoolChattingServer\target\tars\bin\lib\tars-server-1.0.2.jar;\D:\Project\Practice\idea\tars-demo\CoolChattingServer\target\tars\bin\lib\tars-client-1.0.2.jar;\D:\Project\Practice\idea\tars-demo\CoolChattingServer\target\tars\bin\lib\javax.servlet-api-3.0.1.jar;\D:\Project\Practice\idea\tars-demo\CoolChattingServer\target\tars\bin\lib\tars-net-1.0.2.jar -Dconfig=D:\Project\Practice\idea\tars-demo\CoolChattingServer\target\tars\conf\CoolChattingApp.CoolChattingServer.config.conf

# idea 启动tars服务
......authenticate=false -Xdebug -Xrunjdwp:transport=dt_socket,address=9000,server=y,suspend=n -classpath ......