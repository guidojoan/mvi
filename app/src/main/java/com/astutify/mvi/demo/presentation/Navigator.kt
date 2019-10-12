package com.astutify.mvi.demo.presentation

import androidx.appcompat.app.AppCompatActivity
import com.astutify.mvi.demo.Mockable
import com.astutify.mvi.demo.presentation.model.IngredientViewModel

@Mockable
class Navigator (
    private val activity: AppCompatActivity
) {

    fun goToAddIngredient(ingredient: IngredientViewModel? = null) {
    }

    fun goBack() {
        activity.finish()
    }
}
