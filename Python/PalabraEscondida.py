'''
Created on 3 jun. 2021

Realizar una función que busque una palabra escondida dentro de un texto. Por ejemplo, si
la cadena es “shybaoxlna” y la palabra que queremos buscar es “hola”, entonces si se
encontrará y deberá devolver True, en caso contrario deberá devolver False.

@author: estefgar
'''

def estaEscondida(texto, palabra):
    contador = 0
    isFound = False
    
    for i in range(len(texto)):
        if contador<len(palabra) and texto[i] == palabra[contador]:
            contador+=1
        
    if contador == len(palabra):
        isFound = True 
        
    return isFound
