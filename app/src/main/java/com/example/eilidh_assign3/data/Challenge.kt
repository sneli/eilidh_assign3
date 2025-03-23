package com.example.eilidh_assign3.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.eilidh_assign3.R

data class Challenge(
    @DrawableRes val imageResourceId: Int,
    @StringRes val chlngeDay: Int,
    @StringRes val chlngeName: Int,
    @StringRes val chlngeDesc: Int
)

val challenges = listOf(
    Challenge(R.drawable.day1_selfportrait, R.string.challenge_day1, R.string.name_day1, R.string.desc_day1),
    Challenge(R.drawable.day2_clouds, R.string.challenge_day2, R.string.name_day2, R.string.desc_day2),
    Challenge(R.drawable.day3_shadow, R.string.challenge_day3, R.string.name_day3, R.string.desc_day3),
    Challenge(R.drawable.day4_water, R.string.challenge_day4, R.string.name_day4, R.string.desc_day4),
    Challenge(R.drawable.day5_red, R.string.challenge_day5, R.string.name_day5, R.string.desc_day5),
    Challenge(R.drawable.day6_memory, R.string.challenge_day6, R.string.name_day6, R.string.desc_day6),
    Challenge(R.drawable.day7_sunset, R.string.challenge_day7, R.string.name_day7, R.string.desc_day7),
    Challenge(R.drawable.day8_flowers, R.string.challenge_day8, R.string.name_day8, R.string.desc_day8),
    Challenge(R.drawable.day9_hobby, R.string.challenge_day9, R.string.name_day9, R.string.desc_day9),
    Challenge(R.drawable.day10_orange, R.string.challenge_day10, R.string.name_day10, R.string.desc_day10),
    Challenge(R.drawable.day11_favplace, R.string.challenge_day11, R.string.name_day11, R.string.desc_day11),
    Challenge(R.drawable.day12_ootd, R.string.challenge_day12, R.string.name_day12, R.string.desc_day12),
    Challenge(R.drawable.day13_landscape, R.string.challenge_day13, R.string.name_day13, R.string.desc_day13),
    Challenge(R.drawable.day14_yellow, R.string.challenge_day14, R.string.name_day14, R.string.desc_day14),
    Challenge(R.drawable.day15_eyes, R.string.challenge_day15, R.string.name_day15, R.string.desc_day15),
    Challenge(R.drawable.day16_bw, R.string.challenge_day16, R.string.name_day16, R.string.desc_day16),
    Challenge(R.drawable.day17_closeup, R.string.challenge_day17, R.string.name_day17, R.string.desc_day17),
    Challenge(R.drawable.day18_green, R.string.challenge_day18, R.string.name_day18, R.string.desc_day18),
    Challenge(R.drawable.day19_lovedone, R.string.challenge_day19, R.string.name_day19, R.string.desc_day19),
    Challenge(R.drawable.day20_cannotlivewithout, R.string.challenge_day20, R.string.name_day20, R.string.desc_day20),
    Challenge(R.drawable.day21_patterns, R.string.challenge_day21, R.string.name_day21, R.string.desc_day21),
    Challenge(R.drawable.day22_bokeh, R.string.challenge_day22, R.string.name_day22, R.string.desc_day22),
    Challenge(R.drawable.day23_weather, R.string.challenge_day23, R.string.name_day23, R.string.desc_day23),
    Challenge(R.drawable.day24_inmotion, R.string.challenge_day24, R.string.name_day24, R.string.desc_day24),
    Challenge(R.drawable.day25_blue, R.string.challenge_day25, R.string.name_day25, R.string.desc_day25),
    Challenge(R.drawable.day26_silhouette, R.string.challenge_day26, R.string.name_day26, R.string.desc_day26),
    Challenge(R.drawable.day27_candid, R.string.challenge_day27, R.string.name_day27, R.string.desc_day27),
    Challenge(R.drawable.day28_distance, R.string.challenge_day28, R.string.name_day28, R.string.desc_day28),
    Challenge(R.drawable.day29_animal, R.string.challenge_day29, R.string.name_day29, R.string.desc_day29),
    Challenge(R.drawable.day30_purple, R.string.challenge_day30, R.string.name_day30, R.string.desc_day30),
)