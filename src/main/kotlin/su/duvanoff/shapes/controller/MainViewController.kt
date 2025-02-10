package su.duvanoff.shapes.controller

import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.*
import su.duvanoff.shapes.domain.model.AbstractShape
import su.duvanoff.shapes.domain.model.type.TypeOfMetal
import su.duvanoff.shapes.domain.service.BindService
import su.duvanoff.shapes.domain.service.DeformShapeService
import su.duvanoff.shapes.domain.service.impl.BindServiceImpl
import su.duvanoff.shapes.domain.service.impl.DeformShapeServiceImpl
import su.duvanoff.shapes.utils.isFloating
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

class MainViewController {
    @FXML
    private lateinit var newFileMenuItem: MenuItem
    @FXML
    private lateinit var openFileMenuItem: MenuItem
    @FXML
    private lateinit var saveToFileMenuItem: MenuItem
    @FXML
    private lateinit var saveToDataMenuItem: MenuItem
    @FXML
    private lateinit var clearMenuItem: MenuItem
    @FXML
    private lateinit var chartMenuItem: MenuItem

    @FXML
    private lateinit var cylinderRadio: RadioButton
    @FXML
    private lateinit var coneRadio: RadioButton
    @FXML
    private lateinit var parallRadio: RadioButton
    @FXML
    private lateinit var prismRadio: RadioButton

    @FXML
    private lateinit var baseField: TextField
    @FXML
    private lateinit var heightField: TextField
    @FXML
    private lateinit var metalChoice: ChoiceBox<TypeOfMetal>

    @FXML
    private lateinit var deformedBase: TextField
    @FXML
    private lateinit var deformedHeight: TextField

    @FXML
    private lateinit var calcButton: Button

    private lateinit var deformShapeService: DeformShapeService
    private lateinit var bindService: BindService

    private var currentShape: KClass<AbstractShape>? = null

    @FXML
    fun initialize() {
        deformShapeService = DeformShapeServiceImpl()
        bindService = BindServiceImpl()

        metalChoice.items = FXCollections.observableArrayList(TypeOfMetal.entries)

        ToggleGroup().apply {
            cylinderRadio.toggleGroup = this
            coneRadio.toggleGroup = this
            parallRadio.toggleGroup = this
            prismRadio.toggleGroup = this

            toggles.forEach {
                val radioButton = it as RadioButton
                val klass = bindService.bindTextToClass(radioButton.text)

                radioButton.userData = klass
            }

            selectedToggleProperty().addListener { observable, oldValue, newValue ->
                val selectedButton = newValue!! as ToggleButton

                currentShape = (selectedButton.userData as KClass<AbstractShape>)
            }
        }

        heightField.addFloatingPointFilter()
        baseField.addFloatingPointFilter()
    }

    fun onCalc() {
        // TODO
    }

    private fun TextField.addFloatingPointFilter(): TextField {
        textProperty().addListener { _, oldValue, newValue ->
            if (!(newValue.isFloating() || newValue.isEmpty()))
                text = oldValue
        }

        return this
    }
}