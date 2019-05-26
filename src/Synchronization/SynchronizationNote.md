多线程情况下两种常见的问题:   
1. Thread Interference  
   a. 多个线程同时处理同一个数据，线程之间的操作交错造成了结果不准确。
2. Memory Consistency Errors  
   a. 多个线程同时处理同一个数据，线程之间对这个数据目前的状态(内容等)的认知是不一致的。Happens-Before 关系。  
   b. 当A thread 和B thread 建立了Happens-Before 关系,那他们之间就创立的一个协定。这个协定规定了，B 中看到的数据的结果都是A 对这个数据处理完的结果. A always happens before B.
   


解决办法：
1. Synchronized methods/statement.
2. Volatile [difference between volatile and Synchronized](https://stackoverflow.com/questions/3519664/difference-between-volatile-and-synchronized-in-java)


结论：  
1. 线程安全由两部分组成 a. execution order b. memory consistency(visiblity)
2. Synchronized 通过 intrinsic lock 保证了execution order 和 happens-before关系保证了memory consistency.  
3. Volatile 不能保证execution order但是能保证memory consistency.