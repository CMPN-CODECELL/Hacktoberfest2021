import datetime
import wikipedia
import smtplib
import webbrowser
import os
import cv2
import pyjokes


def wishMe():
    hour = int(datetime.datetime.now().hour)
    if hour>=0 and hour<12:
        print("BOT:Good Morning!")

    elif hour>=12 and hour<18:
        print("BOT:Good Afternoon!")   

    else:
        print("BOT:Good Evening!")  

    print("BOT:I am your BOT. Please tell me how may I help you")       

def sendEmail(to, content):
    server = smtplib.SMTP_SSL('smtp.gmail.com', 465)

    
    server.login('sender_id', 'sender_password')
    server.sendmail('receiver_emailid', to, content)
    server.quit()

if __name__ == "__main__":
    wishMe()
    while True:
        
        command=input().split()
        print("Recognizing.....")
        if "email" in command:
            print("BOT:To whom sir?")
            eml=input()
            print("BOT:What should I write sir?")
            cnt=input()
            sendEmail(eml,cnt)
        if "youtube" in command:
            webbrowser.open("youtube.com")
        if "google" in command:
            webbrowser.open("google.com")
        if "gfg" in command:
            webbrowser.open("geeksforgeeks.com")
        if "time" in command:
            strTime = datetime.datetime.now().strftime("%H:%M:%S")    
            print(f"Sir, the time is {strTime}")
        if "How" in command:
            print("BOT:I am fine sir")
            print("BOT:How are you?")
        if "fine" in command:
            print("BOT:It's good to hear that you are fine ,sir")
        if "exit" in command:
            print("BOT:Thank you sir,Have a Nice Day!")
            exit()

        if "wikipedia" in command:
            results=wikipedia.summary(command[4], sentences=3)
            print("BOT:I got something , sir")
            print(results)
        if "where" in command:
            results=command[2]
            webbrowser.open("https://www.google.com / maps / place/" + results + "")
        if "note" in command:
            print("BOT:What should i write, sir")
            note = input()
            file = open('note.txt', 'w')
            file.write(note)
        elif "show" in command:
            speak("BOT:Showing Notes")
            file = open("note.txt", "r")
            print(file.read())
        elif "restart" in command:
            subprocess.call(["shutdown", "/r"])
        elif 'shutdown' in command:
            print("BOT:Hold On a Sec ! Your system is on its way to shut down")
            subprocess.call('shutdown / p /f')
        

        elif 'joke' in command:
            print(pyjokes.get_joke())
       
            
 
        


        

