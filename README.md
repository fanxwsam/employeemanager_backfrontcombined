# employeemanager
This application used AngularJS along with MetaWidget to implement the frontend, and the backend RestAPIs were developed using Spring Boot. \
The resources of MetaWidget, \
http://metawidget.sourceforge.net/index.php \
http://metawidget.sourceforge.net/download.php \
\
\
**There are two ways to run this application**
#### 1.	Run frontend and backend together (in the same server)
-	Download the source code from link below,\
https://github.com/fanxwsam/employeemanager_backfrontcombined
-	Open the Maven project using IntelliJ IDEA (or other development tools)
-	Run Maven ‘compile’ command as below. The frontend source code will be copied to “${basedir}/target/classes/static” \
![image](https://user-images.githubusercontent.com/46641840/189535487-7d9824d1-72b6-4f51-af7e-2393104ad0cd.png)

-	Start backend application. The port is 8081
![image](https://user-images.githubusercontent.com/46641840/189535529-2930a85a-e200-4546-8b6d-22a8aa7c2293.png)

-	Access  link http://localhost:8081 \
The index page has an employee list and the data will be retrieved from backend RestAPI. \
You can click ‘Add Employee’ to add new employees. \
Clicking the icon ![image](https://user-images.githubusercontent.com/46641840/189535634-5aba77df-6aa5-4d47-9822-f7b25beba5c5.png)
  can delete the employees one by one. \
The ‘Edit’ feature has not been implemented. \
 ![image](https://user-images.githubusercontent.com/46641840/189535730-6db9733a-ceee-428a-b2f9-f87a1c1d5736.png)

- ‘Add Employee’ feature was implemented by MetaWidget
 ![image](https://user-images.githubusercontent.com/46641840/189535755-ff04356a-5365-4d0c-9ac9-6eda8360dfc4.png)

#### 2. Run frontend and backend separately (in different server)
- Download the frontend and backend source code separately \
https://github.com/fanxwsam/employeemanager_front \
https://github.com/fanxwsam/employeemanager_backend
- Open the backend Maven project using IntelliJ IDEA (or other development tools)
- Start backend application server. The port is 8081
 ![image](https://user-images.githubusercontent.com/46641840/189536033-4a55b008-c7de-46bd-85cd-28281ee5a0be.png)

- Start frontend application server using proper tools, e.g. live-server \
If you use liver-server, please just run the command like below, \
live-server --port=8090 \
Port 8090 would be your frontend web port. You can choose which port you want to use. \
-	Access link http://localhost:8090
