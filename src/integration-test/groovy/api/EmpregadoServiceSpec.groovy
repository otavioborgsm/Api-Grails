package api

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EmpregadoServiceSpec extends Specification {

    EmpregadoService empregadoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Empregado(...).save(flush: true, failOnError: true)
        //new Empregado(...).save(flush: true, failOnError: true)
        //Empregado empregado = new Empregado(...).save(flush: true, failOnError: true)
        //new Empregado(...).save(flush: true, failOnError: true)
        //new Empregado(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //empregado.id
    }

    void "test get"() {
        setupData()

        expect:
        empregadoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Empregado> empregadoList = empregadoService.list(max: 2, offset: 2)

        then:
        empregadoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        empregadoService.count() == 5
    }

    void "test delete"() {
        Long empregadoId = setupData()

        expect:
        empregadoService.count() == 5

        when:
        empregadoService.delete(empregadoId)
        sessionFactory.currentSession.flush()

        then:
        empregadoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Empregado empregado = new Empregado()
        empregadoService.save(empregado)

        then:
        empregado.id != null
    }
}
