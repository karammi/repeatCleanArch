package co.baron.cache.mapper

/**
 * Created by asad on 13/03/19.
 */
interface CacheMapper<C, E> {
    fun mapFromCached(type: C): E

    fun mapToCached(type: E): C
}