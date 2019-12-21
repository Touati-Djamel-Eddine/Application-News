package com.djamel.apirequestlibrary.Interface

import com.djamel.apirequestlibrary.Model.LastNewsModel

interface LastNewsCallback {
    fun getNewsOnSuccess(value: ArrayList<LastNewsModel>)
    fun getNewsOnError()
}