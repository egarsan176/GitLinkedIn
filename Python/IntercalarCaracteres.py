'''
Created on 9 jun. 2021

Realizar un método que reciba como entrada dos cadenas de caracteres y devuelva una
tercera cadena intercalando los caracteres de las palabras de las cadenas recibidas.
Ejemplo: “abcdfgh” y “123” devolvería “a1b2c3dfgh”

@author: estefgar
'''


def intercalarCaracteres(cad1, cad2):
    aux = ""
    nueva = ""
    
    if len(cad1) < len(cad2):   #establezco que la cad1 siempre sea mayor que la cad2
        
        aux = cad1
        cad1 = cad2
        cad2 = aux
        
    pos = 0
    for i in range(len(cad1)):
        nueva+=cad1[i]          #añado un caracter de la cadena larga
        if pos < len(cad2):     #compruebo que la cadena corta todavia tiene caracteres
            nueva+=cad2[pos]    #añado un caracter de la cadena corta
            pos+=1              #incremento pos para que en la siguiente vuelta coja el valor del siguiente caracter
                   
    return nueva

assert(intercalarCaracteres("abcdfgh", "123") == "a1b2c3dfgh")
assert(intercalarCaracteres("123", "abcdfgh") == "a1b2c3dfgh")
assert(intercalarCaracteres("aaaa", "HHHHHHH") == "HaHaHaHaHHH")



def intercalar(cad1, cad2): #version de joaquin modificada 
    pos = 0
    cadenaFinal = ""
    
    for i in cad1:
        if pos < len(cad2):
            cadenaFinal += i+cad2[pos]
            pos += 1
        else:
            cadenaFinal += i
          
    aux = len(cad1)+1           
    cadenaFinal+=cad2[aux:]
    
            
    return cadenaFinal


def intercalarCadenas(cad1, cad2):

    nueva = ""
    pos = 0
    
    
    while len(nueva) < (len(cad1)+len(cad2)):   #se ejecuta mientras se de esa condición
        
        if pos < len(cad1) and pos < len(cad2): #si pos es menor que la longitud de ambas cadenas
            nueva += cad1[pos] + cad2[pos]      #añade de las dos cadenas
            
        elif pos < len(cad1):                   #si pos es menor que la longitud de la cad1, añade solo de la cadena 1
            nueva+= cad1[pos]                   #porque cad2 seria mayor que pos y no entraría aquí
            
        else:
            nueva+= cad2[pos]                   #si pos es menor que la longitud de la cad2, añade solo de la cadena 2
                                                #porque cad1 seria mayor que pos y no entraría aquí
            
        pos+=1                                  #incremento pos para recorrer toda la cadena
        
    return nueva
 
 
print("JOAQUÍN\n")
print(intercalar("123", "abcdfgh"))
print(intercalar("abcdfgh", "123"))
  
print("   ---------")
  
print("ESTEFANÍA\n")
  
print(intercalarCaracteres("123", "abcdfgh"))
print(intercalarCaracteres("abcdfgh", "123"))   

print("   ---------")
  
print("iterador\n")

print(intercalarCadenas("123", "abcdfgh"))
print(intercalarCadenas("abcdfgh", "123"))   









