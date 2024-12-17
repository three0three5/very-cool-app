package org.example.baseapp.exception

import org.example.baseapp.utils.ExceptionKey

class EmptyResponseException(
    val exceptionKey: ExceptionKey = ExceptionKey.EMPTY_RESPONSE_FROM_EXTERNAL_SERVICE
): RuntimeException()