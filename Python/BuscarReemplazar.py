'''
Created on 3 jun. 2021

Diseñar una función que reciba como parámetro tres cadenas, la primera será una frase y
deberá buscar si existe la palabra que recibe como segundo parámetro y reemplazarla por la
tercera.

@author: estefgar
'''

# def buscarYreemplazar(frase, palabra, palNueva):
#     contador = 0
#     mensaje = ""
#     #aux= ""
#     
#     if len(palabra) > len(frase):
#         mensaje = "La longitud de la palabra a buscar no puede ser mayor a la de la frase."
#     
#     for i in range(len(frase)):
#         if contador < len(palabra) and frase[i] == palabra[contador]:
#             contador+=1
#             #aux+= frase[i]
#             
#     if contador == len(palabra):
#         mensaje = frase.replace(palabra, palNueva)
#         
#     return mensaje
# 
#         
# print(buscarYreemplazar("Hola malos dias", "malos", "buenos"))
# print(buscarYreemplazar("Linterna", "Linternilla", "error"))
        
    
frase ="Hola malos, dias"    
palabra = "malos"
palNueva = "buenos"

contadorFrase = 0
nuevaFrase = ""
contadorPal = 0

while contadorFrase < len(frase): #recorre la frase en toda su longitud
    igual = True
    contadorPal = 0 #reinicio el contador de la palabra una vez que ya la he encontrado
    
    while igual and contadorPal < len(palabra):  #busca la palabra
        if palabra[contadorPal] != frase[contadorFrase+contadorPal]:
            igual = False
        contadorPal+=1
        
    if igual == False:
        nuevaFrase+= frase[contadorFrase]   #concatena la frase
        contadorFrase+=1 
    else:
        for i in palNueva:
            nuevaFrase+=i   #hace el reemplazo
        contadorFrase+=len(palabra) 

print(nuevaFrase)
    
    
    
    

   