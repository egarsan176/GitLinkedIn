'''
Created on 10 jun. 2021

Crea un programa que dado un texto y un “cameo” a buscar, sea capaz de
encontrar el número de veces que dicho cameo aparece en el texto, sin tener en cuenta las
mayúsculas, y con la posibilidad de que las letras originales estén separadas. Antes de empezar

Por ejemplo, el cameo “Stan Lee” aparecería dos veces en “Eres tan lento que te ganaria una
oruga. ¿Esto es canela, verdad que si?”, pero cero veces en “¿Dónde e st arían los coches?”

@author: estefgar
'''


def buscarCameoEnTexto(cameo, texto):
    posCameo = 0
    pos = 0
    aux = ""
    contador = 0
    
    
    cadena1 = cameo.replace(" ", "").casefold()
    cadena2 = texto.casefold() 
     
    while len(aux) < len(cadena1) and pos < len(cadena2):
        
        if cadena1[posCameo] == cadena2[pos]:
            aux += cadena1[posCameo]
            posCameo+=1
        
        if aux == cadena1:      
            contador+=1
            aux = ""
            posCameo = 0
            
        pos+=1
              
    
    return 'El cameo "%s" aparece un total de %d veces en el texto.'%(cameo,contador)


print(buscarCameoEnTexto("Stan Lee", "Eres tan lento que te ganaria una oruga. ¿Esto es canela, verdad que si?"))




