package com.orion.zenite.telas.motorista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.orion.zenite.telas.autenticacao.LogoutFragment
import com.orion.zenite.R
import com.orion.zenite.telas.motorista.fragments.MotoristaDashboard
import com.orion.zenite.telas.motorista.fragments.MotoristaQrcode
import com.orion.zenite.telas.motorista.fragments.MotoristaViagens
import kotlinx.android.synthetic.main.activity_main_fiscal.*

// tutorial barra de navegação
// https://www.youtube.com/watch?v=v8MbOjBCu0o
// https://thesimplycoder.com/289/bottom-navigation-bar-android-using-kotlin/
//https://medium.com/over-engineering/setting-up-a-material-components-theme-for-android-fbf7774da739

class MainMotorista : AppCompatActivity() {
    private val dash = MotoristaDashboard()
    private val qrcode = MotoristaQrcode()
    private val viagens = MotoristaViagens()
    private val logout = LogoutFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_motorista)
        replaceFragment(dash, "Dashboard")

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(dash, "Dashboard")
                R.id.qrcode -> replaceFragment(qrcode, getString(R.string.seu_qr_code))
                R.id.viagens -> replaceFragment(viagens, getString(R.string.historico_viagens))
                R.id.logout -> replaceFragment(logout, "Zênite")
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment, nomeTela: String){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
            val header = topAppBar;
            header.title = nomeTela
        }
    }

//    override fun OnBackPressed() {
        // TO DO : !! não retornar para tela de login quando clicar no back !!
//    }

}