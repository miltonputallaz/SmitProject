package com.sanicorporation.smitproject.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.sanicorporation.smitproject.R
import com.sanicorporation.smitproject.domain.Specie

class SpeciesRecyclerAdapter(
        var species: List<Specie>
): RecyclerView.Adapter<SpeciesRecyclerAdapter.SpecieViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.specie_item, parent,false)
        return SpecieViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpecieViewHolder, position: Int) {
        val specie: Specie = species.get(position)
        holder.bind(specie)
        holder.listen{ pos, type ->
            holder.switchTouched()
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = species.size

    fun setNewSpecies(newSpecies: List<Specie>){
        this.species = newSpecies
        notifyDataSetChanged()
    }

    inner class SpecieViewHolder(view: View): RecyclerView.ViewHolder(view){

        val name: TextView = view.findViewById(R.id.specie_name)
        val classification: TextView = view.findViewById(R.id.specie_classification)
        val designation: TextView = view.findViewById(R.id.specie_designation)
        var touched: Boolean = false

        fun switchTouched(){
            touched = !touched
        }

        fun bind(specie: Specie){
            name.text = specie.name
            classification.text = specie.classification
            designation.text = specie.designation
            if (touched){
                val background: ConstraintLayout = itemView.findViewById(R.id.background)
                background.setBackgroundColor(background.context.resources.getColor(R.color.green))
            } else {
                val background: ConstraintLayout = itemView.findViewById(R.id.background)
                background.setBackgroundColor(background.context.resources.getColor(R.color.white))
            }

        }
    }

    fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(getAdapterPosition(), getItemViewType())
        }
        return this
    }
}