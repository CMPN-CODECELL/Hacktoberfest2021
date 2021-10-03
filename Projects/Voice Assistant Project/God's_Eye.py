# Run pip install -r requirements.txt, for downloading all the python libraries at once!!

import pyttsx3  # pip install pyttsx3
import speech_recognition as sr  # pip install speechRecognition
import datetime
import wikipedia  # pip install wikipedia
import webbrowser
import os
import random
import urllib.request
import smtplib  # pip install pywin32
import json
import cv2  # pip install opencv-python
from ecapture import ecapture as ec  # pip install ecapture
import wolframalpha  # pip install wolframalpha
# pip install pyAudio

app_id = "YOUR_WOLFRAM_ALPHA_APP_ID"
client = wolframalpha.Client(app_id)

engine = pyttsx3.init('sapi5')
voices = engine.getProperty('voices')

# Here voices[0] stands for the default voice i.e
engine.setProperty('voice', voices[0].id)

face_classifier = cv2.CascadeClassifier(
    cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')
eye_classifier = cv2.CascadeClassifier(
    cv2.data.haarcascades + 'haarcascade_eye.xml')

# Function for the Engine to hear our voice.


def speak(audio):
    engine.say(audio)
    engine.runAndWait()


def wishMe():
    hour = int(datetime.datetime.now().hour)
    if hour >= 6 and hour < 12:
        speak("Good Morning Sir!")

    elif hour >= 12 and hour < 18:
        speak("Good Afternoon Sir!")

    elif hour >= 18 and hour < 22:
        speak("Good Evening Sir!")

    else:
        speak("Good Night Sir!")

    speak("I am God's Eye Sir. Please tell me how can I help you")


def getLocation():
    f = urllib.request.urlopen('http://ip-api.com/json/')
    json_string = f.read()
    f.close()
    location = json.loads(json_string)
    location_city = location['city']
    location_state = location['regionName']
    location_country = location['country']
    location_zip = location['zip']
    return location_city


def face_detector(img, size=0.5):
    # Convert image to grayscale
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    faces = face_classifier.detectMultiScale(gray, 1.1, 5)
    if faces is ():
        return img

    for (x, y, w, h) in faces:
        x = x - 50
        w = w + 50
        y = y - 50
        h = h + 50
        cv2.rectangle(img, (x, y), (x+w, y+h), (255, 0, 0), 2)
        roi_gray = gray[y:y+h, x:x+w]
        roi_color = img[y:y+h, x:x+w]
        eyes = eye_classifier.detectMultiScale(roi_gray)
        for (ex, ey, ew, eh) in eyes:
            cv2.rectangle(roi_color, (ex, ey),
                          (ex+ew, ey+eh), (255, 255, 0), 2)

    roi_color = cv2.flip(roi_color, 1)
    return roi_color


def sendEmail(to, content):
    server = smtplib.SMTP('smtp.gmail.com', 587)
    server.ehlo()
    server.starttls()

    # Enable low security in gmail
    server.login('aniketdewnani31@gmail.com', 'YOUR_PASSWORD')
    server.sendmail('aniketdewnani31@gmail.com', to, content)
    server.close()


def takeCommand():
    # It takes microphone input from the user and returns string output

    r = sr.Recognizer()
    with sr.Microphone() as source:
        print("Listening...")
        r.pause_threshold = 1
        r.adjust_for_ambient_noise(source, duration=1)
        audio = r.listen(source)

    try:
        print("Recognizing...")
        query = r.recognize_google(audio, language='en-in')
        print(f"User said: {query}\n")

    except Exception as e:
        print(e)
        print("Say that again please...")
        speak('Could you say that again, Sir?')
        return "None"
    return query


if __name__ == "__main__":
    wishMe()
    while True:
        query = takeCommand().lower()

        if 'wikipedia' in query:
            speak('Searching Wikipedia...')
            query = query.replace("wikipedia", "")
            results = wikipedia.summary(query, sentences=2)
            speak("According to Wikipedia")
            print(results)
            speak(results)

        elif 'open youtube' in query:
            webbrowser.open("youtube.com")

        elif 'open stackoverflow' in query:
            webbrowser.open("stackoverflow.com")

        elif 'the time' in query:
            strTime = datetime.datetime.now().strftime("%H:%M:%S")
            speak(f"Sir, the time is {strTime}")

        elif 'how are you' in query:
            howAmI = [
                'Wonderful!, how may I help you ?',
                'Very Good, what can I do for you?',
                'I am great, what can I do for you ?'
            ]
            how = random.choice(howAmI)
            speak(how)

        elif 'your name' in query:
            speak("God's Eye is my name, helping you is my game")
            print("God's Eye is my name, helping you is my game")

        elif 'who made you' in query or 'who created you' in query:
            print('I was created by Aniket Dewnani')
            speak('I was created by Aniket Dewnani')

        elif 'google' in query:
            speak('Wait for Google results.....')
            query = query.replace('google', ' ')
            url = "https://www.google.com/search?q="
            chromepath = 'C:/Program Files (x86)/Google/Chrome/Application/chrome.exe %s'
            webbrowser.get(chromepath).open_new_tab(url + query)

        elif 'where is' in query:
            speak('Wait for Google results.....')
            query = query.replace('where is', ' ')
            url = "https://www.google.co.in/maps/search/"
            chromepath = 'C:/Program Files (x86)/Google/Chrome/Application/chrome.exe %s'
            webbrowser.get(chromepath).open_new_tab(url + query)

        elif 'what is' in query:
            speak('Wait for WolframAlpha Results.....')
            query = query.replace('what is', ' ')
            res = client.query(query)
            answer = next(res.results).text
            print(answer)
            speak(answer)

        elif 'who is' in query:
            speak('Wait for WolframAlpha Results.....')
            query = query.replace('what is', ' ')
            res = client.query(query)
            answer = next(res.results).text
            print(answer)
            speak(answer)

        elif 'camera' in query or 'take a photo' in query:
            speak('I am taking a photo, Sir')
            ec.capture(0, "God's Eye ", "img.jpg")

        elif 'detect face' in query:
            cap = cv2.VideoCapture(0)

            while True:

                ret, frame = cap.read()
                #cv2.resizeWindow('Our Face Extractor',600,600)
                cv2.imshow('Our Face Extractor', face_detector(frame))

                if cv2.waitKey(5000) == 13:  # 13 is the Enter Key
                    break

            cap.release()
            cv2.destroyAllWindows()

        elif 'send email' in query:
            try:
                speak('What should I send?')
                content = takeCommand()
                speak('To whom shall I send?')
                to = input()
                sendEmail(to, content)
                speak("Email has been sent !")
            except Exception as e:
                print(e)
                speak("I am not able to send this email")

        elif 'play' in query:
            speak('Wait for Gaana results.....')
            query = query.replace('play', ' ')
            url = "https://gaana.com/search/"
            chromepath = 'C:/Program Files (x86)/Google/Chrome/Application/chrome.exe %s'
            webbrowser.get(chromepath).open_new_tab(url + query)

        elif 'remember that' in query:
            speak('What should I remember?')
            data = takeCommand()
            speak('You told me to remember that ' + data)
            reminder = open('data.txt', 'w')
            reminder.write(data)
            reminder.close()

        elif 'do you remember' in query:
            reminder = open('data.txt', 'r')
            speak('You said me to remember that ' + reminder.read())

        elif 'my location' in query:
            f = urllib.request.urlopen('http://ip-api.com/json/')
            json_string = f.read()
            f.close()
            location = json.loads(json_string)
            location_city = location['city']
            location_state = location['regionName']
            location_country = location['country']
            location_zip = location['zip']
            reply = ("Your current location is : %s, %s, %s.") % (
                location_city, location_state, location_country)
            speak(reply)
            print(reply + "\n")

        elif 'weather' in query:
            city = getLocation()
            query = 'q='+city
            res = urllib.request.urlopen('http://api.openweathermap.org/data/2.5/weather?' +
                                         query+'&APPID=b35975e18dc93725acb092f7272cc6b8&units=metric')
            data = res.read()
            res.close()
            location = json.loads(data)
            location_city = location['name']
            print(location_city)
            temperature = location['main']['temp']
            wind_speed = location['wind']['speed']
            weather = location['weather'][0]['main']
            reply = ("The current weather in: %s, is standing at %s degrees celcius, and the wind speed is %s meters per second, there are %s in the sky.") % (
                location_city, temperature, wind_speed, weather)
            print(reply)
            speak(reply)

        elif 'shut down' in query:
            print('Shutting Down')
            speak('Shutting Down')
            os.system("shutdown /s /t 1")

        elif 'offline' in query or 'bye' in query:
            speak('Going Offline Sir, thank you for using the services')
            quit()
