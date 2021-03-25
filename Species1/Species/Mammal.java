package Species;                           //En este apartado creo una carpeta con el nombre Species el cual me archivara todas las clases a excepcion del Main.
public class Mammal extends Animal{        //El extends lo utlizo en cada clase de forma que todos esten entrelazados, desde los de abajo hasta el main.

    //Constructor                
    public Mammal(String name) throws Exception{          //Creo un constructor publico mammal, de tipo super, para accceder a los metodos y atributos de la clase padre
        super(name);                                      //El cual llamare atraves de los metodos contructores hijos.
    }                                                     //Y que a su vez me tire una excepcion.

    //Metodos
    public void define(){                                               //Creo un metodo define de forma publica, el cual lo utilizo como super.define.
        super.define();
        System.out.println("- As a MAMMAL, I have mammary glands.");    //Luego que me imprima este mensaje en cada clase de animal Mamifero.
    }
    
    public void legs(){                                                          //Aqui creo otro metodo de tipo void, el cual no me devuelve nada.
        System.out.println("As a MAMMAL, I don't know how many legs I have.");   //Me devuelve simeplemente este mensaje debajo de la instancea creada num 6.
    }
    
    public void suckle(){                                                        //Aqui creo otro metodo tipo void, pero en este metodo es para comprobar si el animal nacio de forma correcta o no.
        if (S == true){                                                          //En donde lo controlo con una variable String n, dentro del metedo el cual si es verdad que no a nacido el animal.
        System.out.println("The Animal is not alive");                           //Por siguente me imprima el mensaje. De lo contrario no imprima nada.
        }
    }

    public String toString(){                                                    //Aqui creo otro metodo de forma publica, el cual se denomia toString, el cual funciona como una cadena de carecteres.
        super.toString();                                                        //En este caso que me almacene los comentarios que les vaya agregando y se forma una cadena, como antes lo mecione.
        return text += ".MAMMAL";                                                //El cual me retorna tipo texto y que me vaya añadiendo los textos que desee, el cual para seguir archivado textos solo lo llamo en otra clase como el mismo metodo.
    }
    
    
}
