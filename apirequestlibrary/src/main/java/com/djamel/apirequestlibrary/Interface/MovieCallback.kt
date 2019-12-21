package com.djamel.apirequestlibrary.Interface

import com.djamel.apirequestlibrary.MovieDataModel

interface MovieCallback {
    fun onSuccess(value: ArrayList<MovieDataModel>)
    fun onError()
}