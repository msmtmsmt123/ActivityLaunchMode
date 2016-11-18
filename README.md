#深入Activity，Activity启动模式LaunchMode完全解析
>在平时的开发中，我们可能会了解到Activity的任务栈。

#1.Standard：标准启动模式
Activity的默认模式，所有的Activity元素遵循先进后出的进栈出栈的特性，这种的比较简单
>启动顺序：A->B->C
 回退顺序：C->B->A.

#2.SingleTop:栈顶复用模式
栈顶复用模式，如果想要打开的activity在任务栈的栈顶已经存在，就不会创重新建新的实例，而是调用该Activity的 onNewIntent() 方法。避免栈顶的activity被重复的创建。
>例如A.B启动模式为Standard，C启动模式为SingleTop
启动顺序：A->B->C—>C
回退顺序：C->B->A.而不是C->C->B->A


应用如下：
* 点击通知栏重复打开Activity的问题
在[全新的Android通知栏,已抛弃setLatestEventInfo,兼容高版本](http://blog.csdn.net/linglongxin24/article/details/53166551) 这篇文章里面
我们打开一个通知栏，点击通知栏默认打开MainActivity，有一个问题，就是如果不设置MainActivity的launchMode，就会每次点击通知栏的时候会重新打开一个Activity。
我们可以将MainActivity的启动模式设置为SingleInstance，就不会再重新打开MainActivity，而是调用MainActivity的onNewIntent() 方法。
#3.SingleTask:栈内复用模式
如果想要启动的Activity在当前栈内启动之后，该activity只会在任务栈里面存在一个实例。如果要再次打开这个activity，在任务栈里面如果已经存在，就不会创建新的activity，
而是复用栈内的这个已经存在的activity，调用改Activity的 onNewIntent() 方法，并且清空这个activity任务栈上面所有的activity。
#4.SingleInstance：单一实例模式
在整个Android系统中(可能会有很多任务栈)里面只有一个实例存在。不同的应用程序app去启动这个activity，就会共享公用同一个activity。
他会运行在自己单独的的任务栈里面，并且这个单独的任务栈里面只会存在着一个实例。
应用场景：系统的发短信，打电话，来电，浏览器等。这种模式在平时很少去使用，一般在Launcher中可能会用到。