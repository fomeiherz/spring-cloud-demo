参考：https://github.com/Lovnx/micro-service

### 一、搭建一个配置中心的测试环境  

---  

#### 搭建架构图
![avata](http://p7240jy2w.bkt.clouddn.com/spring-cloud-demo%E9%85%8D%E7%BD%AE%E4%B8%AD%E5%BF%83%E6%9E%B6%E6%9E%84%E5%9B%BE.png)

#### 搭建系统步骤
> eureka-sever  
> config-server  
> service-one  

#### 启动步骤
eureka-sever -> config-server -> service-one

#### 配置中心的测试方法  
访问service-one服务：http://localhost:7074/from   
访问service-one服务：http://localhost:7074/addition?a=1&b=2

#### 什么时候去取配置信息的呢？实时去取吗？  
通过修改文件demo-dev.properties得知，并不是实时取的。  
修改配置后，重启项目配置才生效。改配置还需要重启项目吗？

### 二、搭建负载均衡的环境  

---  

#### 搭建架构图
![avata](http://p7240jy2w.bkt.clouddn.com/spring-cloud-demo%E8%B4%9F%E8%BD%BD%E5%9D%87%E8%A1%A1%E6%9E%B6%E6%9E%84%E5%9B%BE.png)
#### 搭建系统步骤
> service-two  
> service-two1  
> ribbon  

#### 启动流程
依赖环境：redis、mysql  
eureka-sever -> ribbon -> service-two -> service-two1  

#### 负载均衡测试
访问ribbon服务器：http://localhost:7071/addition?a=1&b=1  


