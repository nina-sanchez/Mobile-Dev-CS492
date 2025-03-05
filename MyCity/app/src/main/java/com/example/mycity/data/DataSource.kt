// Regina Sanchez
// OSU
// CS 492

package com.example.mycity.data

import com.example.mycity.model.Categories
import com.example.mycity.model.Recommendations
import com.example.mycity.R

object DataSource {
    val firstItem: Categories = getCategories()[0]
    fun getCategories(): List<Categories> {
        return listOf(
            Categories(
                name = R.string.category_1,
                image = R.drawable.category_bc
            ),
            Categories(
                name = R.string.category_2,
                image = R.drawable.category_res
            ),
            Categories(
                name = R.string.category_3,
                image = R.drawable.category_cenotes
            )
        )
    }
    val secondItem: Recommendations = getBeachClubs()[0]
    fun getBeachClubs(): List<Recommendations> {
        return listOf(
            Recommendations(
                id = 1,
                name = R.string.Niken_name,
                address = R.string.Niken_address,
                description = R.string.Niken_description,
                image = R.drawable.niken
            ),
            Recommendations(
                id = 2,
                name = R.string.Lula_name,
                address = R.string.Lula_address,
                description = R.string.Lula_description,
                image = R.drawable.lula
            ),
            Recommendations(
                id = 3,
                name = R.string.Chiringuito_name,
                address = R.string.Chiringuito_address,
                description = R.string.Chiringuito_description,
                image = R.drawable.chiringuito
            ),
            Recommendations(
                id = 4,
                name = R.string.Vagalume_name,
                address = R.string.Vagalume_address,
                description = R.string.Vagalume_description,
                image = R.drawable.vagalume
            )
        )
    }

    fun getRestaurants(): List<Recommendations> {
        return listOf(
            Recommendations(
                id = 5,
                name = R.string.ukami_name,
                address = R.string.ukami_address,
                description = R.string.ukami_description,
                image = R.drawable.ukami
            ),
            Recommendations(
                id = 6,
                name = R.string.negra_tomasa_name,
                address = R.string.negra_tomasa_address,
                description = R.string.negra_tomasa_description,
                image = R.drawable.negra_tomasa
            ),
            Recommendations(
                id = 7,
                name = R.string.casa_jaguar_name,
                address = R.string.casa_jaguar_address,
                description = R.string.casa_jaguar_description,
                image = R.drawable.casa_jaguar
            ),
            Recommendations(
                id = 8,
                name = R.string.il_bacaro_name,
                address = R.string.il_bacaro_address,
                description = R.string.il_bacaro_description,
                image = R.drawable.il_bacaro
            )
        )
    }

    fun getCenotes(): List<Recommendations> {
        return listOf(
            Recommendations(
                id = 9,
                name = R.string.atik_name,
                address = R.string.atik_address,
                description = R.string.atik_description,
                image = R.drawable.cenote_atik
            ),
            Recommendations(
                id = 10,
                name = R.string.dos_ojos_name,
                address = R.string.dos_ojos_address,
                description = R.string.dos_ojos_description,
                image = R.drawable.cenote_dos_ojos
            ),
            Recommendations(
                id = 11,
                name = R.string.calavera_name,
                address = R.string.calavera_address,
                description = R.string.calavera_description,
                image = R.drawable.cenote_calavera
            ),
            Recommendations(
                id = 12,
                name = R.string.vesika_name,
                address = R.string.vesika_address,
                description = R.string.vesika_description,
                image = R.drawable.cenote_vesika
            )
        )
    }
}