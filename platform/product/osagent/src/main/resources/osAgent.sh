ps aux|grep java|grep osAgen|awk '{print $2}'| xargs kill -9
nohup java  -jar osAgent-0.0.1-SNAPSHOT.jar >nohup.out
ps aux|grep java|grep osAgen|awk '{print $2}'
