'''
Created on 9 jun. 2021

Escribir un programa que pregunte por consola el precio de un producto en euros
con dos decimales y muestre por pantalla el número de euros y el número de céntimos
del precio introducido.

@author: estefgar
'''
def mostrarPrecio():
    precio = input("Introduzca el precio del producto con dos decimales: (€.cc) ")
    
    pos = precio.index(".") #me guardo la posicion del . que separa euros de decimales
    
    while len(precio[pos:]) != 3:    #para averiguar que tiene dos decimales
        print("Formato incorrecto.")
        precio = input("Introduzca el precio del producto con dos decimales: (€.cc) ")
           
    euros = precio[:pos]
    centimos = precio[-2:]
    mensaje = "Ha introducido "+euros+" € y "+centimos+" céntimos."
        
    return mensaje



print(mostrarPrecio())



