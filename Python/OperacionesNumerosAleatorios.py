'''
Created on 9 jun. 2021

Crea un programa que cree 60 números aleatorios de 0 a 100 (usa una constante
para fijar este número)

Muestra:
● La media de los números leídos.
● El dígito en el que más números terminan.
● En qué dígitos no ha terminado ningún número.
● Cuántos números terminan en cada uno de los dígitos (0 .. 9)

@author: estefgar
'''
import random

#esta funcion genera una lista de 60 números aleatorios entre 1 y la cantidad introducida por consola y llama a las demás
def generarNumeros():
    numeros = []
    valorMax = int(input("Introduce el valor máximo de los números de la lista: "))
    
    while len(numeros) != 60:
        num = round(random.randint(0, valorMax),0)
        numeros.append(num)
        
    print("")
    print(mostrarMedia(numeros))
    print("")
    print(mostrarDigitoMasRepetido(numeros))
    print("")
    print(mostrarDigitosNo(numeros))
    print("")
    print(cantidadDigitos(numeros))
    


#esta función muestra la media de los números de la lista
def mostrarMedia (lista):
    suma = 0
    
    for i in range(len(lista)):
        suma += lista[i]
        
    return "La media de los números leídos es %s."%round( suma/len(lista),2 )

#esta funcion muestra el dígito en el que más números de la lista terminan
def mostrarDigitoMasRepetido(lista):  
    terminaciones = [0,0,0,0,0,0,0,0,0,0]
    aux = 0
    
    for i in range(len(lista)): 
        aux = lista[i] % 10 #saco el último dígito del número
        terminaciones[aux] +=1 #la posicion de terminaciones q coincide con el digito se incrementa
        
    mas = terminaciones[0]
    for i in terminaciones:
        if i > mas:
            mas = i #saco dentro de terminaciones cual es el mayor
            
    pos = terminaciones.index(mas) #por si la cantidad es mayor a 9 para que no devueva 10,11...
                                    #saco el índice del mayor y lo devuelvo
            
    return "El dígito en el que más números terminan es %s."%pos

#esta función muestra los dígitos en los que no ha terminado ningún número de la lista
def mostrarDigitosNo(lista):
    terminaciones = [0,0,0,0,0,0,0,0,0,0]
    aux = 0
    
    mensaje = "No existe ninguna terminación de números de la lista que haya quedado a 0. "
    
    for i in range(len(lista)):
        aux = lista[i] % 10
        terminaciones[aux] +=1
     
       
    for i in range(len(terminaciones)):
        if terminaciones[i] == 0:
            mensaje = "Los dígitos en los que no ha terminado ningún número son: "
            mensaje+= str(i)+","
            
    mensaje = mensaje[:-1] #para eliminar la , final
    
    return mensaje

#esta funcion muestra cuántos números terminan en cada uno de los dígitos (0 .. 9)
def cantidadDigitos(lista):
    
    terminaciones = [0,0,0,0,0,0,0,0,0,0]
    aux = 0
    mensaje = ""
    pos = 0
    
    for i in range(len(lista)):
        aux = lista[i] % 10
        terminaciones[aux] +=1
        
    for i in range(len(terminaciones)):
        mensaje += "Existen "+str(terminaciones[i])+" números que terminan en "+str(i)+".\n"
    
    return mensaje
        
    

            
generarNumeros()  

    




