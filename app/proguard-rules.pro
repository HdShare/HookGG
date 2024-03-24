-keep class me.hd.hookgg.hook.Entry

#处理扩展类和类成员的访问修饰符
-allowaccessmodification
#允许多个字段和方法相同名称,只是参数和返回类型不同
-overloadaggressively
#重新包装所有已重命名的类文件,移动到给定的单一包中
-repackageclasses 'androidx.hdshare'
