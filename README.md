java 版百度网盘功能，目前已经实现： <br>
1：百度网盘登录 <br>
2：列出百度网盘文件 <br>
3: 切换目录 <br>
4: 多线程下载文件<br>

###命令行使用：

	usage:
	登陆： 
		login 
			-test 指定本地保存的用户名密码文件  默认在D:\BDLogin.txt
			-loc 读取已经登陆过的bduss 默认在D:\PcsLogin.txt
			-rk 读取当前目录下的用户名密码文件
			-rs 读取当前目录下的bduss
	列出当前文件夹：
		ls
			-f 指定文件路径（不加或者直接写路径也可以）
	切换目录：
		cd 
			-f 指定文件路径（不加或者直接写路径也可以）
	下载：
		download
			-f 指定文件路径（不加或者直接写路径也可以）
			-t 指定下载线程数
		注：文件名不能带空格，如果文件名的确有空格，加''(单引号)。
	路径：
		path
			-k 指定本地存储密钥和bduss路径
			-d 指定本地下载路径
	退出：
		quit/esc/exit/q
		
			
###界面使用：<br>
登录：<br>
            ![输入图片说明](https://gitee.com/uploads/images/2018/0505/125537_c413b9cb_688800.jpeg "1.jpg")<br>
文件列表：<br>
            ![输入图片说明](https://gitee.com/uploads/images/2018/0505/130252_baf11d6c_688800.jpeg "2.jpg")<br>
下载：<br>
           ![输入图片说明](https://gitee.com/uploads/images/2018/0505/130308_1d3453f1_688800.jpeg "3.jpg")<br>       
进度：<br>
            ![输入图片说明](https://gitee.com/uploads/images/2018/0505/130327_787b4b5c_688800.jpeg "4.jpg")
        
       

        