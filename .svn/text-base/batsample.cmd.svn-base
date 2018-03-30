@echo on
echo 当前盘符：%~d0
echo 当前盘符和路径：%~dp0
echo 当前盘符和路径的短文件名格式：%~sdp0
echo 当前批处理全路径：%~f0
echo 当前CMD默认目录：%cd%
echo mvn deploy:deploy-file -DgroupId=com.tyyd -DartifactId=crps.scf -Dversion=1.0.0-SNAPSHOT -Dpackaging=jar -Dfile=%~sdp0target-crps\crps.scf-1.0.0-SNAPSHOT.jar -Dsources=%~sdp0target-crps/crps.scf-1.0.0-SNAPSHOT-source.jar -DrepositoryId=snapshots -Durl=http://admin:tianyiyuedu@61.130.247.181:6081/nexus/content/repositories/snapshots
pause