'''
Created on 6 jun. 2021

Escriba una función que tome una lista de números y devuelva la suma acumulada,
es decir, una nueva lista donde el primer elemento es el mismo, el segundo elemento
es la suma del primero con el segundo, el tercer elemento es la suma del resultado
anterior con el siguiente elemento y así sucesivamente.
Por ejemplo, la suma acumulada de [1,2,3] es [1, 3, 6].

@author: estefgar
'''

def sumaAcumulada(lista):
    suma = 0
    listaNueva = []
    
    
    for i in range(len(lista)):
        suma = suma + lista[i]
        listaNueva.append(suma)
    
    return listaNueva


assert(sumaAcumulada( [1,2,3]) == [1,3,6] )   
assert(sumaAcumulada( [4,6,12]) == [4,10,22] )
assert(sumaAcumulada( [5,5,5]) == [5,10,15] ) 
assert(sumaAcumulada( [21,23,25,27]) == [21,44,69,96] ) 