__author__ = 'ian.polding'

from Tkinter import Tk, Frame, BOTH, Button, Entry, Label, StringVar, END
import tkFileDialog
from FileManager import FileManager
import tkMessageBox
import re
import os
import tkFileDialog

class RegExRemoverGUI(Frame):

    processingButton = Button

    def __init__(self, parent):
        # we call the constructor of Frame - the inherited class
        Frame.__init__(self, parent, background='grey')
        #we store a reference to the parent widget - in this case it is Tk root window
        
        # instance variables for the RegExRemoverGui class
        self.file_to_process = None
        self.regular_expression_string = None
        self.path_to_input_file = None
        self.inputFile = None
        self.file_manager = FileManager()
        
        self.file_to_process = StringVar()
        self.parent = parent
        Label(text="File to process", bg = 'grey' ).place(x=10, y = 80)
        self.to_process_entry = Entry(textvariable=self.file_to_process)
        self.to_process_entry.place(x=100, y = 80)
        self.reg_ex_entry = Entry()
        self.initUI()

    def initUI(self):
        upload_file_x_coordinate = 10
        # Here we can set the title of the tk window
        self.parent.title("RegEx Remover")
        #pack organises widgets into vertical and horizontal boxes. It is one of three geometry managers
        #expanded in both directions
        self.pack(fill=BOTH, expand=1)
        self.upload_file_button = Button(text = "Upload file", command=self.press_upload_file_button)
        self.upload_file_button.place(x=upload_file_x_coordinate, y=50)

    def press_upload_file_button(self):
        self.file_manager.open_file()
        # Given the complete path, this produces the string filename.extension
        self.path_to_input_file = self.file_manager.input_file.name
        input_file_name = os.path.basename(self.path_to_input_file)
        self.file_to_process.set(input_file_name)  
        # Once a file is upload - a button is placed to view it
        # Here is the windows configuration. For Ubuntu, change notepad to gedit
        view_input_file_button = Button(text = "View input file", command=lambda:os.system('notepad ' + path_to_input_file) )

        view_input_file_button.place(x=100, y = 50)
        reg_ex_entry_y_coordinate = 100
        Label(text="Reg Ex Entry", bg = 'grey' ).place(x=10, y = reg_ex_entry_y_coordinate)
        # make the regular expression entry box visible by only placing it after a file is uploaded
        self.reg_ex_entry.place(x = 100, y = reg_ex_entry_y_coordinate)
        process_file_button = Button(text = "Process file", command=self.press_process_file_button)
        process_file_button.place(x = 10, y = 123)

    def press_process_file_button(self):
        fileAsString = self.file_manager.input_file.read()
        pattern = re.compile(self.reg_ex_entry.get())
        #this should return an _open_file_
        output_file = tkFileDialog.asksaveasfile(title="Select save location")
        # the reg ex pattern is removed here
        output_file.write(pattern.sub('', fileAsString))
        output_file.close()
        # here is where the instance variables are reset. The most recent output can be viewed.
        view_output_file_button = Button(text = "View most recent output", command=lambda:os.system('notepad ' + output_file.name) )
        view_output_file_button.place(x=100, y = 123)
        self.clear_ui_components()
        

    def clear_ui_components(self):
        self.reg_ex_entry.delete(0, END)
        self.file_manager.clear_input_file()
        self.file_to_process.set('')
        self.path_to_input_file = None

        

def main():

        root = Tk()
        #window size
        root.geometry("250x150+300+300")
        app = RegExRemoverGUI(root) #this root is the parent variable
        root.mainloop()        

if __name__ == '__main__':
    main()
