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

git常用命令

```git
克隆：
	git clone 地址
提交:
    git add .
    git add [file]\[dir]\.（点号代表目录下所有文件）
推送：
	git commit -m "提交信息" 本次提交的说明文件
	git push
查看：
	git status
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
	
合并分支
	git merge 分支名 把分支名合并到当前分支
	
解决冲突
	>>>>>HEAD
	主分支的内容
	=======
	合并分支的内容
	>>>>>>合并分支名
	
	处理：
	修改冲突文件，再提交，合并，推送

版本回退：
	git reset --hard HEAD^^^
	git reset --hard HEAD~100
	git reflog 查看
	git reset --hard 版本名 回到指定版本
	
	
```

### Testng使用

通过maven配置testng

```xml
<dependencies>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>6.10</version>
    </dependency>
</dependencies>
```

#### 标签

测试套件

```txt
方法之前之后运行：
@BeforeMethod
@AfterMethod

方法之前之后运行：
@BeforeClass
@AfterClass

测试套件之后之前运行：
@BeforeSuite
@AfterSuite

忽略测试：
@Test(enable=false)

组测试--分组测试
方法分组：
@Test(groups="client")
@Test(groups-"server")
@BeforeGroups("server")
@AfterGroups("server")

依赖测试：
//用例必须依赖别的用例才能执行
@Test(dependsOnMethos = {"test1"})

```

类分组

注意：注解写在类上面！
@Test(groups="client")
通过testng测试套件配置文件进行运行

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<suite name="suitename">
    <test name="onlyRunStu">
        <groups>
            <run>
                <include name="stu"/>
            </run>
        </groups>
        <classes>
            <class name = "com.course.testng.suite.LoginTest"/>
        </classes>
    </test>
</suite>
```

异常测试

```java
/**
 * 异常测试用于：当我们期望结果为某一个异常的情况
 * 比如：我们传入了不合法的参数，期望程序抛出异常
 * 预期结果就是这个异常
 */
public class ExpectedException {
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是我的异常测试");
        throw new RuntimeException();
    }
}
```

testNG参数化测试

```java
@Test(dataProvider = "data")
pulbic void Testcase(){}
@DataProvider(name="data")
public Object[][] providerData(){
	Object[][] o = new Object[][]{
        {"value","value"},
        {"value","value"}
    }
    return o;
}


```



### HttpClient

#### 配置文件

通过在resources下增加properties文件进行配置。

在java类中，引用bundle = ResourceBundle.getBundle("文件名");进行读取



