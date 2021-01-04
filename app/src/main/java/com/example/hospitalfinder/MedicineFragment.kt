package com.example.hospitalfinder

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MedicineFragment : Fragment() {

    companion object {
        fun newInstance() = MedicineFragment()
    }

    private lateinit var viewModel: MedicineViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.medicine_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MedicineViewModel::class.java)
        // TODO: Use the ViewModel
        // getText: Return a localized, CharSequence from the application's package's default string table.
        // getActivity: Return the FragmentActivity this fragment is currently associated with. May return null if the fragment is associated with a Context instead.
        viewModel.run { activity?.getText(0) }
    }

}