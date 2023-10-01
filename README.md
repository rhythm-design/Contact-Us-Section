# Contact-Us-Section

* This project is made using JSTL, PostgreSQL, JSP, and Servlets. A fully functional where any customer can submit their query to be responded to by the team once the solution is available.
* Once a solution is provided, the respective team can archive the request so that the request would become inactive.

![Untitled design](https://github.com/rhythm-design/Contact-Us-Section/assets/56234578/43f2d257-dbdb-465f-8377-3268ca2320f6)

```
LOGIN CREDENTIALS
Username- admin
Password- 12345
```

# Design Doc for Contact-Us Section
* When the app is launched, the homepage will consist of all the links to the pages. These button are made to make the navigation easy across the different features of the web-app made using JSP and Servlet.
  
![image](https://github.com/rhythm-design/Contact-Us-Section/assets/56234578/dbc0f780-2ffa-411b-baad-ab1c6733041b)

<h3>Contact Us Page</h3>
* Through this page, any user/customer can send their message to get it resolved by the team.

![image](https://github.com/rhythm-design/Contact-Us-Section/assets/56234578/ea4ece49-2a0e-4649-a5b7-e13da00712e5)
* The way Contact Us page works is that it calls a servlet. That servlet will then forward the request to jsp page to load the awesome frontend ready dynamic generated HTML-CSS page. Design structure for this link is


![Web Browser](https://github.com/rhythm-design/Contact-Us-Section/assets/56234578/f8278fc3-114e-408f-a9c0-eda8f1ec2c70)

<h3>Admin login page</h3>
* Through this page, a user with admin access can access all the messages of the customers. User needs to be authorized in order to read all the messages from different clients.

![image](https://github.com/rhythm-design/Contact-Us-Section/assets/56234578/26f690b9-63a6-412e-8fee-12c6e97225d7)
* Design logic for admin login page is-

![Web Browser (1)](https://github.com/rhythm-design/Contact-Us-Section/assets/56234578/c2b8ad70-477e-459c-ae65-d593c1299368)

<h3>User requests messages page</h3>
* Through this page, a admin can view all the active and archived request submitted by different users. This page uses less CSS to make page simple.

![image](https://github.com/rhythm-design/Contact-Us-Section/assets/56234578/4434d740-85a0-48d0-81d1-4dc587e16274)

* Design logic for the admin dashboard (`/admin/contactus/requests`) is


![3](https://github.com/rhythm-design/Contact-Us-Section/assets/56234578/3aec51a4-9ac7-4d59-ab8a-e2a2c4394067)

<h3>Single Message View</h3>

*  As we know messages can be quiet bigger and might not fit in table. So, their is view button also, by pressing that admin can view a single query in a nice and minimalist way. Messages can be archieved from here too :)

![image](https://github.com/rhythm-design/Contact-Us-Section/assets/56234578/f843c4ca-5e41-4ae5-8e64-8245f69720c2)

<h2>Give star to this repo if it is helpful</h2>
