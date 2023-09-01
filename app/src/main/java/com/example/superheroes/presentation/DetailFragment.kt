package com.example.superheroes.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.superheroes.R
import com.example.superheroes.databinding.FragmentDetailBinding


private const val ARG_PARAM1 = "id"



class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    private val superheroVM: SuperheroVM by activityViewModels()


    private var param1: String? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)


        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        superheroVM.getDetailSuperheroVM(param1.toString())

        getDetailSuperhero()

        binding.btnCorreo.setOnClickListener (View.OnClickListener {
             var nombre="superman"

            sendEmail(nombre)
        }

        )
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun getDetailSuperhero() {
        superheroVM.detailLiveData(param1.toString()).observe(viewLifecycleOwner){
            if(it!=null){
                binding.idDetail.text =  it.id.toString()
                binding.nombreDetail.text = it.nombre
                binding.imageDetail.load(it.imagen)
                binding.origenDetail.text = it.origen
                binding.poderDetail.text = it.poder
                binding.anioCreacionDetail.text = it.aniocreacion.toString()
                binding.color.text = it.color

                if (it.traduccion) {
                    binding.traduccion.text = getString(R.string.cuenta_con_traducci_n_al_espa_ol)
                } else {
                    binding.traduccion.text = getString(R.string.sin_traducci_n)
                }

                }
            }
    }
    @SuppressLint("StringFormatInvalid")
    private fun sendEmail(nombre: String) {
        val receiver = getString(R.string.receiver)
        val intent = Intent(Intent.ACTION_SEND,Uri.parse(receiver))
        intent.type = "plain/text"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(receiver))
        intent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.subject,nombre))
        intent.putExtra(Intent.EXTRA_TEXT,getString(R.string.body_msn, nombre))


        startActivity(Intent.createChooser(intent,"Votación"))



    }



}