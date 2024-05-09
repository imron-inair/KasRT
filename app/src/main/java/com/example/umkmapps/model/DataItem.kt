package com.example.umkmapps.model

import com.google.gson.annotations.SerializedName
import java.math.BigInteger

data class DataItem(
    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("first_name")
    val firstName: String? = null,

    @field:SerializedName("last_name")
    val lastName: String? = null,

    @field:SerializedName("alamat")
    val alamat: String? = null,

    @field:SerializedName("total_iuran_bulanan")
    val totalIuranBulanan: Int? = null,

    @field:SerializedName("total_iuran_individu")
    val totalIuranIndividu: Int? = null,

    @field:SerializedName("total_iuran_akhir")
    val totalIuranAkhir: Long? = null,

    @field:SerializedName("pengeluaran_iuran")
    val pengeuaranIuran: Int? = null,

    @field:SerializedName("pemanfaatan_iuran")
    val pemanfaatanIuaran: String? = null,

    @field:SerializedName("avatar")
    val avatar: String? = null,

)
