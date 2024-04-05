package com.example.gadgetsfuture.config

import android.content.SharedPreferences

class config {

    //crear una variable static
    companion object{
        lateinit var SharedPreferences: SharedPreferences
        //una variable para el token
        var token:String = ""
        //crer una variable para almacenar la url base
        //puerto SENA:
        const val urlBase="http://192.168.137.1:8000/"
        //puerto local:
        //const val urlBase="http://192.168.1.5:8000/"


        const val urlTienda="${urlBase}tienda/api/v1/"
        const val urlCuenta="${urlBase}cuenta/api/"

    }
}