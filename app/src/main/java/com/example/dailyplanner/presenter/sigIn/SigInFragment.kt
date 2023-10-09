package com.example.dailyplanner.presenter.sigIn

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.dailyplanner.R
import com.example.dailyplanner.databinding.FragmentSigInBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class SigInFragment : Fragment() {

    companion object {
        fun newInstance() = SigInFragment()
    }

    @Inject
    lateinit var sigInFactory:SigInFactory

    private val viewModel: SigInViewModel by viewModels { sigInFactory }
    lateinit var binding:FragmentSigInBinding
    var regFlag=true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSigInBinding.inflate(inflater)
        viewModel.isAuth()
        initBtn()


        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.state.collect{
                when(it){
                    is SigInState.Loading -> {

                    }
                    is SigInState.Success -> {
                       findNavController().navigate(R.id.action_sigInFragment_to_mainFragment)
                    }
                    is SigInState.Error -> {

                    }
                    SigInState.UserAuth -> {
                        findNavController().navigate(R.id.action_sigInFragment_to_mainFragment)
                    }
                }
            }

        }

        return binding.root
    }

    private fun initBtn() {
        binding.txtReg.setOnClickListener {
            if (regFlag){
                binding.txtReg.text="Есть аккаунт. Войти"
                binding.buttonSignIn.text="Регистрация"
                regFlag=false
                binding.editTextName.visibility=View.VISIBLE
            }else{
                binding.txtReg.text="Нет аккаунта. Зарегистрироваться"
                binding.buttonSignIn.text="Войти"
                regFlag=true
                binding.editTextName.visibility=View.GONE
            }
        }

        binding.buttonSignIn.setOnClickListener {
            if (regFlag){
                viewModel.signIn(binding.editTextLogin.text.toString(),binding.editTextPassword.text.toString())
            }else{
                viewModel.signUp(binding.editTextLogin.text.toString(),binding.editTextPassword.text.toString(),binding.editTextName.text.toString())
            }
        }
    }

}