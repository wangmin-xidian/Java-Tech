********************************
**Git命令使用总结**  2019/04/17
********************************
## 目录 
* [从git远端fork到本地](#从git远端fork到本地)   
* [gitbook命令guide](#gitbook命令guide)   
* [实践命令总结](#实践命令总结)   
----

## 从git远端fork到本地 
- Git global setup
    - git config --global user.name name
    - git config --global user.email mail
- Create a new repository
    - git clone ssh://git@twtpebuildsv.deltaww.com:7002/bom/ams-dg5.git
    - cd ams-dg5
    - touch README.md
    - git add README.md
    - git commit -m "add README"
    - git push -u origin master
- Existing folder
    - cd existing_folder
    - git init
    - git remote add origin ssh://git@twtpebuildsv.deltaww.com:7002/bom/ams-dg5.git
    - git add .
    - git commit -m "Initial commit"
    - git push -u origin master
- Existing Git repository
    - cd existing_repo
    - git remote rename origin old-origin
    - git remote add origin ssh://git@twtpebuildsv.deltaww.com:7002/bom/ams-dg5.git
    - git push -u origin --all
    - git push -u origin --tags
*********************************
## gitbook命令guide

1. 查询修改Git 本地配置 
	- git config --list  查看所有配置
	- git config --global user.name name  修改 
	- git config  user.name  查看指定配置 
2. 将一个项目初始化成git项目 
	- git init 
3. 从git上fork项目到本地
	- git clone http://server:port/project project-rename 可以重命名直接copy到当前文件夹下 
4. 查看本地git项目的status 
	- git status 
	- git status -s  (输出内容比较简练) git项目中文件有三种状态：未跟踪，已提交，已修改
5. 将内容添加到下一次提交中 
	- git add file   (跟踪新文件，将已更新的已追踪文件放到暂存区，合并时将冲突文件标记为已解决)	
6. 忽略文件 
	- gitignore
7. 查看已暂存和未暂存的修改 
	- git diff   -- 显示尚未暂存的改动
	- git diff --staged  查看已暂存的diff内容
8. 提交更新 
	- git commit 
	- git commmit -m ""  提交时添加注释
	- git commin --amend 提交后再一次将暂存区的文件重新提交
9. 跳过使用暂存区域 
	- git commit -a -m ""  可以跳过add 步骤，直接将已跟踪修改的文件进行提交
10. 移除文件 
	- git rm 将文件从已跟踪文件清单中删除 
	- git rm --cached file  将文件从暂存区移除，但本地会保留
	- git rm -f file 强制从暂存区删除文档
	- git rm log/\*.log  删除log/目录下所有扩展名为log的文件 	
11. 移动文件 
	- git mv file_from file_to 重命名操作 	
12. 查看提交log     
	- git log  查看master 提交的所有log 信息 
	- git log -p -2 查看最近两次提交的内容差异
	- git log --stat  查看提交的简略的统计信息 		
	- git log  --prety=format:"" 还可以对log的查看格式进行格式化   
	- git log --since=4.weeks 根据时间做限制	  
	- 还可以根据--author，--grep(搜索关键字) --all-match 	
13. 撤销操作 
	- git reset HEAD file  撤销步骤（三个阶段的回退）
	- git checkout -- file  撤销对文件的所有修改 	
14. 查看远程仓库 
	- git remote 
	- git remote -v 显示读写远程仓库使用的Git保存的简写与其对应的URL 	
15. 添加远程仓库 
	- git remote add <shortname> <url> 	
	- git fetch [remote-name]  访问远程仓库，并从中拉去所有你还没有的数据	
16. 推送到远程仓库 
	- git push [remote-name] [branch-name]  	
	- git remote show [remote-name]  查看远程仓库的更多信息，列出远程仓库的URL，跟踪分支信息
	- git remote rename oldName newName  -- 对远程仓库重命名 
	- git remote rm  [remote-name]  移除一个远程仓库 	
17. 打标签 
	- git tag  列出标签 
	两种标签：轻量标签，附注标签 
	- git tag -a [tagname] -m " "  创建一个附注标签 
	- git tag [tagname] 创建轻量标签 
	- git tag -a [tagname] checksum   选择某个提交，根据提交的校验和打标签 	
	- git push [remote-name] [tagname]  共享标签，将标签推送到远程仓库
	- git push [remote-name] --tags   将所有不在远程仓库的标签全部推送过去	
18. git命令的别名 
	- git config --global alias.st status   给status设置别名为st 	
19. 分支 
	- git branch [branchname]   创建分支
	- git checkout [branchname] 切换分支
	- git branch -b [branchname] 创建并切换到分支
	- git branch -d [branchname] 删除分支 
	- git merge [branchname] 合并分支 
	- git branch  查看所有分支
	- git branch -v  查看所有分局最后一次提交
	- git branch --merged 查看已经merge过的分支 （--no-merged）

***************************
## 实践命令总结

1. 创建文件  touch file  
2. 创建文件夹  mddir dir  
3. 查看状态  git  status 
4. 将文件添加到缓存区  git add file   (git add .  -- 添加当前目录所有内容)
5. 编辑文件  
    - `vi` file 进入文件  
    - `i`  进入编辑模式，输入编辑内容  
    - `esc` 退出insert模式  
    - `:w，:q` 保存，退出 
6. 将缓存区所有文件退回  git reset --mixed 
7. 提交添加comment  git commit -m "comments"
8. 将缓存区代码提交到远程gitLab上， git push -u origin master 
9. 删除本地git分支： 跳转到目录所在位置 rm -rf .git
10. 强制上传 git push -f origin master
11. 删除文件夹  rm -rf dir 
12. 本地分支的使用：
    - 查看分支：git branch
    - 创建分支：git branch <name>
    - 切换分支：git checkout <name>
    - 创建+切换分支：git checkout -b <name>
    - 合并某分支到当前分支：git merge <name>
    - 删除分支：git branch -d <name>
13. 查看merge分支分叉情况 git log --oneline --decorate --graph --all
14. 提交code到远程仓库其他分支 
    1. 先在本地创建对应分支，checkout到对应分支
    2. add，commit 
    3. git push origin <branch-name>
15. 如果git pull提示no tracking information，则说明本地分支和远程分支的链接关系没有创建， 
    - 用命令git branch --set-upstream-to <branch-name> origin/<branch-name>将本地分支与远程Server关联tracking。
16. git删除远程仓库的文件或目录
    1. git rm -r -n --cached "bin/" //-n：加上这个参数，执行命令时，是不会删除任何文件，而是展示此命令要删除的文件列表预览。
    2. git rm -r --cached  "bin/"      //最终执行命令. 
    3. git commit -m" remove bin folder all file out of control"    //提交
    4. git push    //提交到远程服务器
17. pull代码步骤 
    1. git pull执行后，提示有merge错误；
    2. git stash 暂存本地代码 
    3. git pull 成功
    4. stash中若无用，可直接删除，若有用，git stash pop
18. 提交代码到其他分支
    - git push --set-upstream origin material-branch 
    
19. [Git 工具 - 储藏（Stashing）](https://git-scm.com/book/zh/v1/Git-%E5%B7%A5%E5%85%B7-%E5%82%A8%E8%97%8F%EF%BC%88Stashing%EF%BC%89)    
    - git stash  不想提交进行中的工作；储藏这些变更
    - git stash list 要查看现有的储藏
    - git stash apply 将缓存堆栈中的stash多次应用到工作目录中，但并不删除stash拷贝
    - git stash apply stash@{2] 
    - git stash drop stash@{0} 移除stash
    - git stash show  查看指定stash的diff,在该命令后面添加-p或--patch可以查看特定stash的全部diff
20. Git Merge
    - git merge develop  merge分支
    - git merge --abort 取消这次合并
    - git status    查看是否有merge文件
    - git ls-files -s，该命令输出的第二列的值
      - 如果为0表示对应的文件没有冲突，合并成功，
      - 如果不为0，则表示产生了合并的冲突，
      - 其中具体的值对应的意义是：
      - 1表示两个用户之前一个共同版本的对应文件内容；
      - 2表示当前用户对应的文件版本；
      - 3表示合并后的文件对应的远程版本
 21. git如何撤销上一次commit操作
    - git log 查看log，获取commit id 
    - git reset --hard commit_id 撤回
 22. git push develop develop --force  (本地分支和远程分支都是 develop)     
    - 这里的<commit_id>就是每次commit的SHA-1，可以在log里查看到    
    - `mixed`    会保留源码,只是将git commit和index 信息回退到了某个版本.    
    - `soft`   保留源码,只回退到commit信息到某个版本.不涉及index的回退,如果还需要提交,直接commit即可.   
    - `hard`    源码也会回退到某个版本,commit和index 都会回退到某个版本.(注意,这种方式是改变本地代码仓库源码)   
 
 
 
 
 
 
 
 
 
 
 
 
 
    
