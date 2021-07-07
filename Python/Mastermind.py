'''
Created on 14 jun. 2021

Este reto es una adaptación del juego Mastermind (que utiliza fichas de colores) haciendo uso de
números.
El objetivo es adivinar una cifra secreta de 4 dígitos (pueden ser distintos o no, 3301, 1234, etc.) en
un máximo de 7 intentos.
Para ello, el jugador introduce una cadena de 4 dígitos y el programa la compara con la cifra secreta
indicando el número de coincidencias de la clave que aparecen en la cadena y el número de
posiciones correctas acertadas.
Por ejemplo, si la clave es 3301 y el jugador introduce 8910 el programa diría:
Coinciden 2 dígitos
Ninguno en posición correcta
Si introduce 8931 diría:
Coinciden 2 dígitos
1 dígito en posición correcta
El programa termina cuando se ha acertado la cifra secreta (dígitos y posición), o bien, cuando se ha
superado el número máximo de intentos.
Puedes incrementar la dificultad del juego pidiendo al usuario que selecciones el grado de dificultad
(longitud de la clave secreta, número máximo de intentos).
La clave secreta la puedes generar automáticamente con
ThreadLocalRandom.current().nextInt(1000, 10000)

@author: estefgar
'''
import random

def comprobarClave():
    
    intentos = 0
    claveSecreta = random.randint(1000, 10000)
    #print(claveSecreta)
    
    claveSecreta = str(claveSecreta)
    
    isFound = False 
    
    while intentos < 7 and not isFound:
        
        contadorAciertos = 0
        contadorCoincid = 0
        
        clave = pedirClave()
        
        if clave == claveSecreta:
            isFound = True 

        
        for i in range (len(claveSecreta)):
            for j in range(len(clave)):
                if claveSecreta[i] == clave[j]:
                    contadorCoincid += 1
                    if i == j:
                        contadorAciertos +=1
                    
        
        if contadorAciertos <= 0 and contadorCoincid <= 0:
            print( "Coinciden 0 dígitos.\nNinguno en posición correcta.")
        elif clave == claveSecreta:
            print("¡Enhorabuena has acertado la clave secreta!")
        else:
            print( "Coinciden %s dígitos.\n%d en posición correcta"%(contadorCoincid, contadorAciertos)) 
        
        intentos += 1
       
        
        
    
        
def pedirClave():
    
    clave = input("Escribe una clave de cuatro dígitos: ")
    
    return clave

comprobarClave()
    
    
        



