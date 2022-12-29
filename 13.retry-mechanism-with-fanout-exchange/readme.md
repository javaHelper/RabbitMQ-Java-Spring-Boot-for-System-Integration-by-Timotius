# Retry mechanism with fanout exchange

<img width="1129" alt="Screenshot 2022-12-29 at 8 33 35 PM" src="https://user-images.githubusercontent.com/54174687/209971750-13ad25ec-5659-4cb0-802d-2a4ac27468eb.png">

```
20:30:19.946  INFO --- c.course.rabbitmq.consumer.Application   : Starting Application using Java 11.0.13 on Prateeks-MacBook-Pro.local with PID 29146 (/Users/prats/Documents/workspace/rabbitmq.consumer/target/classes started by prateekashtikar in /Users/prats/Documents/workspace/rabbitmq.consumer)
20:30:19.992  INFO --- c.course.rabbitmq.consumer.Application   : No active profile set, falling back to 1 default profile: "default"
20:30:21.598  INFO --- o.s.a.r.c.CachingConnectionFactory       : Attempting to connect to: [localhost:5672]
20:30:21.682  INFO --- o.s.a.r.c.CachingConnectionFactory       : Created new connection: rabbitConnectionFactory#58fef7f7:0/SimpleConnection@66236a0a [delegate=amqp://guest@127.0.0.1:5672/, localPort= 57180]
20:30:21.814  INFO --- c.course.rabbitmq.consumer.Application   : Started Application in 2.402 seconds (JVM running for 3.448)
20:30:21.889  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-0, name=null, birthDate=2022-12-29)
20:30:21.891  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-1, name=null, birthDate=2022-12-29)
20:30:21.891  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-2, name=null, birthDate=2022-12-29)
20:30:21.891  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-3, name=null, birthDate=2022-12-29)
20:30:21.892  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-4, name=null, birthDate=2022-12-29)
20:30:21.892  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-5, name=null, birthDate=2022-12-29)
20:30:21.893  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-6, name=null, birthDate=2022-12-29)
20:30:21.893  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-7, name=null, birthDate=2022-12-29)
20:30:21.893  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-8, name=null, birthDate=2022-12-29)
20:30:21.894  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-9, name=null, birthDate=2022-12-29)
20:30:28.698  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-0, name=null, birthDate=2022-12-29)
20:30:28.699  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-0","birth_date":"2022-12-29"} : Name is empty
20:30:28.706  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-1, name=null, birthDate=2022-12-29)
20:30:28.711  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-2, name=null, birthDate=2022-12-29)
20:30:28.713  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-3, name=null, birthDate=2022-12-29)
20:30:28.715  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:28.715045 on retry 0 for message {"name":null,"employee_id":"emp-0","birth_date":"2022-12-29"}
20:30:28.715  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-4, name=null, birthDate=2022-12-29)
20:30:28.715  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-1","birth_date":"2022-12-29"} : Name is empty
20:30:28.715  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:28.715742 on retry 0 for message {"name":null,"employee_id":"emp-1","birth_date":"2022-12-29"}
20:30:28.716  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-2","birth_date":"2022-12-29"} : Name is empty
20:30:28.718  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-5, name=null, birthDate=2022-12-29)
20:30:28.719  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:28.719498 on retry 0 for message {"name":null,"employee_id":"emp-2","birth_date":"2022-12-29"}
20:30:28.720  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-6, name=null, birthDate=2022-12-29)
20:30:28.720  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-3","birth_date":"2022-12-29"} : Name is empty
20:30:28.720  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:28.720768 on retry 0 for message {"name":null,"employee_id":"emp-3","birth_date":"2022-12-29"}
20:30:28.720  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-7, name=null, birthDate=2022-12-29)
20:30:28.721  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-4","birth_date":"2022-12-29"} : Name is empty
20:30:28.721  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:28.721128 on retry 0 for message {"name":null,"employee_id":"emp-4","birth_date":"2022-12-29"}
20:30:28.721  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-8, name=null, birthDate=2022-12-29)
20:30:28.721  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-5","birth_date":"2022-12-29"} : Name is empty
20:30:28.721  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:28.721808 on retry 0 for message {"name":null,"employee_id":"emp-5","birth_date":"2022-12-29"}
20:30:28.722  INFO --- c.c.r.c.consumer.RetryMarketingConsumer  : On marketing : Employee(employeeId=emp-9, name=null, birthDate=2022-12-29)
20:30:28.722  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-6","birth_date":"2022-12-29"} : Name is empty
20:30:28.722  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:28.722121 on retry 0 for message {"name":null,"employee_id":"emp-6","birth_date":"2022-12-29"}
20:30:28.722  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-7","birth_date":"2022-12-29"} : Name is empty
20:30:28.723  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:28.723089 on retry 0 for message {"name":null,"employee_id":"emp-7","birth_date":"2022-12-29"}
20:30:28.723  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-8","birth_date":"2022-12-29"} : Name is empty
20:30:28.723  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:28.723690 on retry 0 for message {"name":null,"employee_id":"emp-8","birth_date":"2022-12-29"}
20:30:28.724  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-9","birth_date":"2022-12-29"} : Name is empty
20:30:28.724  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:28.724544 on retry 0 for message {"name":null,"employee_id":"emp-9","birth_date":"2022-12-29"}
20:30:58.743  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-0","birth_date":"2022-12-29"} : Name is empty
20:30:58.748  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:58.748064 on retry 1 for message {"name":null,"employee_id":"emp-0","birth_date":"2022-12-29"}
20:30:58.748  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-1","birth_date":"2022-12-29"} : Name is empty
20:30:58.748  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:58.748875 on retry 1 for message {"name":null,"employee_id":"emp-1","birth_date":"2022-12-29"}
20:30:58.749  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-2","birth_date":"2022-12-29"} : Name is empty
20:30:58.749  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:58.749433 on retry 1 for message {"name":null,"employee_id":"emp-2","birth_date":"2022-12-29"}
20:30:58.749  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-3","birth_date":"2022-12-29"} : Name is empty
20:30:58.750  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:58.750264 on retry 1 for message {"name":null,"employee_id":"emp-3","birth_date":"2022-12-29"}
20:30:58.755  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-4","birth_date":"2022-12-29"} : Name is empty
20:30:58.756  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:58.756411 on retry 1 for message {"name":null,"employee_id":"emp-4","birth_date":"2022-12-29"}
20:30:58.757  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-5","birth_date":"2022-12-29"} : Name is empty
20:30:58.757  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:58.757450 on retry 1 for message {"name":null,"employee_id":"emp-5","birth_date":"2022-12-29"}
20:30:58.758  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-6","birth_date":"2022-12-29"} : Name is empty
20:30:58.758  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:58.758182 on retry 1 for message {"name":null,"employee_id":"emp-6","birth_date":"2022-12-29"}
20:30:58.758  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-7","birth_date":"2022-12-29"} : Name is empty
20:30:58.758  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:58.758579 on retry 1 for message {"name":null,"employee_id":"emp-7","birth_date":"2022-12-29"}
20:30:58.758  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-8","birth_date":"2022-12-29"} : Name is empty
20:30:58.758  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:58.758946 on retry 1 for message {"name":null,"employee_id":"emp-8","birth_date":"2022-12-29"}
20:30:58.759  WARN --- c.c.r.c.c.RetryAccountingConsumer        : Error processing message : {"name":null,"employee_id":"emp-9","birth_date":"2022-12-29"} : Name is empty
20:30:58.759  WARN --- c.c.r.c.c.DlxProcessingErrorHandler      : [REQUEUE] Error at 2022-12-29T20:30:58.759358 on retry 1 for message {"name":null,"employee_id":"emp-9","birth_date":"2022-12-29"}
20:31:21.097  INFO --- inMXBeanRegistrar$SpringApplicationAdmin : Application shutdown requested.
20:31:21.118  INFO --- o.s.a.r.l.SimpleMessageListenerContainer : Waiting for workers to finish.
20:31:21.124  INFO --- o.s.a.r.l.SimpleMessageListenerContainer : Waiting for workers to finish.
20:31:21.880  INFO --- o.s.a.r.l.SimpleMessageListenerContainer : Successfully waited for workers to finish.
20:31:21.949  INFO --- o.s.a.r.l.SimpleMessageListenerContainer : Successfully waited for workers to finish.
20:31:21.952  INFO --- o.s.a.r.l.SimpleMessageListenerContainer : Shutdown ignored - container is already stopped
20:31:21.953  INFO --- o.s.a.r.l.SimpleMessageListenerContainer : Shutdown ignored - container is already stopped
```
