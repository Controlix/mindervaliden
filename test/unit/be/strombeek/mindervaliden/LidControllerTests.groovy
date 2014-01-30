package be.strombeek.mindervaliden



import org.junit.*
import grails.test.mixin.*

@TestFor(LidController)
@Mock(Lid)
class LidControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/lid/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.lidInstanceList.size() == 0
        assert model.lidInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.lidInstance != null
    }

    void testSave() {
        controller.save()

        assert model.lidInstance != null
        assert view == '/lid/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/lid/show/1'
        assert controller.flash.message != null
        assert Lid.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/lid/list'

        populateValidParams(params)
        def lid = new Lid(params)

        assert lid.save() != null

        params.id = lid.id

        def model = controller.show()

        assert model.lidInstance == lid
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/lid/list'

        populateValidParams(params)
        def lid = new Lid(params)

        assert lid.save() != null

        params.id = lid.id

        def model = controller.edit()

        assert model.lidInstance == lid
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/lid/list'

        response.reset()

        populateValidParams(params)
        def lid = new Lid(params)

        assert lid.save() != null

        // test invalid parameters in update
        params.id = lid.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/lid/edit"
        assert model.lidInstance != null

        lid.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/lid/show/$lid.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        lid.clearErrors()

        populateValidParams(params)
        params.id = lid.id
        params.version = -1
        controller.update()

        assert view == "/lid/edit"
        assert model.lidInstance != null
        assert model.lidInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/lid/list'

        response.reset()

        populateValidParams(params)
        def lid = new Lid(params)

        assert lid.save() != null
        assert Lid.count() == 1

        params.id = lid.id

        controller.delete()

        assert Lid.count() == 0
        assert Lid.get(lid.id) == null
        assert response.redirectedUrl == '/lid/list'
    }
}
