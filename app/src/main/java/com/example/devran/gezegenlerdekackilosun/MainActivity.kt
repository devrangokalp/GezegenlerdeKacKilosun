package com.example.devran.gezegenlerdekackilosun

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener{


    var KILO_TO_POUND=2.2045
        var MARS=0.38
        var POUND_TO_KILO=0.45359237
    var VENUS=0.66
    var JUPİTER=0.88

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cbMars.setOnClickListener(this)
        cbVenus.setOnClickListener(this)
        cbJupiter.setOnClickListener(this)

       /*   var kulaniciKilo=etKiloGir.text
          btnHesapla.setOnClickListener {

          var kullaniciAgirlikPound=kiloToPound(kulaniciKilo.toString().toDouble())
          var marstakiAgirlikPound=kiloToPound(kullaniciAgirlikPound)
          var marstakiAgirlikKilo=poundToKilo(marstakiAgirlikPound.toString().toDouble())

          tvSonuc.text=marstakiAgirlikKilo.formatla(2).toString()
      }
      */

    }
    fun kiloToPound(kilo:Double):Double
    {

        return kilo*KILO_TO_POUND*MARS
    }
    fun poundToKilo(pound:Double):Double{

        return pound*POUND_TO_KILO
    }
    override fun onClick(v: View?) {
        v as CheckBox
        var kullaniciKilo=etKiloGir.text.toString().toDouble()

        if (!TextUtils.isEmpty(etKiloGir.text.toString())) {
            var kullaniciPound = kiloToPound(kullaniciKilo)
            var isChecked: Boolean = v.isChecked

            when (v.id) {
                R.id.cbMars -> if (isChecked ) {
                    hesaplaAgirlikPound(kullaniciKilo, v)
                    cbJupiter.isChecked=false
                    cbVenus.isChecked=false
                }
                R.id.cbVenus -> if (isChecked) {
                    hesaplaAgirlikPound(kullaniciKilo, v)
                    cbJupiter.isChecked=false
                    cbMars.isChecked=false
                }
                R.id.cbJupiter -> if (isChecked) {
                    hesaplaAgirlikPound(kullaniciKilo, v)
                    cbMars.isChecked=false
                    cbVenus.isChecked=false
                }
            }
        }
    }

    fun hesaplaAgirlikPound(pound:Double,checkBox:CheckBox)
    { var  sonuckilo:Double=0.0
      when(checkBox.id)
      {
          R.id.cbMars ->sonuckilo=pound*MARS
          R.id.cbVenus ->sonuckilo=pound*VENUS
          R.id.cbJupiter ->sonuckilo=pound*JUPİTER
          else ->sonuckilo=0.0

      }
        var sonucToKilo=poundToKilo(sonuckilo)
        tvSonuc.text=sonucToKilo.toString()
    }


    fun Double.formatla(kactane:Int)=java.lang.String.format("%.${kactane}f",this)

}
