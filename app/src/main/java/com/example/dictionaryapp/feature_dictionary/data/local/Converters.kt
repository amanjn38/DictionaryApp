package com.example.dictionaryapp.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionaryapp.feature_dictionary.data.remote.dto.License
import com.example.dictionaryapp.feature_dictionary.data.util.JsonParser
import com.example.dictionaryapp.feature_dictionary.domain.model.Meaning
import com.google.gson.reflect.TypeToken


@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromSourceUrlsJson(json: String): List<String> {
        return jsonParser.fromJson<ArrayList<String>>(
            json,
            object : TypeToken<ArrayList<String>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toSourceUrlsJson(sourceUrls: List<String>): String {
        return jsonParser.toJson(
            sourceUrls,
            object : TypeToken<ArrayList<String>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromLicenseJson(json: String): License {
        return jsonParser.fromJson(json, License::class.java) ?: License("","")
    }

    @TypeConverter
    fun toLicenseJson(license: License): String {
        return jsonParser.toJson(license, License::class.java) ?: "{}"
    }
}