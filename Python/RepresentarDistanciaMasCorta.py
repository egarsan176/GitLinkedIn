'''
Created on 2 jun. 2021

Dada una cadena S y un carácter C, devolver un array de enteros representando la distancia más
corta desde cada carácter en la cadena hasta la posición del carácter C.
Ejemplo 1:
Entrada: "algoritmo", 'o'
Salida: [3, 2, 1, 0, 1, 2, 2, 1, 0]
Ejemplo 2:
Entrada: "abcdefga", 'a'
Salida: [0, 1, 2, 3, 3, 2, 1, 0]
Precondiciones:
- La longitud de S está en [1, 10000].
- C es un único carácter.
- C se encuentra en S.
- Todas las letras en S y C son minúsculas.

@author: estefgar
'''
#esta funcion representa la distancia mas corta desde cada caracter de una cadena has la posicion del caracter introducido
def representarDistanciaMasCorta(palabra, caracter):
    
    palabra = palabra.lower()
    caracter = caracter.lower()

    pos = []    
    distancia = []
    
    for i in range(len(palabra)): 
        if palabra[i] == caracter:  #busco las posiciones que coinciden con el caracter que estoy buscando
            pos.append(i)           #guardo las posiciones en una lista
    
    
    
    for i in range(len(palabra)):
        if palabra[i] == caracter:  #si la letra es la misma que el caracter, añado un 0
            distancia.append(0)
        else:
            min = 99999999999999
            for j in pos:           #recorro la lista de posiciones
                if abs(i-j) < min:  #si el valor absoluto de i-j es menor que el minimo, hago de ese el min
                    min = abs(i-j)  #tras acabar el for, el min sera la menor distancia encontrada
            distancia.append(min)   #guardo el resultado (el minimo) en la lista
                
                
    return distancia

print(representarDistanciaMasCorta("algoritmo", "o"))
print(representarDistanciaMasCorta("abcdefga", "a"))


  