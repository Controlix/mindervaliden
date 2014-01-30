package be.strombeek.mindervaliden

import org.springframework.dao.DataIntegrityViolationException

class LidController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [lidInstanceList: Lid.list(params), lidInstanceTotal: Lid.count()]
    }

    def create() {
        [lidInstance: new Lid(params)]
    }

    def save() {
        def lidInstance = new Lid(params)
        if (!lidInstance.save(flush: true)) {
            render(view: "create", model: [lidInstance: lidInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'lid.label', default: 'Lid'), lidInstance.id])
        redirect(action: "show", id: lidInstance.id)
    }

    def show(Long id) {
        def lidInstance = Lid.get(id)
        if (!lidInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'lid.label', default: 'Lid'), id])
            redirect(action: "list")
            return
        }

        [lidInstance: lidInstance]
    }

    def edit(Long id) {
        def lidInstance = Lid.get(id)
        if (!lidInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'lid.label', default: 'Lid'), id])
            redirect(action: "list")
            return
        }

        [lidInstance: lidInstance]
    }

    def update(Long id, Long version) {
        def lidInstance = Lid.get(id)
        if (!lidInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'lid.label', default: 'Lid'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (lidInstance.version > version) {
                lidInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'lid.label', default: 'Lid')] as Object[],
                          "Another user has updated this Lid while you were editing")
                render(view: "edit", model: [lidInstance: lidInstance])
                return
            }
        }

        lidInstance.properties = params

        if (!lidInstance.save(flush: true)) {
            render(view: "edit", model: [lidInstance: lidInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'lid.label', default: 'Lid'), lidInstance.id])
        redirect(action: "show", id: lidInstance.id)
    }

    def delete(Long id) {
        def lidInstance = Lid.get(id)
        if (!lidInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'lid.label', default: 'Lid'), id])
            redirect(action: "list")
            return
        }

        try {
            lidInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'lid.label', default: 'Lid'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'lid.label', default: 'Lid'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def print(Long id) {
        def lidInstance = Lid.get(id)
        if (!lidInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'lid.label', default: 'Lid'), id])
            redirect(action: "list")
            return
        }
        redirect(action: "show", id: id)
	}
}
