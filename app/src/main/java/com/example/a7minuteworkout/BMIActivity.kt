package com.example.a7minuteworkout

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a7minuteworkout.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    companion object{
        private const val METRIC_UNITS_VIEW ="METRIC_UNITS_VIEW"
        private const val US_UNITS_VIEW ="US_UNITS_VIEW"
    }
    private var currentVisibleView : String = METRIC_UNITS_VIEW


    private var binding: ActivityBmiBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarBmiActivity)

        if (supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "CALCULATE BMI"
        }
        binding?.toolbarBmiActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

        makeVisibleMetricUnitsView()

        binding?.rgUnits?.setOnCheckedChangeListener{ _,checkedId:Int ->

            if(checkedId == R.id.rbMetricUnits){
                makeVisibleMetricUnitsView()
            }else{
                makeVisibleUsUnitsView()
            }
        }

        binding?.btnCalculateUnits?.setOnClickListener {
            calculateUnits()  
        }
    }

    private fun makeVisibleMetricUnitsView(){
        currentVisibleView = METRIC_UNITS_VIEW
        binding?.tilMetricUnitWeight?.visibility = View.VISIBLE
        binding?.tilMetricUnitHeight?.visibility = View.VISIBLE
        binding?.tilMetricUsUnitHeightFeet?.visibility = View.GONE
        binding?.tilMetricUsUnitHeightInch?.visibility = View.GONE
        binding?.tilUsMetricUnitWeight?.visibility = View.GONE

        binding?.etMetricUnitHeight?.text!!.clear()
        binding?.etMetricUnitWeight?.text!!.clear()

        binding?.llDiplayBMIResult?.visibility = View.INVISIBLE
    }

    private fun makeVisibleUsUnitsView(){
        currentVisibleView = US_UNITS_VIEW
        binding?.tilMetricUnitWeight?.visibility = View.INVISIBLE
        binding?.tilMetricUnitHeight?.visibility = View.INVISIBLE
        binding?.tilMetricUsUnitHeightFeet?.visibility = View.VISIBLE
        binding?.tilMetricUsUnitHeightInch?.visibility = View.VISIBLE
        binding?.tilUsMetricUnitWeight?.visibility = View.VISIBLE

        binding?.etUsMetricUnitWeight?.text!!.clear()
        binding?.etUsMetricUnitHeightFeet?.text!!.clear()
        binding?.etUsMetricUnitHeightInch?.text!!.clear()
    }



    private fun displayBMIResults(bmi:Float){
        val bmiLabel: String
        val bmiDescription: String

        if(bmi.compareTo(15f) <= 0){
            bmiLabel = "Very severely underweight"
            bmiDescription = "oops! you really need to take better care of yourself! Eat more!"
        }
        else if(bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0){
            bmiLabel = "Severely underweight"
            bmiDescription = "oops! you really need to take better care of yourself! Eat more!"
        }
        else if(bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0){
            bmiLabel = "Underweight"
            bmiDescription = "oops! you really need to take better care of yourself! Eat more!"
        }
        else if(bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0){
            bmiLabel = "Normal"
            bmiDescription = "Congrats you are in a good shape!"
        }
        else if(bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0){
            bmiLabel = "Overweight"
            bmiDescription = "oops! you really need to take better care of yourself! Eat little less workout more!"
        }
        else if(bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0){
            bmiLabel = "Obese Class | (Moderately obese)"
            bmiDescription = "oops! you really need to take better care of yourself! Eat less!"
        }
        else if(bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0){
            bmiLabel = "Obese Class | (Severely obese)"
            bmiDescription = "oops! you really need to take better care of yourself! Act now!"
        }else{
            bmiLabel = "obese class || (Very Severely obese)"
            bmiDescription = "you are in a dangerous condition! Act now"
        }

        val bmiValue = BigDecimal(bmi.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

        binding?.llDiplayBMIResult?.visibility = View.VISIBLE
        binding?.tvBMIValue?.text = bmiValue
        binding?.tvBMIType?.text = bmiLabel
        binding?.tvBMIDescription?.text = bmiDescription

    }

    private fun validateMetricUnits(): Boolean{
        var isValid = true

        if(binding?.etMetricUnitWeight?.text.toString().isEmpty()){
            isValid= false
        }else if(binding?.etMetricUnitHeight?.text.toString().isEmpty()){
            isValid = false
        }
        return isValid
    }

    private fun calculateUnits(){
        if(currentVisibleView == METRIC_UNITS_VIEW){
            if(validateMetricUnits()){
                val heightValue :Float = binding?.etMetricUnitHeight?.text.toString().toFloat()/100
                val weightValue :Float = binding?.etMetricUnitWeight?.text.toString().toFloat()

                val bmi = weightValue/(heightValue*heightValue)

                displayBMIResults(bmi)
            }else{
                Toast.makeText(this, "enter valid data", Toast.LENGTH_SHORT).show()
            }
        }else{
            if(validateUsUnits()){
                val usUnitHeightValueFeet: String =
                    binding?.etUsMetricUnitHeightFeet?.text.toString()
                val usUnitHeightValueInch: String =
                    binding?.etUsMetricUnitHeightInch?.text.toString()
                val usUnitWeightValue: Float =
                    binding?.etUsMetricUnitWeight?.text.toString().toFloat()

                val heightValue =
                    usUnitHeightValueInch.toFloat() + usUnitHeightValueFeet.toFloat() * 12

                val bmi = 703 * (usUnitWeightValue/ (heightValue * heightValue))

                displayBMIResults(bmi)
            }else{
                Toast.makeText(this, "enter valid data", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun validateUsUnits():Boolean {
        var isValid = true
        when{
            binding?.etUsMetricUnitWeight?.text.toString().isEmpty() ->{
                isValid = false
            }
            binding?.etUsMetricUnitHeightFeet?.text.toString().isEmpty() ->{
                isValid = false
            }
            binding?.etUsMetricUnitHeightInch?.text.toString().isEmpty() ->{
                isValid = false
            }
        }
        return isValid
    }
}