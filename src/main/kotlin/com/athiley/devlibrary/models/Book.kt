package com.athiley.devlibrary.models

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("books")
class Book(
    var name: String?,
    var isRead: Boolean?,
    @Id var isbnId: Number?
    ) {

    override fun toString(): String {
        return String.format(
            "com.athiley.devlibrary.models.Customer[id=%s, firstName='%s', lastName='%s']",
            isbnId, name, isRead
        )
    }
}
