package com.natiqhaciyef.travelguideapp.data.model

data class ResponseResult<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): ResponseResult<T> {
            return ResponseResult(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): ResponseResult<T> {
            return ResponseResult(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): ResponseResult<T> {
            return ResponseResult(Status.LOADING, data, null)
        }
    }
}
