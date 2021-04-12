class Debo{
    int data;
    Debo forward1;
    Debo forward2;
    Debo backward;
}
public class Demo {
    public static void main(String[] args) {
        Demo obj = new Demo();
        Debo d = obj.f1(1,null);
        while (d!=null){
            System.out.println(d.data + "   ");
            d = d.forward1;
        }
    }
    Debo f1(int data, Debo prevDebo ){
        if(data==5){
            return null;
        }
        Debo debo1 = new Debo();
        debo1.data = data;
        Debo nextDebo = f1(data+1, debo1);
        debo1.forward1 = nextDebo;
        debo1.forward2 = nextDebo;
        debo1.backward = prevDebo;
        return debo1;
    }
//    Debo f2(int data, Debo prevDebo){
//        Debo debo1 = new Debo();
//        debo1.data = data;
//        Debo nextDebo3 = f3(data +1, debo1);
//        debo1.forward1 =  nextDebo3;
//        debo1.forward2 =  nextDebo3;
//        debo1.backward = prevDebo;
//        return debo1;
//    }
//    Debo f3(int data, Debo prevDebo){
//        Debo debo1 = new Debo();
//        debo1.data = data;
//        Debo  nextDebo4 = f4(data +1, debo1);
//        debo1.forward1 = nextDebo4;
//        debo1.forward2 = nextDebo4;
//        debo1.backward = prevDebo;
//        return debo1;
//    }
//    Debo f4(int data, Debo prevDebo){
//        Debo debo1 = new Debo();
//        debo1.data = data;
//        debo1.forward1 = null;
//        debo1.forward1 = null;
//        debo1.backward = debo3;
//        return debo1;
//    }
}
