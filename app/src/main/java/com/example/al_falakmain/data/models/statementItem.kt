package com.example.al_falakmain.data.models

data class statementItem(
    val date:String,
    val accountId:String,
    val debit:Double,
    val credit:Double,
    val balance:Double
)
