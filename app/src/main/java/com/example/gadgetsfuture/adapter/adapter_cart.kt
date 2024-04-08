import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gadgetsfuture.R
import com.example.gadgetsfuture.item_carro

class adapter_cart(private val listaItems: List<item_carro>) :
    RecyclerView.Adapter<adapter_cart.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.txtNombreProducto)
        private val cantidadTextView: TextView = itemView.findViewById(R.id.txtCantidad)
        private val precioTextView: TextView = itemView.findViewById(R.id.txtPrecio)

        init {
            // Configura el click listener para los botones de sumar y restar
            itemView.findViewById<View>(R.id.btnSumar).setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listaItems[position].cantidad++
                    notifyItemChanged(position)
                }
            }

            itemView.findViewById<View>(R.id.btnRestar).setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION && listaItems[position].cantidad > 1) {
                    listaItems[position].cantidad--
                    notifyItemChanged(position)
                }
            }
        }

        fun bind(item: item_carro) {
            nombreTextView.text = item.nombre
            cantidadTextView.text = item.cantidad.toString()
            precioTextView.text = "$" + item.precioUnitario.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carro, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaItems[position])
    }

    override fun getItemCount() = listaItems.size
}
