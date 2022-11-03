package di_example;

class A {
    //public B b = new B();
    public C b = new C();

    public void setX(X x){
        this.X;=x;
    }
    // b.method();
}


class B implements X{
    // memoryDB ==> repository


    @Override
    public void method() {
        System.out.println("B");
    }
}

class C implements X{
    // mysql ==> repository


    @Override
    public void method() {
        System.out.println("C");
    }
}

interface X {
    public void method();
}

public class DI_main {
    public static void main(String[] args) {
        A a = new A();

        @Autowired
        a.setX(X);
    }
}
