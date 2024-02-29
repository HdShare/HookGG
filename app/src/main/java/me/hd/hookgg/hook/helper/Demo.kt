package me.hd.hookgg.hook.helper

import com.highcapable.yukihookapi.hook.param.PackageParam
import org.luckypray.dexkit.DexKitBridge
import org.luckypray.dexkit.query.enums.MatchType
import org.luckypray.dexkit.query.enums.StringMatchType
import java.lang.reflect.Modifier

object Demo {

    private fun test(packageParam: PackageParam) {
        DexKitHelper.create(packageParam) {
            findPlayActivity(this)
        }
    }

    private fun findPlayActivity(bridge: DexKitBridge) {
        val classData = bridge.findClass {
            // 指定搜索的包名范围
            searchPackages("org.luckypray.dexkit.demo")
            // 排除指定的包名范围
            excludePackages("org.luckypray.dexkit.demo.annotations")
            // ClassMatcher 针对类的匹配器
            matcher {
                // FieldsMatcher 针对类中包含字段的匹配器
                fields {
                    // 添加对于字段的匹配器
                    add {
                        // 指定字段的修饰符
                        modifiers = Modifier.PRIVATE or Modifier.STATIC or Modifier.FINAL
                        // 指定字段的类型
                        type = "java.lang.String"
                        // 指定字段的名称
                        name = "TAG"
                    }
                    // 添加指定字段的类型的字段匹配器
                    addForType("android.widget.TextView")
                    addForType("android.os.Handler")
                    // 指定类中字段的数量
                    count = 3
                }
                // MethodsMatcher 针对类中包含方法的匹配器
                methods {
                    // 添加对于方法的匹配器
                    add {
                        // 指定方法的修饰符
                        modifiers = Modifier.PROTECTED
                        // 指定方法的名称
                        name = "onCreate"
                        // 指定方法的返回值类型
                        returnType = "void"
                        // 指定方法的参数类型，如果参数类型不确定，使用 null，使用此方法会隐式声明参数个数
                        paramTypes("android.os.Bundle")
                        // 指定方法中使用的字符串
                        usingStrings("onCreate")
                    }
                    add {
                        paramTypes("android.view.View")
                        // 指定方法中使用的数字，类型为 Byte, Short, Int, Long, Float, Double 之一
                        usingNumbers(0.01, -1, 0.987, 0, 114514)
                    }
                    add {
                        paramTypes("boolean")
                        // 指定方法中调用的方法列表
                        invokeMethods {
                            add {
                                modifiers = Modifier.PUBLIC or Modifier.STATIC
                                returnType = "int"
                                // 指定方法中调用的方法中使用的字符串，所有字符串均使用 Equals 匹配
                                usingStrings(listOf("getRandomDice: "), StringMatchType.Equals)
                            }
                            // 只需要包含上述方法的调用即可
                            matchType = MatchType.Contains
                        }
                    }
                    // 指定类中方法的数量，最少不少于1个，最多不超过10个
                    count(1..10)
                }
                // AnnotationsMatcher 针对类中包含注解的匹配器
                annotations {
                    // 添加对于注解的匹配器
                    add {
                        // 指定注解的类型
                        type = "org.luckypray.dexkit.demo.annotations.Router"
                        // 该注解需要包含指定的 element
                        addElement {
                            // 指定 element 的名称
                            name = "path"
                            // 指定 element 的值
                            stringValue("/play")
                        }
                    }
                }
                // 类中所有方法使用的字符串
                usingStrings("PlayActivity", "onClick", "onCreate")
            }
        }.singleOrNull() ?: error("返回结果不唯一")
        // 打印找到的类：org.luckypray.dexkit.demo.PlayActivity
        println(classData.name)
        // Get the corresponding class instance
        //val clazz = classData.getInstance(loadPackageParam.classLoader)
    }
}