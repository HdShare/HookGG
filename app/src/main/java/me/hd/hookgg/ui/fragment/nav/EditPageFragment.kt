package me.hd.hookgg.ui.fragment.nav

import android.graphics.Typeface
import androidx.lifecycle.ViewModel
import com.highcapable.yukihookapi.YukiHookAPI
import io.github.rosemoe.sora.langs.textmate.TextMateColorScheme
import io.github.rosemoe.sora.langs.textmate.TextMateLanguage
import io.github.rosemoe.sora.langs.textmate.registry.FileProviderRegistry
import io.github.rosemoe.sora.langs.textmate.registry.GrammarRegistry
import io.github.rosemoe.sora.langs.textmate.registry.ThemeRegistry
import io.github.rosemoe.sora.langs.textmate.registry.dsl.languages
import io.github.rosemoe.sora.langs.textmate.registry.model.ThemeModel
import io.github.rosemoe.sora.langs.textmate.registry.provider.AssetsFileResolver
import me.hd.hookgg.R
import me.hd.hookgg.databinding.FragmentEditPageBinding
import me.hd.hookgg.ui.fragment.base.BaseFragment
import org.eclipse.tm4e.core.registry.IThemeSource

class EditPageFragment : BaseFragment<FragmentEditPageBinding, ViewModel>(
    FragmentEditPageBinding::inflate,
    null
) {
    override fun initFragment(binding: FragmentEditPageBinding, viewModel: ViewModel?) {
        initView(binding)
    }

    private fun initView(binding: FragmentEditPageBinding) {
        if (YukiHookAPI.Status.isModuleActive) {
            binding.editPageToolbar.subtitle = getString(R.string.module_active)
        }
        initCodeEditor(binding)
    }

    private fun initCodeEditor(binding: FragmentEditPageBinding) {
        val typeface =
            Typeface.createFromAsset(requireContext().assets, "font/JetBrainsMono-Regular.ttf")
        binding.editPageCodeEditor.typefaceText = typeface

        val symbolInputView = binding.editPageSymbolInputView
        symbolInputView.bindEditor(binding.editPageCodeEditor)
        symbolInputView.addSymbols(
            arrayOf(
                "(", ")", "[", "]", "{", "}", "\"", "=", ":", ".", ",", ":", "_", "+", "-",
                "*", "/", "\\", "%", "#", "^", "$", "?", "&", "|", "<", ">", "~", "'"
            ),
            arrayOf(
                "(", ")", "[", "]", "{", "}", "\"", "=", ":", ".", ",", ":", "_", "+", "-",
                "*", "/", "\\", "%", "#", "^", "$", "?", "&", "|", "<", ">", "~", "'"
            )
        )

        FileProviderRegistry.getInstance().addFileProvider(
            AssetsFileResolver(
                requireContext().assets
            )
        )

        val path = "textmate/quietlight.json"
        ThemeRegistry.getInstance().loadTheme(
            ThemeModel(
                IThemeSource.fromInputStream(
                    FileProviderRegistry.getInstance().tryGetInputStream(path), path, null
                ),
                "quietlight"
            )
        )
        ThemeRegistry.getInstance().setTheme("quietlight")

        GrammarRegistry.getInstance().loadGrammars(
            languages {
                language("lua") {
                    grammar = "textmate/lua/syntaxes/lua.tmLanguage.json"
                    scopeName = "source.lua"
                    languageConfiguration = "textmate/lua/language-configuration.json"
                }
            }
        )

        var editorColorScheme = binding.editPageCodeEditor.colorScheme
        if (editorColorScheme !is TextMateColorScheme) {
            editorColorScheme = TextMateColorScheme.create(ThemeRegistry.getInstance())
            binding.editPageCodeEditor.colorScheme = editorColorScheme
        }

        val language = TextMateLanguage.create("source.lua", true)
        binding.editPageCodeEditor.setEditorLanguage(language)

    }
}