-keep class me.hd.hookgg.hook.Entry
-keep class com.highcapable.yukihookapi.** {*;}

-dontwarn javax.script.ScriptEngineFactory

-obfuscationdictionary obf-dict.txt
-classobfuscationdictionary obf-dict.txt
-packageobfuscationdictionary obf-dict.txt

-allowaccessmodification
-overloadaggressively
-repackageclasses 'me.hd.hookgg.obf'
