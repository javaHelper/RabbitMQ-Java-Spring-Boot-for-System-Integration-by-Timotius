# Retry Mechanism For Direct Exchange!

<img width="1061" alt="Screenshot 2022-12-29 at 8 16 21 PM" src="https://user-images.githubusercontent.com/54174687/209969555-4baed8b6-3185-446b-abc6-525df6f75ba1.png">


```
20:10:47.178  INFO --- c.course.rabbitmq.consumer.Application   : Starting Application using Java 11.0.13 on Prateeks-MacBook-Pro.local with PID 27900 (/Users/prats/Documents/workspace/rabbitmq.consumer/target/classes started by prateekashtikar in /Users/prats/Documents/workspace/rabbitmq.consumer)
20:10:47.180  INFO --- c.course.rabbitmq.consumer.Application   : No active profile set, falling back to 1 default profile: "default"
20:10:48.774  INFO --- o.s.a.r.c.CachingConnectionFactory       : Attempting to connect to: [localhost:5672]
20:10:48.868  INFO --- o.s.a.r.c.CachingConnectionFactory       : Created new connection: rabbitConnectionFactory#2370ac7a:0/SimpleConnection@210d2a6c [delegate=amqp://guest@127.0.0.1:5672/, localPort= 56899]
20:10:48.972  INFO --- c.course.rabbitmq.consumer.Application   : Started Application in 2.409 seconds (JVM running for 3.263)
20:10:55.205  WARN --- c.c.r.c.consumer.RetryImageConsumer      : Error processing message : {"name":"Picture 0","type":"jpg","source":"mobile","size":9691} : Size too large
20:10:55.213  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:10:55.213842 on retry 0 for message {"name":"Picture 0","type":"jpg","source":"mobile","size":9691}
20:11:25.236  WARN --- c.c.r.c.consumer.RetryImageConsumer      : Error processing message : {"name":"Picture 0","type":"jpg","source":"mobile","size":9691} : Size too large
20:11:25.244  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:11:25.244726 on retry 1 for message {"name":"Picture 0","type":"jpg","source":"mobile","size":9691}
20:11:55.274  WARN --- c.c.r.c.consumer.RetryImageConsumer      : Error processing message : {"name":"Picture 0","type":"jpg","source":"mobile","size":9691} : Size too large
20:11:55.275  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:11:55.275239 on retry 2 for message {"name":"Picture 0","type":"jpg","source":"mobile","size":9691}
20:12:25.299  WARN --- c.c.r.c.consumer.RetryImageConsumer      : Error processing message : {"name":"Picture 0","type":"jpg","source":"mobile","size":9691} : Size too large
20:12:25.300  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [DEAD] Error at 2022-12-29T20:12:25.300399 on retry 3 for message {"name":"Picture 0","type":"jpg","source":"mobile","size":9691}
```

