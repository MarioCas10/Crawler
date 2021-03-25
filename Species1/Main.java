import Species.*;      //En este aparatado importo todos los packages asiganados en las clases anteriores el cual me crea una carpeta con los documentos en orden.
class Main {
    public static void main(String args[]) throws Exception{        //Aqui lanzo el Exception para controlar los errores del programa. 
        boolean result;

        System.out.println(" -- Start --");

        Animal a1 = new Cat("Beerus");
        //a1.beBorn();

        Animal a2 = new Dolphin("Ecco");
        a2.beBorn();

        Animal a3 = new Snake("Venom");
        a3.beBorn();

        Animal a4 = new Turtle("Leonardo");
        a4.beBorn();

        System.out.println(a1);
        a1.define();

        System.out.println(a2);
        a2.define();

        System.out.println(a3);
        a3.define();

        System.out.println(a4);
        a4.define();


        //a1.suckle();
        Mammal m1 = (Mammal) a1;
        m1.suckle();

        Cat c1 = (Cat) a1;
        c1.climbATree();

        Reptile r1 = (Reptile) a3;
        r1.layAnEgg();

        //a4.hideInsideShell();
        Turtle t1 = (Turtle) a4;
        t1.layAnEgg();
        t1.hideInsideShell();

        Animal aa1 = new Animal("Whatever");
        aa1.legs();
        Mammal mm1 = new Mammal("Otherwhatever");
        mm1.legs();
        a1.legs();

        //Simplemente añado un try y un cacth a todos los animales el cual me controle el Error al momento de emparejar las especies.
        try{
            result = c1.pair(t1);
        }catch(Exception E){
            System.out.println(E.getMessage());
            }

        try{
            result = c1.pair(aa1);
        }catch(Exception E){
            System.out.println(E.getMessage());
        }

        Cat c2 = new Cat("Lala");
        try{
            result = c1.pair(c2);
        }catch(Exception E) {
                System.out.println(E.getMessage());
        }

        Cat c3 = new Cat("Lolo");
        try{
            result = c1.pair(c3);
        }catch(Exception E){
                System.out.println(E.getMessage());
        }

        System.out.println(" -- End --");
    }

}
