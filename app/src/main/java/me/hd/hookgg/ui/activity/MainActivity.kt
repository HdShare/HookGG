package me.hd.hookgg.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.highcapable.yukihookapi.hook.factory.prefs
import me.hd.hookgg.MyApp
import me.hd.hookgg.config.data.SetPrefsData
import me.hd.hookgg.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private fun Context.setLanguage(locale: Locale): Context {
        return createConfigurationContext(
            resources.configuration.apply {
                Locale.setDefault(locale)
                setLocale(locale)
            }
        )
    }

    override fun attachBaseContext(newBase: Context) {
        val prefs = MyApp.context.prefs()
        val language = prefs.get(SetPrefsData.APP_LANGUAGE, Locale.getDefault().language)
        super.attachBaseContext(newBase.setLanguage(Locale(language)))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
    }

    override fun recreate() {
        super.finish()
        val intent = Intent(applicationContext, this::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        applicationContext.startActivity(intent)
    }
}