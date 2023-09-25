package com.example.dictionaryapp.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryapp.feature_dictionary.data.remote.dto.License
import com.example.dictionaryapp.feature_dictionary.domain.model.Meaning
import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val sourceUrls: List<String>,
    val meanings: List<Meaning>,
    val license: License,
    @PrimaryKey val id: Int? = null
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            license = license,
            meanings = meanings,
            word = word,
            sourceUrls = sourceUrls,
            phonetic = phonetic
        )
    }
}
