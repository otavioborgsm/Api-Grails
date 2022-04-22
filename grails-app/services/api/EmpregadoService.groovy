package api

import grails.gorm.services.Service

@Service(Empregado)
interface EmpregadoService {

    Empregado get(Serializable id)

    List<Empregado> list(Map args)

    Long count()

    void delete(Serializable id)

    Empregado save(Empregado empregado)

}