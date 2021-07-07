'''
Created on 11 jun. 2021

Procesamiento de telegramas. Un oficial de correos decide optimizar el trabajo de su oficina
cortando todas las palabras de más de cinco letras a sólo cinco letras (e indicando que una
palabra fue cortada con el agregado de una arroba). Además elimina todos los espacios en blanco de más.

Por ejemplo, al texto " Llego mañana alrededor del mediodía " se transcribe como "Llego mañan@ alred@ del medio@".

Por otro lado cobra un valor para las palabras cortas y otro valor para las palabras largas (que deben ser cortadas).

Escribir una función que reciba un texto, la longitud máxima de las palabras, el costo de cada
palabra corta, el costo de cada palabra larga, y devuelva como resultado el texto del telegrama
y el costo del mismo.
Los puntos se reemplazan por la palabra especial "STOP", y el punto final (que puede faltar en
el texto original) se indica como "STOPSTOP".
Al texto:

" Llego mañana alrededor del mediodía. Voy a almorzar "

Se lo transcribe como:

"Llego mañan@ alred@ del medio@ STOP Voy a almor@ STOPSTOP".

Extender la función anterior para agregar el tratamiento de los puntos.

@author: estefgar
'''

def telegrama(cadena, costoCorta, costoLarga):
    
    simbCortada = "@"
    simbPunto =  "STOP"
    aux = ""
    telegrama = ""
    lista = []
    pos = 0
    larga = 0
    corta = 0
    
    #para eliminar el espacio blanco del principio y final si los tuviera
#     if cadena[0] == " " and cadena[-1] == " ":
#         cadena = cadena[1:-1]  
    cadena = cadena.strip()
        
    
    #guardo en una lista las palabras para omitir los espacios y luego contar su longitud
    # y transformo los . en STOP
    for i in cadena:
        if i[-1] == ".":
            lista.append(aux)
            aux = ""
            aux+= simbPunto
            lista.append(aux)
            aux = ""
        elif i != " ":
            aux += i 
        else:
            lista.append(aux)
            aux = ""
                
    
    #voy creando la nueva cadena, acortando las palabras de más de 5 letras
    #incremento lso contadores de palabra corta y palabra larga
    for i in range(len(lista)):
        
        if len(lista[pos]) > 1 and len(lista[pos]) <=5: #si la palabra mide entre 1 y 5
            
            if lista[pos] != simbPunto:
                telegrama += lista[pos]+" "
                corta += 1  #si no es un STOP incremento el contador de CORTA
                
            elif lista[pos] == simbPunto and pos < len(lista)-1:
                telegrama += lista[pos]+" "
            
            else:
                telegrama += lista[pos] #por si es un STOP de final de cadena que no ponga espacio
            pos+=1
            
        elif len(lista[pos]) > 5:   #si la palabra tiene mas de 5 letras
            aux = lista[pos]
            aux = aux[:5]   #me quedo con las 5 primeras letras de la palabra
            telegrama += aux+simbCortada+" "    #le añado el @
            larga+=1    #incremento el contador de LARGAS
            pos+=1
            
        elif len(lista[pos]) == 1 and lista[pos] != " ":    #si es una palabra de una letra
            telegrama+= lista[pos]+" "
            corta+=1    #incremento el contador de CORTAS
            pos+=1
            
        else:
            pos+=1
       
    #para hacer el STOPSTOP del punto final   
    if telegrama[-4:] == simbPunto: #si las ultimas 4 letras son STOP
        telegrama += simbPunto
        
    elif telegrama[-4:] != simbPunto:
        telegrama += simbPunto + simbPunto
         
    costeEnvio = (larga * costoLarga) + (corta * costoCorta)
        
            
    print("El texto de su telegrama es:\n")
    print("\t> "+telegrama+"\n")
    print("El coste del envío es de %s €."%costeEnvio)
    


cadena = " Llego mañana alrededor del mediodía.  Voy a almorzar. "    

telegrama(cadena, 0.2, 0.5)


        






