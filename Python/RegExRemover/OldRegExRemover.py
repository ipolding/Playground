___author__ = 'ian.polding'

import re
from Tkinter import filedialog
from Tkinter import
# import tkFileDialog
import os

class MyF

root = Tk()
# selectFileButton = Button(root, text="Open File", command = self.openFile)

Button(root, text='askopenfile', command=tkFileDialog.askopenfile().pack())
root.mainloop()

# def openFile():
#      return tkFileDialog.askopenfile('r+', title='Please select file to remove regular expressions from')

# inputFile =  tkFileDialog.askopenfile('r+', title='Please select file to remove regular expressions from')
# if file != None:
#     fileAsString = inputFile.read()
# print "All files are found in " + inputFilePath
# # fileName = raw_input("Enter File name")
# fileName='FacebookScript.txt'
# pathToFile = inputFilePath + fileName
#
# fileForConversion = open(pathToFile, 'r+')

def removeExpression(inputFile):
    userRegEx = raw_input("Enter the regular expression to remove:")
    pattern = re.compile(userRegEx)
    outputFileName = tkFileDialog.asksaveasfilename()
    outputFile = open(outputFileName, 'w+')
    outputFile.write(pattern.sub('', fileAsString))
    outputFile.close()
    os.system('notepad ' + outputFileName)


#
# answer = raw_input("Would you like to continue. Please enter Y or N")

# while True:
#     #move processed file from output directory to input directory and change its name
#     answer = raw_input("Would you like to continue. Please enter Y or N: ").lower()
#     if answer != 'y' or answer != 'n':
#         while True:
#             answer = raw_input("Please enter either Y or N only").lower()
#             if answer == 'n' or answer == 'y': break
#     if answer =='n': break
#
#     print 'y response is working'
#
# print 'n response is working'












