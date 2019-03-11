package co.baron.data.mapper

/**
 * Created by asad on 11/03/19.
 */
interface EntityMapper<E, D> {

    fun mapFromEntity(entity: E): D

    fun mapToEntity(domain: D): E
}