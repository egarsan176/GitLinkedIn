'''
Created on 11 jun. 2021

Este programa pide primeramente la cantidad total de compras de una persona. Si la cantidad
es inferior a $100.00, el programa dirá que el cliente no aplica a la promoción. Pero si la
persona ingresa una cantidad en compras igual o superior a $100.00, el programa genera de
forma aleatoria un número entero del cero al cinco. Cada número corresponderá a un color
diferente de cinco colores de bolas que hay para determinar el descuento que el cliente
recibirá como premio. Si la bola aleatoria es color blanco, no hay descuento, pero si es
uno de los otros cuatro colores, sí se aplicará un descuento determinado según la tabla que
aparecerá, y ese descuento se aplicará sobre el total de compra que introdujo inicialmente
el usuario, de manera que el programa mostrará un nuevo valor a pagar luego de haber aplicado
el descuento.

@author: estefgar
'''
import random
import time


def mostrarMenu():
    
    mensaje = "            COLOR                DESCUENTO\n"
    mensaje += "\n"
    mensaje += "        BOLA BLANCA              NO TIENE\n"
    mensaje += "        BOLA ROJA              10 POR CIENTO\n"
    mensaje += "        BOLA AZUL              20 POR CIENTO\n"
    mensaje += "        BOLA VERDE             25 POR CIENTO\n"
    mensaje += "        BOLA AMARILLA          50 POR CIENTO\n"
    
    print( mensaje)
    
def calcularNuevaCantidadDePago():    
    opcion = 0   
    while opcion != 1: 
     
        cantidad = float(input("Introduzca la cantidad total de la compra: "))
         
        if cantidad < 100:
            print( "\nLo sentimos pero no es usted beneficiario de ninguna promoción de descuento.\n")
        else:
            print("\nSu gasto iguala o supera los 100 € y por tanto participa en la promoción.\n")
            
            mostrarMenu()
            
            pos = random.randint(0,4)
            coloresBola = ["blanca", "roja", "azul", "verde", "amarilla"]
            bola = coloresBola[pos]
            total = 0
            dto = 0
            
            print("    (En estos momentos se está escogiendo una bola al azar...)\n")
            time.sleep(3)
             
            print("Aleatoriamente usted ha obtenido una bola %s.\n"%bola)
            
             
            if bola == coloresBola[0]:
                print( "Lo sentimos. No tiene descuento.\n")
                
            elif bola == coloresBola[1]:
                
                print("Ha ganado un 10 por ciento de descuento.\n")
                
                dto = cantidad * 0.10
                total = cantidad - dto
                print("    (Procesando cantidad a pagar...)\n")
                time.sleep(3)
                print("Su nuevo total a pagar es: %s €."%total)
                
            elif bola == coloresBola[2]:
                
                print("Ha ganado un 20 por ciento de descuento.\n")
                
                dto = cantidad * 0.20
                total = cantidad - dto
                print("    (Procesando cantidad a pagar...)\n")
                time.sleep(3)
                print("Su nuevo total a pagar es: %s €."%total)
                
            elif bola == coloresBola[3]:
                
                print("Ha ganado un 25 por ciento de descuento.\n")
                
                dto = cantidad * 0.25
                total = cantidad - dto
                print("    (Procesando cantidad a pagar...)\n")
                time.sleep(3)
                print("Su nuevo total a pagar es: %s €."%total)
                
            elif bola == coloresBola[4]:
                print("Felicidades, ha ganado un 50 por ciento de descuento.\n")  
                
                dto = cantidad * 0.50
                total = cantidad - dto
                print("    (Procesando cantidad a pagar...)\n")
                time.sleep(3)
                print("Su nuevo total a pagar es: %s €."%total) 
                
        time.sleep(1)        
        opcion = int(input("\nSi desea salir presione 1 o de lo contrario presione otro número: \n"))    
    
    print("Ha salido del programa.")
    
    
calcularNuevaCantidadDePago()
    
        
        
        
        