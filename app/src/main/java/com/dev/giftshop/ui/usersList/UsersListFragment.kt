package com.dev.giftshop.ui.usersList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dev.giftshop.R
import com.dev.giftshop.databinding.FragmentUsersListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersListFragment : Fragment() {
    private lateinit var _viewModel: UsersListViewModel
    private var _binding: FragmentUsersListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewModel = ViewModelProvider(this)[UsersListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_users_list, container, false)
        binding.lifecycleOwner = this
        initListUsers()
        return binding.root
    }

    private fun initListUsers() {
        _viewModel.userList.observe(viewLifecycleOwner) { list ->
            if (binding.usersRecycler.adapter == null) {
                binding.usersRecycler.adapter = list?.let {
                    UsersListAdapter(
                        it, ::clickedUser
                    )
                }
            }
        }
    }

    private fun clickedUser(userId: Int) {
        val bundle = Bundle()
        bundle.putInt("userId", userId)
        findNavController().navigate(R.id.userDetailScreen, bundle)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}