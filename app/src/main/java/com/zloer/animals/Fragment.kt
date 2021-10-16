package com.zloer.animals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.zloer.animals.databinding.FragmentBinding
import java.util.*

class Fragment : Fragment() {

    private var _binding: FragmentBinding? = null

    private val animals = mapOf(
        "Ёжик" to R.drawable.hedgehog,
        "Кроль" to R.drawable.rabbit,
        "Обезьяна" to R.drawable.monkey,
        "Кабан" to R.drawable.boar,
        "Бык" to R.drawable.bull,
        "Кот" to R.drawable.cat
    )
    private val random: Random = Random()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val animal = animals.entries.elementAt(random.nextInt(animals.size))
            binding.imageview.setImageResource(animal.value)
            binding.textview.text = animal.key
            Toast.makeText(context, animal.key, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}