package Species;                    //En este apartado creo una carpeta con el nombre Species el cual me archivara todas las clases a excepcion del Main.
public class Cat extends Mammal{    //El extends lo utlizo en cada clase de forma que todos esten entrelazados, desde los de abajo hasta el main.

    //Constructor 
    public Cat(String Cat) throws Exception{            //Creo un constructor tipo gato, el cual me lanza una Exception.
        super(Cat);                                     //El cual llamo con el super Cat.
        try{                                            //Luego controlo con try, en donde si tiene patas negativas.
            setLegs(4);
        }catch(Exception E){
            System.out.println(E.getMessage());         //Que de como reultado un mensage de Error.
        }
    }

    //Metodos
    public void define(){                                                    //En este aparatado creo un metodo de tipo void, en donde luego defino un contador nuevamente.
        contador2++;
        System.out.println("[Number of calls to define: "+contador2+"]");   //El cual solo me devuelve un mesanje de las clases creadas, en donde añado el contador y en el terminal da com resultado un numero.
        System.out.println(" My name is "+name+".");                        //De igual forma imprimo un mensaje con el nombre del animal.
        super.define();                                                     //Luego llamo al super para seguir introduciendo el siguiente comentario en la cadena de la misma clase.
        System.out.println("- As a Cat, I have retractile claws.");         //El cual se añade con la clase animal y luego Mamifero.
    }
    
    public void legs(){                                                     //Creo un metodo tipo piernas de forma publica.
        System.out.println("As a Cat, I have "+getLegs()+" legs.");         //El cual solo me devuelve las piernas del gato. 
    }

    public void climbATree(){                                               //Un metodo publico el cual, es personal del Gato.
        if (S == true){                                                     //En donde si la variable S tipo boolean es igual True.
        System.out.println("The Animal is not alive");                      //Me devuelva el mensaje.
        }
    }

    public boolean pair(Animal x) throws Exception{                         //Creo un metodo publico tipo booleano el cual me tira una Exception, el cual su funcion es emparejar los animales.

        boolean P = x instanceof Cat;                                       //Creo una instancea booleana P, hacia Gato.
        if (P  == true && mario == null){                                   //En donde si la variable es verdadera y mi animal mario es igual a null.
            System.out.println("Pair Ok.");                                 //Simplemente que lo empareje.
            mario = x;                                                      //Y se guarde en Animal
        }
        else if(P  == true && mario != null){                               //Luego con el else if digo que si quieres volver a emparejar otra especie, esta ya esta emparejada.
            System.out.println("Already paired with "+mario);               //Luego que solo me imprima el mensaje. 
        }
        else{                                                                    
        throw new Exception("Animals cannot pair with different species.");     //Luego que me imprima este mensaje.
        }
        return false;       //Luego que retorne falso.
    }
    public String toString(){   //Como se menciono antes continuo con el metodo toString.                  
        super.toString();       //El cual se guarda en el super.
        return text += ".CAT";  //Seguido por el mensaje que he añadido.
    }
   
}