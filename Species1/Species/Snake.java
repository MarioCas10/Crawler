package Species;                            //En este apartado creo una carpeta con el nombre Species el cual me archivara todas las clases a excepcion del Main.
public class Snake extends Reptile{         //El extends lo utlizo en cada clase de forma que todos esten entrelazados, desde los de abajo hasta el main.

    //Constructor 
    public Snake(String Snake) throws Exception{        //Creo un constructor de forma publica el cual me lanza una excepcion.
        super(Snake);                                   //En donde se archive en el super.Snake.
        try{                                            //El cual afirmo que las patas en el caso de la Snake tienen que ser iguales a 0. 
            setLegs(0);

        }catch(Exception E){                            //Si las patas no son iguales a 0.
            System.out.println(E.getMessage());         //Me de el mensaje de Error que llamo desde animales con el getMessage. 
        }
    }

    //Metodos 
    public void define(){                                                   //En este aparatado creo un metodo de tipo void, en donde luego defino un contador nuevamente.
        contador2++;
        System.out.println("[Number of calls to define: "+contador2+"]");   //El cual solo me devuelve un mesanje de las clases creadas, en donde añado el contador y en el terminal da com resultado un numero.
        System.out.println("My name is "+name+".");                         //De igual forma imprimo un mensaje con el nombre del animal.
        super.define();                                                     //Luego llamo al super para seguir introduciendo el siguiente comentario en la cadena de la misma clase.
        System.out.println("- As a Snake, I have no legs.");                //El cual se añade con la clase animal y luego Mamifero.
    }

    public void legs(){                             //Creo un metodo publico tipo void.
        System.out.println("I'm not sure ...");     //El cual solo imprime el mensaje que el animal no esta seguro que tiene patas.
    }

    public void layAnEgg(){     //Creo un metedo publico tipo void.
        super.layAnEgg();       //El cual llamo con el super, que imprima el mensaje de la clase Reptile, en donde deja el huevo.
    }

    public String toString(){       //Como se menciono antes continuo con el metodo toString.
        super.toString();           //El cual se guarda en el super.
        return text += ".SNAKE";    //Seguido por el mensaje que he añadido.
    }
}
