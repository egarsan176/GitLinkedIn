'''
Created on 4 jun. 2021

3. Realizar un programa que solicite la fecha como tres datos numéricos 
(día, mes y año). Deberá mostrar la fecha en formato largo.
        Introduce el día de la fecha: 15
        Introduce el mes de a fecha: 3
        Introduce el año de a fecha: 2009
        La fecha en formato largo es 15 de Marzo de 2009
Si la fecha introducida es incorrecta se mostrará un mensaje de error: 
“Fecha incorrecta” y el programa terminará. El programa terminará cuando se introduzca un día negativo.

@author: estefgar
'''
#esta funcion devuelve True si el año es bisiesto y False si no lo es
def leapYear(year):
    
    resultado= False
     
    if year%4==0 and year%100!=0 or year%400==0:
        resultado=True
   
    return resultado

#esta funcion comprueba que la fecha introducida es correcta, devuelve True si lo es y False si es incorrecta  
def comprobarFecha(dia, mes, year):
    
    resultado = False 
     
    if (mes==1 or mes==3 or mes==5 or mes==7 or mes==8 or mes==10 or mes==12) and (dia >= 1 and dia <= 31):
        resultado=True
        
    elif (mes==4 or mes==6 or mes==9 or mes==11) and (dia >= 1 and dia <= 30):
        resultado=True
        
    elif mes==2 and leapYear(year)==True and dia >= 1 and dia <= 29:
        resultado=True
        
    elif mes==2 and leapYear(year)==False and dia >= 1 and dia <= 28:
        resultado=True
    
    return resultado

#esta funcion cambia el formato de la fecha introducida por parametro a formato largo
def cambiarFormatoFecha(dia, mes, year):
    
    mensaje = "La fecha en formato largo es "
    meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]
    
    if comprobarFecha(dia, mes, year) == True:
        
        mensaje+= str(dia) +" de "+ meses[mes-1] + " de " + str(year) +"."
        
    return mensaje



def principal():

    seguir = True 
    
    while seguir:
        dia = int(input("Introduce el día de la fecha: "))
        mes = int(input("Introduce el mes de la fecha: "))
        year = int(input("Introduce el año de la fecha: "))
        print("")
        
        
        if dia < 0:
            print("Fin del programa.")
            seguir = False
            print("")
            
        elif comprobarFecha(dia, mes, year) == False:
            print("Fecha Incorrecta.")
            seguir = False
            print("")
            
        else:
            print(cambiarFormatoFecha(dia, mes, year))
            print("")
        

        
principal()  