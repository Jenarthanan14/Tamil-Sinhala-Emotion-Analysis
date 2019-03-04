import shutil
import glob
import os
import csv
import pandas as pd

global date,emotion
#import csv files from folder

inpath = input("Location of input files : ")
outpath = input("Combined file location : ")

allFiles = glob.glob(inpath + "/*.csv")

# Add key word column
for j, fname in enumerate(allFiles):
    lis= fname.split('_')
    keyword = lis[-2].strip()
    name = lis[-3].split('\\')
    emotion = name[-1].strip()
    date = lis[-1][:-4].strip()
    df = pd.read_csv(fname, engine='python',encoding = "utf-8")
    df['Key word'] = keyword
    df.to_csv(fname)
    
with open(outpath+'\\'+emotion+'_'+date+'.csv', 'wb') as outfile:
    for i, fname in enumerate(allFiles):
        with open(fname, 'rb') as infile:
            if i != 0:
                infile.readline()  # Throw away header on all but first file
            # Block copy rest of file from input to output without parsing
            shutil.copyfileobj(infile, outfile)
            print(fname + " has been imported.")
