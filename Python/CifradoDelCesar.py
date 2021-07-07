'''
Created on 2 jun. 2021

Encriptar un mensaje usando el método de “la cifra del cesar”, que consiste en desplazar cada letra,
considerando la posición de cada una en el alfabeto, una determinada cantidad de lugares. Por
ejemplo: si el desplazamiento es de 2 lugares, la palabra “HOLA” se transforma en “JQNC”.
Si el alfabeto termina antes de poder desplazar la cantidad de lugares necesarios, se vuelve a
comenzar desde la letra ‘a’.
Nota: considerar el alfabeto en castellano de 27 letras.

@author: estefgar
'''
#esta funcion recibe una palabra y devuelve otra que es el resultado de desplazar los 
#caracteres de la primera en el abecedario el numero de veces indicado en el desplazamiento
def encriptarPalabras(palabra, desplazamiento):
    
    alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"

    palabra = palabra.upper()
     
    palabraCifrada = ""
    
    for i in palabra:
        if i in alfabeto:   #busco la i de la palabra en el abecedario
            palabraCifrada+= alfabeto[(alfabeto.index(i)+desplazamiento) % len(alfabeto)]
                                #me guardo la posicion que ocupa i en el alfabeto y le sumo el desplazamiento
                                # lo del % es porque es como la formula del DNI, que para calcular la letra hay
                                #que dividir entre la longitud de la lista y quedarse con el resto
                                # recuerdo: letras[dni%len(letras)]
        else:
            palabraCifrada+=i
            
    return "La palabra < "+palabra+" > se transforma en < "+palabraCifrada+" >"

print(encriptarPalabras("hola", 2))
print(encriptarPalabras("adios", 25))


print("\t\t-------------")

#opcion con dos bucles anidados
def cifraDelCesar(palabra, desplazamiento):
    
    alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
    
    palabra = palabra.upper()
    palabraCifrada = ""

    
    for i in range(len(palabra)):       
        for j in range(len(alfabeto)):
             
            if palabra[i] == alfabeto[j]:   #cuando encuentre la letra en el abecedario
                 
                if j+desplazamiento > len(alfabeto):    #si la posicion de la letra más el desplazamiento supera la longitud del abecedario
                    j = j-len(alfabeto)     #modifico el valor de j 
                                            #por ejemplo si j fuera la z su posicion sería 27
                                            #27 - len(alfabeto) = 0
                palabraCifrada += alfabeto[j+desplazamiento]    #en el mismo ejemplo, sería 0+desplazamiento
                

                    
    return "La palabra < "+palabra+" > se transforma en < "+palabraCifrada+" >"

print(cifraDelCesar("hola", 2))
print(cifraDelCesar("adios", 25))


