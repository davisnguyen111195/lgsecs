package io.github.lgsecs.views.lgsPanel

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx.*
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.Scaling
import io.github.lgsecs.Main.Companion.HEIGHT
import io.github.lgsecs.Main.Companion.WIDTH
import io.github.lgsecs.Main.Companion.assetManager

class ListElementActor(stage: Stage) : Actor(){


    private val table: Table = Table()
    private val scrollPane : ScrollPane
    private val skin : Skin = assetManager.manager.get(assetManager.uiskinPath, Skin::class.java)
    private val buttonList : MutableList<CheckBox>
    init {
        val checkboxGroup = ButtonGroup<CheckBox>().apply {
            setMinCheckCount(0)
            setMaxCheckCount(1)
        }
        buttonList = mutableListOf()
        val scrollPaneStyle = skin.get(ScrollPane.ScrollPaneStyle::class.java).apply {
            vScrollKnob.minWidth = 8f
            vScroll.minWidth = 8f
            background = skin.getDrawable("list")
        }
        buttonList.add(CheckBox("", skin, "AND").apply {
            image.setScaling(Scaling.fill)
            imageCell.size(WIDTH / 23, HEIGHT / 15)
        })
        buttonList.add(CheckBox("", skin, "OR").apply {
            image.setScaling(Scaling.fill)
            imageCell.size(WIDTH / 23, HEIGHT / 15)
        })
        buttonList.add(CheckBox("", skin, "SWITCH").apply {
            image.setScaling(Scaling.fill)
            imageCell.size(WIDTH / 23, HEIGHT / 15)
        })

        buttonList.add(CheckBox("", skin, "LIGHT").apply {
            image.setScaling(Scaling.fill)
            imageCell.size(WIDTH / 23, HEIGHT / 15)
        })

        for (checkbox in buttonList) {
            table.add(checkbox).apply {
                left()
                pad(5f)
                width(100f)
                row()
            }
            checkboxGroup.add(checkbox)
        }
        scrollPane = ScrollPane(table, scrollPaneStyle).apply {
            when (app.type) {
                Application.ApplicationType.Android -> setSize(WIDTH / 13, HEIGHT)
                Application.ApplicationType.Desktop -> setSize(WIDTH / 11, HEIGHT)
                else -> setSize(WIDTH / 10, HEIGHT)
            }
            setPosition(0f, 0f)
            setScrollBarPositions(false, false)
            setScrollingDisabled(true, false)
        }
        stage.addActor(scrollPane)
    }

    companion object{
        const val AND_GATE = 0x1
    }
}
