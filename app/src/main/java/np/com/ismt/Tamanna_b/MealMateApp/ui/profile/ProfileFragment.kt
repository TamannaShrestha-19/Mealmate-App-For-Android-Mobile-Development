package np.com.ismt.Tamanna_b.MealMateApp.ui.profile

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.firestore.FirebaseFirestore
import np.com.ismt.Tamanna_b.MealMateApp.MainActivity
import np.com.ismt.Tamanna_b.MealMateApp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private var db: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        setUpViews()
        return binding.root
    }

    private fun setUpViews() {
        binding.tvUserName.text = "Tamanna"
        binding.mbLogOut.setOnClickListener {
            setUpLogOutButton()
        }
    }

    private fun setUpLogOutButton() {
        MaterialAlertDialogBuilder(requireActivity())
            .setTitle("Alert")
            .setMessage("Are you sure want to logout?")
            .setPositiveButton(
                "Yes",
                DialogInterface.OnClickListener { dialogInterface,
                                                  i ->
                    logOut()
                })
            .setNegativeButton(
                "No",
                DialogInterface.OnClickListener { dialogInterface,
                                                  i ->
                    dialogInterface.dismiss()
                })
            .show()
    }

    private fun logOut() {
        //Navigating to login Page
        val intent = Intent(requireActivity(), MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
}