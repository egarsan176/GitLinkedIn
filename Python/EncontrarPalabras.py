'''
Created on 11 jun. 2021

Escribir una función que reciba como parámetro una cadena de palabras separadas por espacios
y devuelva, como resultado, cuántas palabras de más de cinco letras tiene la cadena dada.

@author: estefgar
'''
cadena = "Hola buenos días Margarita"

def palabrasMasCincoLetras(cadena):
    aux = ""
    contador = 0
    
    for i in cadena:
        if i != " ":
            aux+=i 
        else:
            if len(aux) > 5:
                contador += 1
            aux = ""
            
    if len(aux) > 5:    #para ver lo que queda en aux una vez salga del for
        contador += 1
    
    return "La cadena tiene %s palabras de más de cinco letras."%contador


print(palabrasMasCincoLetras(cadena))
