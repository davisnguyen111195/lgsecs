package io.github.lgsecs.utils

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.SkinLoader
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.utils.Disposable

class LGSAssetManager : Disposable{

    val manager = AssetManager()

    val uiskinPath = "skin_compose_by_dat.json"

    fun queueAddSkin() {
        val paramSkin = SkinLoader.SkinParameter("skin_compose_by_dat.atlas")
        manager.load(uiskinPath, Skin::class.java, paramSkin)
    }


    override fun dispose() {
        manager.dispose()
    }

    companion object {
        val instance: LGSAssetManager by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { LGSAssetManager() }
    }
}
