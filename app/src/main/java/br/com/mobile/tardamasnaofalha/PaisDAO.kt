package br.com.mobile.tardamasnaofalha

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PaisDAO {

    @Query("SELECT * FROM pais where id = :id")
    fun getById(id: Long): Pais?

    @Query("SELECT * FROM pais")
    fun findAll(): List<Pais>

    @Insert
    fun insert(pais: Pais)

    @Delete
    fun delete(pais: Pais)
}