Join 被用来等待子线程完成然后继续运行程序。  
Code Example中 你可以看到 如果把第三步 Join 给 注释掉那么输出结果如下      
```
End of main thread!
I am thread 7
I am thread 17
I am thread 1
I am thread 4
I am thread 18
I am thread 9
I am thread 11
I am thread 8
I am thread 10
I am thread 14
I am thread 5
I am thread 13
I am thread 2
I am thread 19
I am thread 16
I am thread 0
I am thread 12
I am thread 6
I am thread 15
I am thread 3  
```  
如果不注释掉，main 会等待所有线程完成之后在继续运行。  
```  
I am thread 6
I am thread 1
I am thread 7
I am thread 0
I am thread 17
I am thread 8
I am thread 13
I am thread 15
I am thread 3
I am thread 9
I am thread 16
I am thread 18
I am thread 4
I am thread 12
I am thread 19
I am thread 14
I am thread 2
I am thread 11
I am thread 5
I am thread 10
End of main thread!
```  
  
 其次 Thread 还提供了Join(with time)，意思就是最多等待这个线程多久。[Doc](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html#join-long-)
