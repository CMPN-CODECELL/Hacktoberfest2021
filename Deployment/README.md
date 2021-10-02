# Streamlit WebApp Deployment on Heroku

Heroku is a platform as a service (PaaS) that enables developers to build, run, and operate applications entirely in the cloud. We have used Heroku to deploy our webapp that is builty using Streamlit. There are various steos involved in the deployment which have been specified below with the necessary code, so that it is easier for anyone else to deploy a similar application.

**How to deploy a Streamlit webapp on Heroku??**

Make sure that your terminal is in your project folder. When you launch your project into the cloud, you need to create a requirements.txt file so that the server knows what to download to run your code. The library pipreqs can autogenerate requirements.

Use the following command in your terminal to install the pipreqs library :

```bash
pip install pipreqs
```

### Step 2: Creating the requirements.txt file for our project

Then once it’s downloaded, just step out of the folder, run the following command, and in the folder, you should find your requirements.txt file.

```bash
pipreqs <directory-path>
```

The requirements file would contain the names of the libraries and their versions.

**Example:**

- altair==4.1.0
- streamlit==0.64.0
- matplotlib==3.2.2
- pandas==1.0.5
- plotly==4.9.0
- numpy==1.18.5
- dash==1.17.0

### Step 3: Creation of setup.sh and Procfile

The setup.sh file contains some commands to set the problem on the Heroku side, so create a setup.sh file (you can use the nano command) and save the following in that file (change the email in the middle of the file to your correct email).

Make sure that your terminal is in your project folder.

Type the command

```bash
nano setup.sh
```

Now you will see a [setup.sh](http://setup.sh/) file has been opened. Copy one of the codes that you like and paste it in the [setup.sh](http://setup.sh/) file

**[setup.sh](http://setup.sh/) (without email verification - preferrable)**

```
mkdir -p ~/.streamlit/

echo "

[server]\\n

headless = true\\n

enableCORS=false\\n

port = $PORT\\n

\\n

" > ~/.streamlit/config.toml

```

**[setup.sh](http://setup.sh/) (with email verification - not preferrable)**

```
mkdir -p ~/.streamlit/
echo "\\
[general]\\n\\
email = \\"your@domain.com\\"\\n\\
" > ~/.streamlit/credentials.toml
echo "\\
[server]\\n\\
headless = true\\n\\
enableCORS=false\\n\\
port = $PORT\\n\\

```
**Procfile**

Again, make sure that your terminal is in your project folder.

Type the command:

```bash
nano Procfile  
```

(Procfile here is case sensitive - type it as it is mentioned)

Now insert the following piece of code in the Procfile file:

```bash
web: sh setup.sh && streamlit run [name-of-app].py
```

**Note:** [name-of-app] being the name of your project's main.py file

### Step 4: Creating a profile of Heroku

Heroku builds systems using Git and it’s pretty easy to get set up. Git is a version control system and runs as default on a lot of operating systems.
Check if you have it **(if yes then skip this step). If not, install it.**

Open terminal in your project folder and run the following commands :

```bash
git init
```

This initialises a git repository in your project folder and you should see something like the following print out:

```bash
Initialized empty Git repository in /Users/…
```

(If you are doing this for the first time make sure you visit - [https://devcenter.heroku.com/articles/heroku-cli](https://devcenter.heroku.com/articles/heroku-cli) and create your account there)

Once you’ve downloaded the Heroku CLI , run the following login command:

```bash
heroku login
```

This opens up a browser window, from which you can log in.
Once you’re in, it’s time to create your cloud instance. Run the following command

```bash
C:\Users...> heroku create
```

Now you’ll see that Heroku will create some oddly named instance (don’t worry, it’s just how it is):

Example:

Creating app... done, warm-eyrie-XXXX

### Step 5: Final deployment procedure

So Heroku created an app called ‘warm-eyrie’ for me. Not sure why, but I’ll take it. Now
all that’s remaining is to move the code across, so in our project folder we run the
following commands:

```bash
git add .
git commit -m "Enter your message here"
git push heroku master
```

Once it’s merged, the Heroku application will start downloading and installing
everything on the server side. This takes a couple of minutes but if all is good, then you
should something like:

```bash
remote: Verifying deploy... done.
```

Your job is done! If you copy the url it gives you in the command line into your browser, you’ll see that you can now run your application online. You can even check it on your mobile phone, it’s perfect!

### Step 6: Updation of code in future

If you want to update your code, you can just update it as normal, then do the following
again:

```bash
git add .
git commit -m "Enter your message here"
git push heroku master
heroku ps:scale web=1
```
# Renaming the App from the Heroku Dashboard

If you use the Heroku CLI to rename an app from inside its associated Git repository, your local Heroku remote is updated automatically. **However, other instances of the repository must update the remote’s details manually.**

You can run the following commands to update the remote’s details in other repository instances:

```bash
$ git remote rm heroku
$ heroku git:remote -a newname
```

Replace `newname` with the new name of the app, as specified in the `rename` command.
