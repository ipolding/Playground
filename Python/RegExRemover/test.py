__author__ = 'ian.polding'

from Tkinter import Tk, Frame, BOTH, Button
import tkFileDialog
import re
import os

#Tk is used to create a root window
#Frame is a container for other Widgets

class Example(Frame):



    def __init__(self, parent):
        # we call the constructor of Frame - the inherited class
        Frame.__init__(self, parent, background="white")
        #we store a reference to the parent widget - in this case it is Tk root window
        self.parent = parent
        self.initUI()
        self.fileToProcess = None

    def initUI(self):
        # Here we can set the title of the tk window
        self.parent.title("Simple")
        #pack organises widgets into vertical and horizontal boxes. It is one of three geometry managers
        #expanded in both directions
        self.pack(fill=BOTH, expand=1)

        openFileButton = Button(self, text="Load file", command=self.openFile)
        openFileButton.place(x=50, y=50)

        processFileButton = Button(self, text="Process a file", command=self.processFile)
        processFileButton.place(x=50, y=100)






    def openFile(self):
        self.fileToProcess =  tkFileDialog.askopenfile('r+', title="Select file to process")
        return self.fileToProcess

    def processFile(self):
        if self.fileToProcess:
            fileAsString = self.fileToProcess.read()
            userRegEx = raw_input("Enter the regular expression to remove:")
            pattern = re.compile(userRegEx)
            outputFileName = tkFileDialog.asksaveasfilename()
            outputFile = open(outputFileName, 'w+')
            outputFile.write(pattern.sub('', fileAsString))
            outputFile.close()
            os.system('notepad ' + outputFileName)





def main():

        root = Tk()
        #window size
        root.geometry("250x150+300+300")
        app = Example(root) #this root is the parent variable
        root.mainloop()
        fileToProcess = None








if __name__ == '__main__':
    main()


















# quitButton = Button(self, text="Quit", command=self.quit)
        # quitButton.place(x=50, y=0)








