package com.astutify.mvi.demo.domain.interactor

import com.astutify.mvi.demo.domain.IngredientRepository
import com.astutify.mvi.demo.domain.model.Ingredient
import com.astutify.mvi.demo.domain.model.Response
import io.reactivex.Single

class GetIngredientsUseCase (
    private val api: IngredientRepository
) {
    operator fun invoke(): Single<Response<List<Ingredient>>> {
        return api.getIngredients()
    }
}
