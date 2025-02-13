package br.com.andresu.tictactoe

import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class GameGridFragment : Fragment() {

    private lateinit var gridLayout: GridLayout
    private val size = 3
    private val cells = Array(size) { arrayOfNulls<TextView>(size) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game_grid, container, false)
        gridLayout = view.findViewById(R.id.gridLayout)

        // Definir tamanho dos quadrados (de acordo com a tela)
        val squareSize = resources.displayMetrics.widthPixels / size - 80

        // Criar os elementos no GridLayout
        for (row in 0 until size) {
            for (col in 0 until size) {
                val cell = TextView(requireContext()).apply {
                    layoutParams = GridLayout.LayoutParams().apply {
                        width = squareSize
                        height = squareSize
                        setMargins(8, 8, 8, 8)
                    }
                    setBackgroundResource(R.drawable.square_tile)
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 32f)
                    gravity = Gravity.CENTER
                    setPadding(16, 16, 16, 16)
                    text = ""
                    setOnClickListener {
                        handleCellClick(row, col)
                    }
                }
                gridLayout.addView(cell)
                cells[row][col] = cell
            }
        }

        return view
    }

    private fun handleCellClick(row: Int, col: Int) {
        val cell = cells[row][col]
        if (cell?.text.isNullOrEmpty()) {
            cell?.text = "X" // Coloca um "X" na célula quando clicado
        }
    }
}
