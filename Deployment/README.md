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