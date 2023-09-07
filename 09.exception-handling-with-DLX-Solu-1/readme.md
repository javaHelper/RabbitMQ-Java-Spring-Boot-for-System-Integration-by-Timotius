# Dead Letter Exchange

This is recommanded approach. 

- Exception might happened 
- Spring By default will require message
- Infinte Consumer loop
- Send problematic messages to DLX with requeue = false
- Other consumer can process DLX queue with proper error handling 
- DLX is a normal exchange


Handling Exception on Consumer

This section will talk about basic error handling in RabbitMQ.

Message can live forever in a queue, if no consumer that consumes it. Or, message can be discarded and gone if something wrong happened during consumer logic.

RabbitMQ has a mechanism called DLX, or Dead Letter Exchange. Messages from a queue can be 'dead-lettered'; that is, republished to another exchange when any of the following events occur: 

- The message is rejected with requeue=false
- The TTL (time to live) for the message expires
- The queue length limit is exceeded

This mechanism is useful to handle invalid messages, without discard it.

In this section, we will learn about Dead Letter Exchange, and TTL (Time To Live), and of course we will do some java coding.

<img width="1375" alt="Screenshot 2022-12-29 at 7 35 40 PM" src="https://user-images.githubusercontent.com/54174687/209964962-ad29bd5e-8e9b-440a-b6d5-c9cc7552d413.png">

<img width="865" alt="Screenshot 2022-12-29 at 7 36 07 PM" src="https://user-images.githubusercontent.com/54174687/209965002-ad8d0ced-6726-4fa7-8363-4ae1eab61bbf.png">

<img width="884" alt="Screenshot 2022-12-29 at 7 36 31 PM" src="https://user-images.githubusercontent.com/54174687/209965007-0cea7c86-92df-4b81-ad58-9307a732ba6d.png">

<img width="1158" alt="Screenshot 2022-12-29 at 7 36 43 PM" src="https://user-images.githubusercontent.com/54174687/209965011-6ee59d63-2b74-497b-84ba-297c5cf478ed.png">

<img width="852" alt="Screenshot 2022-12-29 at 7 37 08 PM" src="https://user-images.githubusercontent.com/54174687/209965026-14fab476-4475-4723-98ad-2d2f3b146738.png">

<img width="782" alt="Screenshot 2022-12-29 at 7 39 58 PM" src="https://user-images.githubusercontent.com/54174687/209965136-bb8fc0ba-720f-42ba-9712-fb7f0bbed05b.png">
