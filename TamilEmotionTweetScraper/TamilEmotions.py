import os
import pandas as pd
from functools import partial
from itertools import repeat
from multiprocessing import Pool, freeze_support
import twint


def TweetScrap(x,y):

    year = y[0]
    month = y[1]
    day = y[2 ]
    emotion = y[3]
    
    path = r'Data\\'+emotion+'\\'+year+'_'+month
    Create_directory(year,month,emotion)
    c=twint.Config()
    c.Search = x[0]
    date=year+"-"+month
    c.Store_csv = True
    c.Resume = x[1]
    c.Since = date+"-1"
    c.Until = date+"-"+day
    c.Custom = ["id","date","time","tweet","timezone","likes","user_id","username","replies","retweets","hashtags","retweet","user_rt","mentions","link"]
    c.Output = path+'\\'+emotion+"_"+x[0]+"_"+year+"-"+month+".csv"
    twint.run.Search(c)


def Create_directory(year,month,emotion):
    
    if not os.path.exists("Data/"+emotion+"/"+year+"_"+month):
        os.makedirs("Data/"+emotion+"/"+year+"_"+month)

def main():
    
    inputlist=[]
    setList = []
    core = input("Enter no of process (core) : ")
    file = input("Enter file location with name : ")
    year = input("Enter which year of tweet you need : ")
    month = input("Enter which month of tweet you need : ")
    day = days(month, year)
    words=keyWords(file)
    wordsWithMinId = minId(words,year,month)
    inputlist=[year,month,day,words[0]]
    multiprocessingBlock(wordsWithMinId,inputlist,core)

def keyWords(file):
    keyWords=[]
    with open(file,'r',encoding = "utf-16") as f:
        lis = [Te.strip().split(",") for Te in f]
    
    for i in lis:
        for j in i:
            if (len(j)!=0):
                keyWords.append(j)

    return keyWords

def multiprocessingBlock(keyWords,inputlist,core):
    x=int(core)
    length=len(keyWords)
    Set = length//x
    pool = Pool(processes = x)

    while (True):
        if Set == 0:
            setList = keyWords
            pool.map(partial(TweetScrap, y=inputlist), setList)
            break
        elif(Set>0):
            for i in range (0,Set):
                setList = keyWords[x*int(i):x*(int(i)+1)]
                pool.map(partial(TweetScrap, y=inputlist), setList)
            break

def minId(lis,year,month):
    setWithMinId=[]
    emotion = lis[0]
    for i in lis:
        if (os.path.isfile("Data\\"+emotion+"\\"+year+"_"+month+"\\"+emotion+"_"+i+"_"+year+"-"+month+".csv")):
            df=pd.read_csv("Data\\"+emotion+"\\"+year+"_"+month+"\\"+emotion+"_"+i+"_"+year+"-"+month+".csv", engine='python', encoding='utf-8')
            minId=df['id'].min()
        else:
            minId="NULL"
        setWithMinId.append([i,minId])
    return setWithMinId



def isLeapYear(year):
    return (year % 4 == 0) and (year % 100 != 0) or (year % 400 == 0)

# You should complete the definition of this function:

def days(month, year):
    days=""
    set1 =["1","3","5","7","8","10","12"]
    set2 = ["4","6","9","11"]
    if month in set1:
        days="31"
    elif month in set2:
        days="30"       
    elif month == "2" and isLeapYear(year) == True:
        days="29"
    elif month == "2" and isLeapYear(year) == False:
        days="28"
    else:
        return None
    return days
    

        
if __name__ == '__main__':
    
    main()
    
    
    

        
    
    
    
    
    
