package com.example.marsrover.view.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.marsrover.databinding.FragmentSavedBinding
import com.example.marsrover.model.Photo

class SavedFragment : Fragment() {

    private lateinit var mBind: FragmentSavedBinding
    private val binding get() = mBind
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { SavedAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBind = FragmentSavedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(SavedViewModel::class.java)
        recyclerView = binding.recyclerViewFav
        recyclerView.adapter = adapter
        viewModel.getAllSavedPhoto().observe(viewLifecycleOwner,{
            adapter.setList(it.asReversed())
        })
        val itemTouchHelper = ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean = false

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val item = adapter.getItem(viewHolder.adapterPosition)
                    viewModel.deleteAllSavedPhoto(item as Photo)
                    adapter.notifyItemRemoved(viewHolder.adapterPosition)

                }
            }
        )
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}
