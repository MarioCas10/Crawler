package Species;                        //En este apartado creo una carpeta con el nombre Species el cual me archivara todas las clases a excepcion del Main.
public class Turtle extends Reptile{    //El extends lo utlizo en cada clase de forma que todos esten entrelazados, desde los de abajo hasta el main.

    //Constructor 
    public Turtle(String Turtle) throws Exception{       //Creo un constructor de forma publica el cual me lanza una excepcion.
        super(Turtle);                                   //En donde se archive en el super.Turtle.
        try{                                             //El cual afirmo que las patas tienen que ser iguales a 4. 
            setLegs(4);

        }catch(Exception E){                             //Si las patas no son iguales a 4.
            System.out.println(E.getMessage());          //Me de el mensaje de Error que llamo desde animales con el getMessage.
        }
    }

    //Metodos 
    public void define(){                                                   //En este aparatado creo un metodo de tipo void, en donde luego defino un contador nuevamente.
        contador2++;
        System.out.println("[Number of calls to define: "+contador2+"]");   //El cual solo me devuelve un mesanje de las clases creadas, en donde añado el contador y en el terminal da com resultado un numero.
        System.out.println("My name is "+name+".");                         //De igual forma imprimo un mensaje con el nombre del animal.
        super.define();                                                     //Luego llamo al super para seguir introduciendo el siguiente comentario en la cadena de la misma clase.
        System.out.println("- As a Turtle, I love Pizza !!!");              //El cual se añade con la clase animal y luego Mamifero.
    }

    public void hideInsideShell(){                          //Creo un metodo de tipo publico void, el cual es para la tortuga en donde se esconda dentro de caparazon.
        if (S == true){                                     //En donde si es verdad.
        System.out.println(text+ " -> hide inside shell");  //Me imprima el mensaje. 
        }
    }

    public void legs(){                             //Creo un metodo publico tipo void.
        System.out.println("I'm not sure ...");     //El cual solo imprime el mensaje que el animal no esta seguro que tiene patas.
    }

    public void layAnEgg(){     //Creo un metedo publico tipo void.
        super.layAnEgg();       //El cual llamo con el super, que imprima el mensaje de la clase Reptile, en donde deja el huevo.
    }

    public String toString(){       //Como se menciono antes continuo con el metodo toString.
        super.toString();           //El cual se guarda en el super.
        return text += ".TURTLE";   //Seguido por el mensaje que he añadido.
    }

}
