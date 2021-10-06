# Install the pacakes mentioned in the readme file.

import pyttsx3
import speech_recognition as sr
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

engine = pyttsx3.init('sapi5')
voices = engine.getProperty('voices')
engine.setProperty('voice', voices[1].id)
def speak(audio):
    engine.say(audio)
    engine.runAndWait()

def file_name():
    #It takes filename as voice input and returns it as string
    speak("which file do you want to open")
    name=takeCommand()
    return(str(name))

def takecommandnum():
    # It takes number as voice input and returns it as int
    t = ['zero','one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine', 'ten']
    text=takeCommand()
    for i in range(0, 11):
        if (t[i] == text):
            return(int(i))
        else:
            return(int(text))

def takeCommand():
    #It takes microphone input from the user and returns string output(speech to text)

    r = sr.Recognizer()
    with sr.Microphone() as source:
        print("Listening...")
        # r.pause_threshold = 0.8
        r.energy_threshold = 300
        audio = r.listen(source)

    try:
        print("Recognizing...")
        query = r.recognize_google(audio, language='en-in')


    except Exception:
        print("Say that again please...")
        return "None"
    return (query.lower())
x=file_name()
data_np = np.genfromtxt(x, delimiter=",", filling_values=0)
data_pd = pd.read_csv(x, delimiter=",")
print(x+" opened")
speak(x+" opened")
while(1):
    # speak("I am voice Assistant")
    query=takeCommand()
    print(query)

    if "print data" in query or "show data" in query:
        print(data_pd)

    elif "show info" in query:
        print(data_pd.info())

    elif "sum" in query and "axis 1" in query or "axis one" in query:
        x=data_pd.sum(axis=1)
        print(x)
        speak("do you want to plot its graph")
        y=takeCommand()
        if "yes" in y:
            x.plot()
            plt.show()



    elif "sum" in query and "axis 0" in query or "axis zero" in query:
        x = data_pd.sum(axis=0)
        print(x)
        speak("do you want to plot its graph")
        y = takeCommand()
        if "yes" in y:
            x.plot()
            plt.show()

    elif "size" in query and "array" in query:
        print(str(np.size(data_np)))

    elif "shape" in query or "dimension" in query and "array" in query:
        print(str(np.shape(data_np)))

    elif "sort the array" in query:
        speak("along which column do you want to sort the array")
        n=takecommandnum()
        print("Along column ",n)
        print(data_np[data_np[:,n].argsort()])

    elif "exit" in query:
        break
