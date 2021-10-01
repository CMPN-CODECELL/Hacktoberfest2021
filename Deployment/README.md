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
