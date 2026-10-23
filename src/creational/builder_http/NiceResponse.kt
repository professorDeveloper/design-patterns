package creational.builder_http


sealed class Resource<out T : Any> {
    data class Success<out T : Any>(val data: T) : Resource<T>()
    data class Error(val throwable: NiceHttpError) : Resource<Nothing>()
}