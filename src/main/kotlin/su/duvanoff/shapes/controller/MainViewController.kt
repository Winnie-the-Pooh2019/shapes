package su.duvanoff.shapes.controller

import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.canvas.Canvas
import javafx.scene.control.*
import su.duvanoff.shapes.domain.drawable.figure.Circle
import su.duvanoff.shapes.domain.drawable.figure.Triangle
import su.duvanoff.shapes.domain.drawable.primitive.Edge2d
import su.duvanoff.shapes.domain.drawable.primitive.Vertex2d
import su.duvanoff.shapes.domain.model.ModelShape
import su.duvanoff.shapes.domain.model.type.TypeOfMetal
import su.duvanoff.shapes.domain.service.BindService
import su.duvanoff.shapes.domain.service.DeformShapeService
import su.duvanoff.shapes.domain.service.DrawShapeService
import su.duvanoff.shapes.domain.service.impl.BindServiceImpl
import su.duvanoff.shapes.domain.service.impl.DeformShapeServiceImpl
import su.duvanoff.shapes.domain.service.impl.DrawShapeServiceImpl
import su.duvanoff.shapes.domain.drawable.type.Color
import su.duvanoff.shapes.exception.impl.CastingException
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

    @FXML
    private lateinit var canvas: Canvas

    private lateinit var deformShapeService: DeformShapeService
    private lateinit var drawShapeService: DrawShapeService
    private lateinit var bindService: BindService

    private var currentShape: KClass<ModelShape>? = null

    @FXML
    fun initialize() {
        deformShapeService = DeformShapeServiceImpl()
        drawShapeService = DrawShapeServiceImpl(canvas)
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

            selectedToggleProperty().addListener { _, _, newValue ->
                val selectedButton = newValue!! as ToggleButton

                currentShape = (selectedButton.userData as KClass<ModelShape>)
            }
        }

        heightField.addFloatingPointFilter()
        baseField.addFloatingPointFilter()
    }

    fun onCalc() {
        // TODO
        try {
            val height = heightField.text.toDouble()
            val base = baseField.text.toDouble()
            val metal = metalChoice.selectionModel.selectedItem

            val shape = currentShape!!.primaryConstructor?.call(metal, height, base) as ModelShape
            val deformedShape = deformShapeService.calc(shape)

            drawShapeService.draw(deformedShape, color = Color.GREEN)
            drawShapeService.draw(shape, color = Color.BLUE)

            val tri = Triangle<Double, Edge2d>(
                Edge2d(
                    Vertex2d(2.0, 3.0),
                    Vertex2d(2.0, 3.0),
                ),
                Edge2d(
                    Vertex2d(2.0, 3.0),
                    Vertex2d(2.0, 3.0),
                ),
                Edge2d(
                    Vertex2d(2.0, 3.0),
                    Vertex2d(2.0, 3.0)
                )
            )

            val sq = tri.square()

            val cir = Circle(
                Vertex2d(2.0, 3.0),
                5.0
            )
        } catch (e: NumberFormatException) {
            throw CastingException()
        }
    }

    private fun TextField.addFloatingPointFilter(): TextField {
        textProperty().addListener { _, oldValue, newValue ->
            if (!(newValue.isFloating() || newValue.isEmpty()))
                text = oldValue
        }

        return this
    }
}