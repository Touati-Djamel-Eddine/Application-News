package com.djamel.apirequestlibrary.Interface

import com.djamel.apirequestlibrary.Model.WapperDetailsMovie

interface MovieDetailsCallback {
    fun onSuccess(value: WapperDetailsMovie)
    fun onError()
}