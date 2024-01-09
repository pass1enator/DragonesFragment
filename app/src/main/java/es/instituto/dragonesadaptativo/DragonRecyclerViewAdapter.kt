package es.instituto.dragonesadaptativo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.instituto.dragonesadaptativo.databinding.FragmentItemBinding
import es.instituto.dragonesadaptativo.models.Dragon


class DragonRecyclerViewAdapter(
    private val values: List<Dragon>
) : RecyclerView.Adapter<DragonRecyclerViewAdapter.ViewHolder>() {
    var click: ((Int, Dragon) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = position.toString()
        holder.contentView.text = item.nombre
        holder.button.setOnClickListener {

            this.click?.let { it1 -> it1(position, values[position]) }

        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content
        val button: Button = binding.button
        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}