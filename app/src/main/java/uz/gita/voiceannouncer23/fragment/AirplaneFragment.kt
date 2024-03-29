package uz.gita.voiceannouncer23.fragment

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.voiceannouncer23.R
import uz.gita.voiceannouncer23.databinding.FragmentAirplaneBinding

class AirplaneFragment : Fragment(R.layout.fragment_airplane) {
    private val binding by viewBinding(FragmentAirplaneBinding::bind)
    private val pref = MyPref.getPref()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.switchBtn.isChecked = pref.airplane
        binding.switchBtn.setOnCheckedChangeListener { buttonView, isChecked ->
            pref.airplane = !pref.airplane
            if (!pref.allAnnouncements && pref.airplane) {
                pref.allAnnouncements = pref.airplane
            }
        }
        val backBtn: ImageView = view.findViewById(R.id.backBtn)
        backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}