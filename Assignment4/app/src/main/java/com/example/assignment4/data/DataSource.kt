package com.example.assignment4.data

import com.example.assignment4.R
import com.example.assignment4.model.Category
import com.example.assignment4.model.Recommendation


object DataSource {
    val defaultCategory = getCategoryData()[0]

    fun getCategoryData(): List<Category> {
        return listOf(
            Category(
                name = R.string.beach_clubs_category,
                recommendations = getBeachClubsData(),
                iconResourceId = R.drawable.beach_icon
            ),
            Category(
                name = R.string.restaurants_category,
                recommendations = getRestaurantsData(),
                iconResourceId = R.drawable.restaurant_icon
            ),
            Category(
                name = R.string.cenotes_category,
                recommendations = getCenotesData(),
                iconResourceId = R.drawable.cenote_icon
            )
        )
    }

    public fun getBeachClubsData(): List<Recommendation> {
        return listOf(
            Recommendation(
                id = 1,
                name = R.string.niken_name,
                address = R.string.niken_address,
                description = R.string.niken_description,
                image = R.drawable.niken
            ),
            Recommendation(
                id = 2,
                name = R.string.lula_name,
                description = R.string.lula_description,
                address = R.string.lula_address,
                image = R.drawable.lula
            ),
            Recommendation(
                id = 3,
                name = R.string.chiringuito_name,
                description = R.string.chiringuito_description,
                address = R.string.chiringuito_address,
                image = R.drawable.chiringuito
            ),
            Recommendation(
                id = 4,
                name = R.string.vagalume_name,
                description = R.string.vagalume_description,
                address = R.string.vagalume_address,
                image = R.drawable.vagalume
            )
        )
    }

    private fun getRestaurantsData(): List<Recommendation> {
        return listOf(
            Recommendation(
                id = 5,
                name = R.string.ukami_name,
                description = R.string.ukami_description,
                address = R.string.ukami_address,
                image = R.drawable.ukami
            ),
            Recommendation(
                id = 6,
                name = R.string.negra_tomasa_name,
                description = R.string.negra_tomasa_description,
                address = R.string.negra_tomasa_address,
                image = R.drawable.negra_tomasa
            ),
            Recommendation(
                id = 7,
                name = R.string.il_bacaro_name,
                description = R.string.il_bacaro_description,
                address = R.string.il_bacaro_address,
                image = R.drawable.il_bacaro
            ),
            Recommendation(
                id = 8,
                name = R.string.casa_jaguar_name,
                description = R.string.casa_jaguar_description,
                address = R.string.casa_jaguar_address,
                image = R.drawable.casa_jaguar
            )
        )
    }

    private fun getCenotesData(): List<Recommendation> {
        return listOf(
            Recommendation(
                id = 9,
                name = R.string.atik_name,
                description = R.string.atik_description,
                address = R.string.atik_address,
                image = R.drawable.cenote_atik
            ),
            Recommendation(
                id = 10,
                name = R.string.dos_ojos_name,
                description = R.string.dos_ojos_description,
                address = R.string.dos_ojos_address,
                image = R.drawable.cenote_dos_ojos
            ),
            Recommendation(
                id = 11,
                name = R.string.calavera_name,
                description = R.string.calavera_description,
                address = R.string.calavera_address,
                image = R.drawable.cenote_calavera
            ),
            Recommendation(
                id = 12,
                name = R.string.vesika_name,
                description = R.string.vesika_description,
                address = R.string.vesika_address,
                image = R.drawable.cenote_vesika
            )
        )
    }
}
