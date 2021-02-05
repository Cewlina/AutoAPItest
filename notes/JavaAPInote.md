### 基础知识

#### 做接口测试的优点

- 更容易实现持续集成 
- 自动化测试落地性价比更高，比UI更稳定
- 大型系统更多更复杂，系统间模块越多
- Bug更容易定位
- 降低研发成本，提高效率

#### 接口测试用例设计

除了常规功能测试方法

##### 异常测试：

- 数据异常：null,""(空字符串),数据类型
- 环境异常：负载均衡架构，冷热备份
- 性能测试（狭义）：
- 负载测试
- 压力测试或强度测试
- 并发测试
- 稳定性测试或可靠性测试

##### 自动化接口测试的范围：

功能测试+数据异常测试

##### 自动化框架的设计

- 显示层：测试报告
- 控制层：逻辑验证
- 持久层：测试用例存储（数据驱动）

### git使用

#### github配置

##### 	配置sshkey

*（注意：这里都是在git命令行）*

​		生成key：ssh-keygen -t rsa -C "邮件地址"

​		注意：输入命令后回车，会出现提示内容，不输入直接回车3次

​		cd ~/.ssh(用户目录下的.ssh文件夹)

​		复制id_ras.pub的公钥内容到github网站中

##### 	配置多个sshkey

​		注：配置多个sshkey之前要把之前的key名字改了。避免覆盖

​		cd ~/.ssh(用户目录下的.ssh文件夹)

​		vim config

​		添加Host/HostName/User/IdentityFile

```text
Host github.com
HostName github.com
User github的用户名
IdentityFile 绝对路径+id-rsa

```

giti常用命令

```git
克隆：
	git clone 地址
推送：
	git commit -m "提交信息" 本次提交的说明文件
	git push
查看：
	git status
	git add [file]\[dir]\.（点号代表目录下所有文件）
拉取：
	git pull
	
查看分支
	git branch 查看本地分支
	git branch -a 查看所有远程端的分支 
	git checkout -b 分支名 本地创建分支
	git 分支名 切换到分支

删除分支
	注：不能删除当前工作分支，需要先切换到其它分支
	注：-D强制删除，注意使用

	git branch -d 分支名 删除本地分支
	git branch -r -d 分支名 删除远程分支
	git push origin :branch1 #注意origin（是远程项目名）后面有空格 
	
	
	
```

