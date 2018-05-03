参考：https://github.com/Lovnx/micro-service

### 搭建一个配置中心的测试环境
#### eureka-sever
#### config-server
#### service-one

### 启动流程
eureka-sever -> config-server -> service-one

### 配置中心的测试方法  
访问service-one服务：http://localhost:7074/from   
访问service-one服务：http://localhost:7074/addition?a=1&b=2

#### 什么时候去取配置信息的呢？实时去取吗？  
通过修改文件demo-dev.properties得知，并不是实时取的。  
修改配置后，重启项目配置才生效。改配置还需要重启项目吗？

### 搭建负载均衡的环境
#### service-two
#### service-two1
#### ribbon

### 启动流程
依赖环境：redis、mysql  
eureka-sever -> ribbon -> service-two -> service-two1  

### 负载均衡测试
访问ribbon服务器：http://localhost:7071/addition?a=1&b=1  


