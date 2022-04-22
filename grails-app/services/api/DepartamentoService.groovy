package api

import grails.gorm.services.Service

@Service(Departamento)
interface DepartamentoService {

    Departamento get(Serializable id)

    List<Departamento> list(Map args)

    Long count()

    void delete(Serializable id)

    Departamento save(Departamento departamento)

}