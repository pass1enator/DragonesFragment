package es.instituto.dragonesadaptativo

import androidx.lifecycle.ViewModel
import es.instituto.dragonesadaptativo.models.Dragon

class DragonViewModel: ViewModel() {
    private var _dragones: MutableList<Dragon>
    private var _selected:Dragon?=null
    val dragones:List<Dragon>
        get() = _dragones.toList()
    var selected:Dragon?
        get()=_selected
        set(item){ _selected=item}
    init {
        this._dragones = mutableListOf()
        this._dragones.add(
            Dragon(
                "Arrax",
                5,
                6,
                "Color blanco perla con cresta y ojos dorados que expelía llamas amarillas",
                12
            )
        )
        this._dragones.add(
            Dragon(
                "Vhagar",
                150,
                170,
                "Hembra cuya mandíbula era lo suficientemente grande como para que pasara un caballo y su jinete",
                181
            )
        )

    }
}