package agua.agua.co.mz.utils;

import java.util.ArrayList;
import java.util.List;

import agua.agua.co.mz.model.Clientes;

public class Dados {
    private List<Clientes> clientesList = new ArrayList<>();

    public List<Clientes> getClientesList() {

        clientesList.add(new Clientes("1","Bobole" ,"Agostinho dos santos" ,"Machava"  ,"zona"  ,"1" ,"843655568"  ,"1"  ,"1","" ,1,true));
        clientesList.add(new Clientes("1","Bobole" ,"Agostinho dos santos" ,"Machava"  ,"zona"  ,"1" ,"843655568"  ,"1"  ,"1","" ,1,false));
        clientesList.add(new Clientes("1","Bobole" ,"Agostinho dos santos" ,"Machava"  ,"zona"  ,"1" ,"843655568"  ,"1"  ,"1","" ,1,true));
        clientesList.add(new Clientes("1","Bobole" ,"Agostinho dos santos" ,"Machava"  ,"zona"  ,"1" ,"843655568"  ,"1"  ,"1","" ,1,false));
        clientesList.add(new Clientes("1","Bobole" ,"Agostinho dos santos" ,"Machava"  ,"zona"  ,"1" ,"843655568"  ,"1"  ,"1","" ,1,true));

        return clientesList;
    }

}
