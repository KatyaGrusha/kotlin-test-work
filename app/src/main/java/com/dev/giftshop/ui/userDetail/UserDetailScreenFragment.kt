package com.dev.giftshop.ui.userDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dev.giftshop.R
import com.dev.giftshop.databinding.FragmentUserDetailScreenBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailScreenFragment : Fragment() {

    private lateinit var _viewModel: UserDetailScreenViewModel
    private var _binding: FragmentUserDetailScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userId = arguments?.getInt("userId")
        _viewModel = ViewModelProvider(this)[UserDetailScreenViewModel::class.java]
        _viewModel.init(userId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_user_detail_screen,
                container,
                false
            )
        binding.lifecycleOwner = this
        initListPosts()
        initImage()
        return binding.root
    }

    private fun initImage() {
        _viewModel.userImage.observe(viewLifecycleOwner) { it ->
            Picasso.get()
                .load(it)
                .error(R.drawable.ic_user)
                .fit()
                .into(binding.imageViewFull)
        }
    }

    private fun initListPosts() {
        _viewModel.userPosts.observe(viewLifecycleOwner) { list ->
            if (binding.recyclerViewPosts.adapter == null) {
                binding.recyclerViewPosts.adapter = list?.let {
                    PostsAdapter(
                        it
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}