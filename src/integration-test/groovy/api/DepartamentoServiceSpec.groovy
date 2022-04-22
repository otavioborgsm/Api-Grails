package api

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DepartamentoServiceSpec extends Specification {

    DepartamentoService departamentoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Departamento(...).save(flush: true, failOnError: true)
        //new Departamento(...).save(flush: true, failOnError: true)
        //Departamento departamento = new Departamento(...).save(flush: true, failOnError: true)
        //new Departamento(...).save(flush: true, failOnError: true)
        //new Departamento(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //departamento.id
    }

    void "test get"() {
        setupData()

        expect:
        departamentoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Departamento> departamentoList = departamentoService.list(max: 2, offset: 2)

        then:
        departamentoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        departamentoService.count() == 5
    }

    void "test delete"() {
        Long departamentoId = setupData()

        expect:
        departamentoService.count() == 5

        when:
        departamentoService.delete(departamentoId)
        sessionFactory.currentSession.flush()

        then:
        departamentoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Departamento departamento = new Departamento()
        departamentoService.save(departamento)

        then:
        departamento.id != null
    }
}
