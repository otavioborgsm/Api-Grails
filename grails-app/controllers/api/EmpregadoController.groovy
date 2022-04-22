import api.Empregado
import api.EmpregadoService
import grails.validation.ValidationException

class EmpregadoController {

    EmpregadoService empregadoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond empregadoService.list(params), model:[empregadoCount: empregadoService.count()]
    }

    def show(Long id) {
        respond empregadoService.get(id)
    }

    def save(Empregado empregado) {
        if (empregado == null) {
            render status: NOT_FOUND
            return
        }

        try {
            empregadoService.save(empregado)
        } catch (ValidationException e) {
            respond empregado.errors, view:'create'
            return
        }

        respond empregado, [status: CREATED, view:"show"]
    }

    def update(Empregado empregado) {
        if (empregado == null) {
            render status: NOT_FOUND
            return
        }

        try {
            empregadoService.save(empregado)
        } catch (ValidationException e) {
            respond empregado.errors, view:'edit'
            return
        }

        respond empregado, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        empregadoService.delete(id)

        render status: NO_CONTENT
    }
}