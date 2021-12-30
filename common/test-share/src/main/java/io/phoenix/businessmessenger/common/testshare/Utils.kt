package io.phoenix.businessmessenger.common.testshare

import org.junit.Assert

fun assertThrows(v: Exception, e: Exception) {
    if ((v.javaClass != e.javaClass) && (v.message != e.message)) {
        Assert.fail()
    }
}