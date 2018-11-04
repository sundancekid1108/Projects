### git Study


## team project 를 fork한 respository와 동기화하기

'''
$ git remote -v 
origin "https://github.com/YOUR_USERNAME/YOUR_FORk.git"

$ git remote add upstream
"https://github.com/ORIGINAL_OWNER/ORIGINAL_REPOSITORY.git"

$ git remote -v

$ git fetch upstream

$ git checkout master

$ git merge upstream/master

$ git pull origin master
'''