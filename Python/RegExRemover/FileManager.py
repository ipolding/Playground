import tkFileDialog

class FileManager(object):

    def __init__(self):
        self.input_file = None
        self.output_file = None

    def open_file(self):
        """ This acts as the setter of the filename property using tkinter's browse dialog """
        self.input_file =  tkFileDialog.askopenfile('r+', title="Select file to process")

    def clear_input_file(self):
    	self.input_file = None  	
