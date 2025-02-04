package br.senai.sp.jandira.imc.model

import java.time.LocalDate
import java.time.Period
import kotlin.math.pow

class Paciente {

    var id:Int = 0
    var nome:String = ""
    var dataNascimento: LocalDate? = null
    var email:String = ""
    var peso:Int = 0
    var altura:Double = 0.0
    var imc:Double = 0.0
    var classificacaoImc:String = ""

    fun calcularImc(): Double{
        imc = peso / altura.pow(2)
        return imc
    }

    fun mostrarDadosBiometricos(){
        println("----------------------------")
        println("Dados do Paciente")
        println("----------------------------")
        println("Nome: $nome")
        println("Peso: $peso")
        println("Altura: $altura")
        println("IMC: $imc")
        println("Classificação: $classificacaoImc")
        println("Idade: ${calcularIdade()}")
        println("----------------------------")

    }

    fun classificarImc (){
        if (imc < 18.5){
            classificacaoImc = "Abaixo do peso"
        }else if (imc > 18.5 && imc < 25.0){
            classificacaoImc = "Peso ideal"
        }else{
            classificacaoImc = "Acima do peso"
        }
    }

    fun calcularIdade (): Int{ //coloca o : e tipo para indicar que é uma função de return
        return Period.between(dataNascimento, LocalDate.now()).years
    }

}