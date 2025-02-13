package br.com.andresu.tictactoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.andresu.tictactoe.databinding.FragmentGameMenuBinding

class GameMenuFragment : Fragment() {

    private var _binding: FragmentGameMenuBinding? = null
    private val binding get() = _binding!! // Acesso seguro ao binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar o layout usando ViewBinding
        _binding = FragmentGameMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Exemplo: Manipular botão dentro do menu
        binding.btnIniciar.setOnClickListener {
            binding.txtContextMessage.text = getString(R.string.txt_message_game_started)
            binding.btnIniciar.visibility = View.GONE
            binding.btnReiniciar.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Evita memory leaks
    }

    fun startGame() {

    }
}
