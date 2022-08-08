package com.example.jhkim20220707

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Serializable
    data class User(val name: String, val age: Int)

    @Test
    fun test() {
        val user = User("jiho", 37)
        val string = Json.encodeToString(user)
        println(string)
        val obj = Json.decodeFromString<User>(string)
        print(obj)
    }





}