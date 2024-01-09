package es.instituto.dragonesadaptativo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.instituto.dragonesadaptativo.databinding.ActivityMainBinding
import es.instituto.dragonesadaptativo.models.Dragon


class ListFragment : Fragment() {

    private lateinit var v: View
    private val dragonviewmodel: DragonViewModel by activityViewModels()

    class MainActivity : AppCompatActivity() {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_list, container, false)
        val recyclerView: RecyclerView = v.findViewById<RecyclerView>(R.id.recyclerview)
        var adaptador = DragonRecyclerViewAdapter(this.dragonviewmodel.dragones)
        adaptador.click = { position, dragon ->
            run {
                //se selecciona el dragón
            this.dragonviewmodel.selected=dragon
            val fm: FragmentManager = parentFragmentManager
                    fm.commit {
                        replace(R.id.fragmentContainerView, DetailFragment.newInstance())
                        addToBackStack("replacement")
                    }

            }
        }
        val layoutManager = GridLayoutManager(this.context, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adaptador
        return v
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ListFragment().apply {

            }
    }
}