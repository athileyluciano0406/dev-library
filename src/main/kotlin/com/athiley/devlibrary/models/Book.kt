package com.athiley.devlibrary.models

import org.springframework.data.annotation.Id

class Book(var name: String?, private var isRead: Boolean?, @Id var isbnId: Number?) {

    override fun toString(): String {
        return String.format(
            "com.athiley.devlibrary.models.Customer[id=%s, firstName='%s', lastName='%s']",
            isbnId, name, isRead
        )
    }
}
