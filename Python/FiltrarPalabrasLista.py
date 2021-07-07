'''
Created on 9 jun. 2021

Escribir una función filtrar_palabras() que tome una lista de palabras y un entero n,
y devuelva las palabras que tengan mas de n caracteres. 

@author: estefgar
'''

lista = ["playa", "sol", "arena", "ola", "agua"]
numero = 3

def filtrar_palabras(lista, numero):
    nueva = []
    
    for i in range(len(lista)):
        
        if len(lista[i]) > numero:
            nueva.append(lista[i])
            
    return nueva
     
print(filtrar_palabras(lista, numero))    
    